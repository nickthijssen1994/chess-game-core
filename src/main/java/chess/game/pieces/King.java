package chess.game.pieces;

import chess.PieceType;
import chess.PlayerColor;
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
        super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition());
        // Horizontal Left
        super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition());
        // Vertical Up
        super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() + 1);
        // Vertical Down
        super.addMoveIfValid(board, validMoves, getColumnPosition(), getRowPosition() - 1);
        // Diagonal Left And Down
        super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 1);
        // Diagonal Left And Up
        super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 1);
        // Diagonal Right And Down
        super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 1);
        // Diagonal Right And Up
        super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 1);

        return validMoves;
    }
}
