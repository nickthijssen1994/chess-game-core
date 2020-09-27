package nl.nickthijssen.chesscore.game.pieces;

import nl.nickthijssen.chesscore.PieceType;
import nl.nickthijssen.chesscore.PlayerColor;
import nl.nickthijssen.chesscore.game.board.Board;
import nl.nickthijssen.chesscore.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(PlayerColor playerColor) {
        super(PieceType.KNIGHT, playerColor);
    }

    @Override
    public List<Square> getValidMoves(Board board) {
        List<Square> validMoves = new ArrayList<>();

        super.addMoveIfValid(board, validMoves, getColumnPosition() + 2, getRowPosition() + 1);

        super.addMoveIfValid(board, validMoves, getColumnPosition() + 2, getRowPosition() - 1);

        super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() - 2);

        super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() - 2);

        super.addMoveIfValid(board, validMoves, getColumnPosition() - 2, getRowPosition() - 1);

        super.addMoveIfValid(board, validMoves, getColumnPosition() - 2, getRowPosition() + 1);

        super.addMoveIfValid(board, validMoves, getColumnPosition() + 1, getRowPosition() + 2);

        super.addMoveIfValid(board, validMoves, getColumnPosition() - 1, getRowPosition() + 2);

        return validMoves;
    }
}
