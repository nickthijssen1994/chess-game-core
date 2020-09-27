package nl.nickthijssen.chesscore.game.pieces;

import nl.nickthijssen.chesscore.PieceType;
import nl.nickthijssen.chesscore.PlayerColor;
import nl.nickthijssen.chesscore.game.board.Board;
import nl.nickthijssen.chesscore.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(PlayerColor playerColor) {
        super(PieceType.ROOK, playerColor);
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
        for (int column = getColumnPosition() - 1; column >= 0; column--) {
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
        for (int row = getRowPosition() - 1; row >= 0; row--) {
            if (!super.addMoveIfValid(board, validMoves, getColumnPosition(), row)) {
                break;
            }
        }

        return validMoves;
    }
}
