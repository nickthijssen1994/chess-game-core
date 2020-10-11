package chess.game.pieces;

import chess.game.player.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(PlayerColor playerColor) {
        super(PieceType.BISHOP, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {

        List<Square> validMoves = new ArrayList<>();

        // Diagonal To Top Right
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition() + diagonal,
                    getRowPosition() + diagonal)) {
                break;
            }
        }

        // Diagonal To Top Left
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition() - diagonal,
                    getRowPosition() + diagonal)) {
                break;
            }
        }

        // Diagonal To Bottom Right
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition() + diagonal,
                    getRowPosition() - diagonal)) {
                break;
            }
        }

        // Diagonal To Bottom Left
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition() - diagonal,
                    getRowPosition() - diagonal)) {
                break;
            }
        }

        return validMoves;
    }
}
