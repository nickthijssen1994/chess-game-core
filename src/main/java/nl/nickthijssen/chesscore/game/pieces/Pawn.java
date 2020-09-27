package nl.nickthijssen.chesscore.game.pieces;

import nl.nickthijssen.chesscore.PieceType;
import nl.nickthijssen.chesscore.PlayerColor;
import nl.nickthijssen.chesscore.game.board.Board;
import nl.nickthijssen.chesscore.game.board.Square;

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
        if (this.getPlayerColor() == PlayerColor.WHITE) {
            super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 1);
            if (!this.getHasMoved()) {
                super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 2);
            }
            super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 1);
            super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 1);
        }

        // For Black Pawns
        if (this.getPlayerColor() == PlayerColor.BLACK) {
            super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 1);
            if (!this.getHasMoved()) {
                super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 2);
            }
            super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 1);
            super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 1);
        }

        return validMoves;
    }
}
