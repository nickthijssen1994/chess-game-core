package chess.game.pieces;

import chess.game.player.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(PlayerColor playerColor) {
        super(PieceType.PAWN, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {

        List<Square> validMoves = new ArrayList<>();

        // For White Pawns
        if (super.getPlayerColor() == PlayerColor.WHITE) {
            addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 1, true);
            if (!super.getHasMoved()) {
                addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 2, true);
            }
            addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 1, false);
            addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 1, false);
        }

        // For Black Pawns
        if (super.getPlayerColor() == PlayerColor.BLACK) {
            addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 1, true);
            if (!super.getHasMoved()) {
                addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 2, true);
            }
            addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 1, false);
            addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 1, false);
        }

        return validMoves;
    }

    private boolean addMoveIfValid(Board board, List<Square> validMoves, int targetColumn, int targetRow, boolean forward) {
        if (targetColumn >= 0 && targetRow >= 0 && targetColumn <= 7 && targetRow <= 7) {
            Square targetSquare = board.getSquare(targetColumn, targetRow);
            if (forward && targetSquare.isEmpty()) {
                validMoves.add(targetSquare);
                return true;
            } else if (!forward && !targetSquare.isEmpty()) {
                if (targetSquare.hasOpponentPiece(super.getPlayerColor())) {
                    validMoves.add(targetSquare);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
