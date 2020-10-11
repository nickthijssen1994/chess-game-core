package chess.game;

import chess.*;
import chess.game.board.Board;
import chess.game.board.Square;
import chess.game.move.Move;
import chess.game.pieces.Piece;
import chess.game.pieces.PieceType;
import chess.game.player.*;

import java.util.ArrayList;
import java.util.List;

public class ChessGame implements Game {

    private final Board board;
    private final List<Player> players = new ArrayList<>();
    private final List<Move> doneMoves = new ArrayList<>();

    private boolean singlePlayer = false;
    private boolean hasStarted = false;
    private boolean hasEnded = false;

    public ChessGame(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
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
            if(singlePlayer){
                players.add(new ComputerPlayer());
            }
        } else if (players.size() == 1) {
            if (player.getUsername().isBlank()) {
                player.setUsername("Player Two");
            }
            player.setPlayerColor(PlayerColor.BLACK);
            player.setHasTurn(false);
            players.add(player);
        }
    }

    @Override
    public void setPlayerReady(Player player) {
        if (hasStarted) {
        } else if (players.size() != 2) {

        } else {
            for (Player addedPlayer : players) {
                if (addedPlayer.getPlayerId() == player.getPlayerId()) {
                    addedPlayer.setReady(true);
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

        }

        //TODO replace returning true or false by useful message notification to client
        // Check if player has turn
        else if (!player.hasTurn()) {

        } else {

            Square selectedOriginSquare = board.getSquare(originColumn, originRow);
            Square selectedTargetSquare = board.getSquare(targetColumn, targetRow);

            // Check if there is a piece on the selected square
            if (selectedOriginSquare.isEmpty()) {

            } else {
                Piece piece = selectedOriginSquare.getPiece();

                // Check if the selected piece belongs to player
                if (piece.getPlayerColor() != player.getPlayerColor()) {

                } else if (!piece.getValidMoves(board).contains(selectedTargetSquare)) {

                } else {
                    //TODO Search for check or checkmate
                    //TODO Also check for special moves like castling, en passant or pawn promotion
                    Move doneMove = new Move(doneMoves.size() + 1,
                            player.getPlayerColor(),
                            selectedOriginSquare,
                            selectedTargetSquare);
                    doneMove.execute();

                    doneMoves.add(doneMove);
                    switchTurns();
                }
            }
        }
    }

    @Override
    public void undoLastMove(Player player) {
        if (!hasStarted) {

        } else if (!doneMoves.isEmpty()) {
            Move undoneMove = doneMoves.get(doneMoves.size() - 1);
            if (undoneMove.getPlayerColor() == player.getPlayerColor() && !player.hasTurn()) {
                undoneMove.undo();

                doneMoves.remove(undoneMove);
                switchTurns();
            } else {

            }
        } else {

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
            if (addedPlayer.getPlayerId() != player.getPlayerId()) {
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
    }
}
