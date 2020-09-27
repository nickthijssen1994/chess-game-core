package chess.game;

import chess.*;
import chess.game.board.Board;
import chess.game.board.Square;
import chess.game.move.Move;
import chess.game.pieces.Piece;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChessGame implements Game {

    private GameManager gameManager;

    private Board board;
    private List<Player> players = new ArrayList<>();
    private List<Move> doneMoves = new ArrayList<>();

    private boolean hasStarted = false;
    private boolean hasEnded = false;
    private Date startTime;
    private Date endTime;

    public ChessGame(GameManager gameManager) {
        this.gameManager = gameManager;
        board = new Board();
        board.setPiecesToStartPosition();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.isEmpty()) {
            if (player.getUsername().isBlank()) {
                player.setUsername("Player One");
            }
            player.setPlayerColor(PlayerColor.WHITE);
            player.setHasTurn(true);
            players.add(player);
            gameManager.processPlayerAdded(player);
            gameManager.processPlayerTurn(players, getPlayerWhoHasTurn());
            gameManager.processPieceLocations(player, board.getPieceLocations());
            gameManager.processShowMessageToPlayer(player, "Waiting For Other Player To Join");
        } else if (players.size() == 1) {
            if (player.getUsername().isBlank()) {
                player.setUsername("Player Two");
            }
            player.setPlayerColor(PlayerColor.BLACK);
            player.setHasTurn(false);
            players.add(player);
            gameManager.processPlayerAdded(player);
            gameManager.processOpponentAdded(player, getOtherPlayer(player));
            gameManager.processOpponentAdded(getOtherPlayer(player), player);
            gameManager.processPlayerTurn(players, getPlayerWhoHasTurn());
            gameManager.processPieceLocations(player, board.getPieceLocations());
            gameManager.processShowMessageToPlayers(players, "Waiting For Players To Be Ready");
        }
    }

    @Override
    public void setPlayerReady(Player player) {
        if (hasStarted) {
            gameManager.processShowMessageToPlayer(player, "Game Has Already Started");
        } else if (players.size() != 2) {
            gameManager.processShowMessageToPlayer(player, "Waiting For Other Player To Join");
        } else {
            for (Player addedPlayer : players) {
                if (addedPlayer.getSessionId().equals(player.getSessionId())) {
                    addedPlayer.setReady(true);
                    gameManager.processShowMessageToPlayer(getOtherPlayer(addedPlayer),
                            player.getUsername() + " Is " + "Ready To Start");
                }
            }

            boolean playersReady = true;
            for (Player addedPlayer : players) {
                if (!addedPlayer.isReady()) {
                    playersReady = false;
                    break;
                }
            }

            if (playersReady) {
                startGame();
            }
        }
    }

    @Override
    public void makeMove(Player player, int originColumn, int originRow, int targetColumn, int targetRow) {

        if (!hasStarted) {
            gameManager.processShowMessageToPlayer(player, "Game Hasn't Started Yet");
        }

        //TODO replace returning true or false by useful message notification to client
        // Check if player has turn
        else if (!player.hasTurn()) {
            gameManager.processShowMessageToPlayer(player, "Not Your Turn");
        } else {

            Square selectedOriginSquare = board.getSquare(originColumn, originRow);
            Square selectedTargetSquare = board.getSquare(targetColumn, targetRow);

            // Check if there is a piece on the selected square
            if (selectedOriginSquare.isEmpty()) {
                gameManager.processShowMessageToPlayer(player, "No Piece Selected");
            } else {
                Piece piece = selectedOriginSquare.getPiece();

                // Check if the selected piece belongs to player
                if (piece.getPlayerColor() != player.getPlayerColor()) {
                    gameManager.processShowMessageToPlayer(player, "Not Your Piece");
                } else if (!piece.getValidMoves(board).contains(selectedTargetSquare)) {
                    gameManager.processShowMessageToPlayer(player, "Invalid Move");
                } else {
                    //TODO Search for check or checkmate
                    //TODO Also check for special moves like castling, en passant or pawn promotion
                    Move doneMove = new Move(doneMoves.size() + 1,
                            player.getPlayerColor(),
                            selectedOriginSquare,
                            selectedTargetSquare);
                    doneMove.execute();
                    gameManager.processMoveDone(players, doneMove);
                    doneMoves.add(doneMove);
                    switchTurns();
                }
            }
        }
    }

    @Override
    public void undoLastMove(Player player) {
        if (!hasStarted) {
            gameManager.processShowMessageToPlayer(player, "Game Hasn't Started Yet");
        } else if (!doneMoves.isEmpty()) {
            Move undoneMove = doneMoves.get(doneMoves.size() - 1);
            if (undoneMove.getPlayerColor() == player.getPlayerColor() && !player.hasTurn()) {
                undoneMove.undo();
                gameManager.processMoveUndone(players, undoneMove);
                doneMoves.remove(undoneMove);
                switchTurns();
            } else {
                gameManager.processShowMessageToPlayer(player, "Move can not be undone");
            }
        } else {
            gameManager.processShowMessageToPlayer(player, "No moves done yet");
        }
    }

    @Override
    public void pauseGame(Player player) {

    }

    @Override
    public void restartGame(Player player) {
        doneMoves.clear();
        board.setPiecesToStartPosition();
    }

    @Override
    public void resign(Player player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return players.size();
    }

    @Override
    public boolean getHasStarted() {
        return hasStarted;
    }

    @Override
    public boolean getHasEnded() {
        return hasEnded;
    }

    @Override
    public Player getOtherPlayer(Player player) {
        for (Player addedPlayer : players) {
            if (!addedPlayer.getSessionId().equals(player.getSessionId())) {
                return addedPlayer;
            }
        }
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public List<Move> getDoneMoves() {
        return doneMoves;
    }

    @Override
    public List<PieceLocation> getPieceLocations() {
        return board.getPieceLocations();
    }

    private void startGame() {
        hasStarted = true;
        startTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String date = formatter.format(startTime);
        gameManager.processShowMessageToPlayers(players, "Game Started At " + date);
        gameManager.processStartGame(this);
    }

    private Player getPlayerWhoHasTurn() {
        for (Player player : players) {
            if (player.hasTurn()) {
                return player;
            }
        }
        return null;
    }

    private boolean isKingInCheck(PlayerColor playerColor) {
        for (Piece piece : board.getPlayerPieces(playerColor)) {
            if (piece.getPieceType() == PieceType.KING && piece.canBeCaptured(board)) {
                return true;
            }
        }
        return false;
    }

    private void switchTurns() {
        for (Player player : players) {
            player.setHasTurn(!player.hasTurn());
        }
        gameManager.processPlayerTurn(players, getPlayerWhoHasTurn());
    }
}
