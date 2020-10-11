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
            if (!addMoveIfValid(board, validMoves, getColumnPosition() + diagonal,
                    getRowPosition() + diagonal)) {
                break;
            }
        }

        // Diagonal To Top Left
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!addMoveIfValid(board, validMoves, getColumnPosition() - diagonal,
                    getRowPosition() + diagonal)) {
                break;
            }
        }

        // Diagonal To Bottom Right
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!addMoveIfValid(board, validMoves, getColumnPosition() + diagonal,
                    getRowPosition() - diagonal)) {
                break;
            }
        }

        // Diagonal To Bottom Left
        for (int diagonal = 1; diagonal < 7; diagonal++) {
            if (!addMoveIfValid(board, validMoves, getColumnPosition() - diagonal,
                    getRowPosition() - diagonal)) {
                break;
            }
        }

        return validMoves;
    }

    private boolean addMoveIfValid(Board board, List<Square> validMoves, int targetColumn, int targetRow) {
        if (targetColumn >= 0 && targetRow >= 0 && targetColumn <= 7 && targetRow <= 7) {
            Square targetSquare = board.getSquare(targetColumn, targetRow);
            if (targetSquare.isEmpty()) {
                validMoves.add(targetSquare);
                return true;
            } else if (targetSquare.hasOpponentPiece(super.getPlayerColor())) {
                validMoves.add(targetSquare);
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
