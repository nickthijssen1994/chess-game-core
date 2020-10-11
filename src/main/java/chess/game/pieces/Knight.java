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
