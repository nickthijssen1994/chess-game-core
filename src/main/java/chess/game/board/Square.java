package chess.game.board;

import chess.game.player.PlayerColor;
import chess.game.pieces.Piece;

public class Square {

    private final int column;
    private final int row;
    private Piece piece;

    public Square(int column, int row) {
        this.column = column;
        this.row = row;
        this.piece = null;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        if (piece != null) {
            piece.setPosition(column, row);
        }
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean hasOpponentPiece(PlayerColor playerColor) {
        return piece.getPlayerColor() != playerColor;
    }
}
