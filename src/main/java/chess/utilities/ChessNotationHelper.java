package chess.utilities;

import chess.game.board.Square;

public class ChessNotationHelper {

    private ChessNotationHelper() {
        throw new IllegalStateException("Utility Class");
    }

	/*
		Get the square name based on its position.
		Columns (X) are named by letters from a to h.
		Rows (y) are named by numbers from 1 to 8.
		To convert a column to a letter, the ASCII table is used.
		In the ASCII table 'a' is 97 in decimal and 'h' is 104.
	 */

    public static String arrayCoordinateToAlgebraicNotation(int column, int row) {
        if (column < 0 || column > 7 || row < 0 || row > 7) {
            throw new IllegalArgumentException("Coordinate is outside chess board");
        } else {
            return (char) (column + 97) + Integer.toString(row + 1);
        }
    }

    public static String squareToAlgebraicNotation(Square square) {
        int column = square.getColumn();
        int row = square.getRow();
        if (column < 0 || column > 7 || row < 0 || row > 7) {
            throw new IllegalArgumentException("Coordinate is outside chess board");
        } else {
            return (char) (column + 97) + Integer.toString(row + 1);
        }
    }
}
