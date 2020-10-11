package chess.game.pieces;

import chess.game.player.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(PlayerColor playerColor) {
        super(PieceType.KING, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {
        List<Square> validMoves = new ArrayList<>();

        // Horizontal Right
        addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition());
        // Horizontal Left
        addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition());
        // Vertical Up
        addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 1);
        // Vertical Down
        addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 1);
        // Diagonal Left And Down
        addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 1);
        // Diagonal Left And Up
        addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 1);
        // Diagonal Right And Down
        addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 1);
        // Diagonal Right And Up
        addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 1);

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
