package chess.game;

import chess.game.board.Board;
import chess.game.move.Move;
import chess.game.player.*;
import chess.utilities.BoardPrinter;

import java.util.*;

public class ChessGame implements Game {

    private final Board board;
    private final Map<PlayerColor, Player> players = new HashMap<>();
    private PlayerColor playerWhoHasTurn = PlayerColor.WHITE;
    private final List<Move> doneMoves = new ArrayList<>();

    private boolean singlePlayer = false;
    private boolean hasStarted = false;
    private boolean hasEnded = false;

    public ChessGame(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
        board = new Board();
        board.setPiecesToStartPosition();
        BoardPrinter.printPieces(board);
    }

    @Override
    public void addPlayer(PlayerColor color, String username) {

        if (players.size() == 0) {
            Player player;
            if (username.isBlank()) {
                player = new HumanPlayer(color, "Player One");
            } else {
                player = new HumanPlayer(color, username);
            }
            players.put(color, player);
            if (singlePlayer) {
                Player computerPlayer = new ComputerPlayer(getOtherPlayerColor(color), "Computer");
                computerPlayer.setReady(true);
                players.put(computerPlayer.getColor(), computerPlayer);
            }
        } else if (players.size() == 1 && !players.containsKey(color)) {
            Player player;
            if (username.isBlank()) {
                player = new HumanPlayer(color, "Player Two");
            } else {
                player = new HumanPlayer(color, username);
            }
            players.put(color, player);
        } else {
            // Show max number of players message
        }
    }

    @Override
    public void setPlayerReady(PlayerColor color) {
        players.get(color).setReady(true);

        boolean allPlayersReady = true;
        for (Player player : players.values()) {
            if (!player.isReady()) {
                allPlayersReady = false;
                break;
            }
        }

        if (allPlayersReady) {
            startGame();
        }
    }

    @Override
    public void makeMove(PlayerColor color, int originColumn, int originRow, int targetColumn, int targetRow) {

        // Check if game is started and player has turn
        if (hasStarted && playerWhoHasTurn == color) {

            // Check if there is a piece on the selected square
            if (board.getSquare(originColumn, originRow).isEmpty()) {
                //TODO Show Message To Player
            }
            // Check if piece belongs to player
            else if (board.getSquare(originColumn, originRow).hasOpponentPiece(color)) {
                //TODO Show Message To Player
            } else if (!board.getSquare(originColumn, originRow).getPiece().getValidMoves(board).contains(board.getSquare(targetColumn,targetRow))) {
                //TODO Show Message To Player
            } else {
                Move playerMove = HumanMoveStrategy.makeHumanMove(board, color, originColumn, originRow, targetColumn, targetRow);
                doneMoves.add(playerMove);
                BoardPrinter.printPieces(board);
                switchTurns();
                // Let Computer make move when in single player
                if (singlePlayer) {
                    Move computerMove = ComputerMoveStrategy.makeComputerMove(board, playerWhoHasTurn);
                    doneMoves.add(computerMove);
                    BoardPrinter.printPieces(board);
                    switchTurns();
                }
            }
        } else {
            //TODO Show Message To Player
        }
    }

    @Override
    public void undoLastMove(PlayerColor color) {
        if (hasStarted && !doneMoves.isEmpty() && playerWhoHasTurn != color) {
            Move undoneMove = doneMoves.get(doneMoves.size() - 1);
            undoneMove.undo();
            doneMoves.remove(undoneMove);
            switchTurns();
        }
    }

    @Override
    public void pauseGame(PlayerColor color) {

    }

    @Override
    public void restartGame(PlayerColor color) {
        doneMoves.clear();
        board.setPiecesToStartPosition();
    }

    @Override
    public void resign(PlayerColor color) {
        players.get(color).resign();
        hasEnded = true;
    }

    public PlayerColor getOtherPlayerColor(PlayerColor color) {
        if (color == PlayerColor.WHITE) {
            return PlayerColor.BLACK;
        } else {
            return PlayerColor.WHITE;
        }
    }

    private void startGame() {
        hasStarted = true;
    }

    private Player getPlayerWhoHasTurn() {
        return players.get(playerWhoHasTurn);
    }

    private void switchTurns() {
        if (playerWhoHasTurn == PlayerColor.WHITE) {
            playerWhoHasTurn = PlayerColor.BLACK;
        } else {
            playerWhoHasTurn = PlayerColor.WHITE;
        }
    }
}
