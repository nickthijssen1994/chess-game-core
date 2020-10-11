package chess.game.player;

import chess.game.board.Board;
import chess.game.move.Move;

import java.util.Random;

public class ComputerMoveStrategy {

    private ComputerMoveStrategy() {
        throw new IllegalStateException("Utility Class");
    }

    // TODO Implement Computer AI Logic
    public static Move makeComputerMove(Board board, PlayerColor color) {
        Random random = new Random();
        int originColumn = random.nextInt(8);
        int originRow = random.nextInt(8);
        int targetColumn = random.nextInt(8);
        int targetRow = random.nextInt(8);

        boolean foundValidOrigin = false;
        boolean foundValidTarget = false;

        while (!foundValidOrigin) {
            if (board.getSquare(originColumn, originRow).isEmpty() || board.getSquare(originColumn, originRow).hasOpponentPiece(color)) {
                foundValidOrigin = false;
                originColumn = random.nextInt(8);
                originRow = random.nextInt(8);
            }
            else if(board.getSquare(originColumn,originRow).getPiece().getValidMoves(board).isEmpty()){
                foundValidOrigin = false;
                originColumn = random.nextInt(8);
                originRow = random.nextInt(8);
            }
            else {
                foundValidOrigin = true;
            }
        }

        while (!foundValidTarget) {
            if (board.getSquare(originColumn, originRow).getPiece().getValidMoves(board).contains(board.getSquare(targetColumn, targetRow))) {
                foundValidTarget = false;
                targetColumn = random.nextInt(8);
                targetRow = random.nextInt(8);
            }
            else {
                foundValidTarget = true;
            }
        }

        Move move = new Move(color, board.getSquare(originColumn, originRow), board.getSquare(targetColumn,targetRow));
        move.execute();
        return move;
    }
}
