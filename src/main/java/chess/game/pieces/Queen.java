package chess.game.pieces;

import chess.PieceType;
import chess.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(PlayerColor playerColor) {
        super(PieceType.QUEEN, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {

        List<Square> validMoves = new ArrayList<>();

        // Horizontal To Right
        for (int column = getColumnPosition() + 1; column < 8; column++) {
            if (!super.addMoveIfValid(board, validMoves, column, getRowPosition())) {
                break;
            }
        }

        // Horizontal To Left
        for (int column = getColumnPosition() - 1; column > 0; column--) {
            if (!super.addMoveIfValid(board, validMoves, column, getRowPosition())) {
                break;
            }
        }

        // Vertical To Top
        for (int row = getRowPosition() + 1; row < 8; row++) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition(), row)) {
                break;
            }
        }

        // Vertical To Bottom
        for (int row = getRowPosition() - 1; row > 0; row--) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition(), row)) {
                break;
            }
        }

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
