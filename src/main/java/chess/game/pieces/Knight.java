package chess.game.pieces;

import chess.game.player.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(PlayerColor playerColor) {
        super(PieceType.KNIGHT, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {
        List<Square> validMoves = new ArrayList<>();

        addMoveIfValid(board, validMoves, getColumnPosition() + 2, getRowPosition() + 1);

        addMoveIfValid(board, validMoves, getColumnPosition() + 2, getRowPosition() - 1);

        addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 2);

        addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 2);

        addMoveIfValid(board, validMoves, getColumnPosition() - 2, getRowPosition() - 1);

        addMoveIfValid(board, validMoves, getColumnPosition() - 2, getRowPosition() + 1);

        addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 2);

        addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 2);

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
