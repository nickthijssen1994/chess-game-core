package chess.engine.pieces;

import chess.engine.PlayerColor;
import chess.engine.board.Board;
import chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

	protected final int columnPosition;
	protected final int rowPosition;
	protected final PlayerColor playerColor;

	Piece(final int columnPosition, final int rowPosition, final PlayerColor playerColor) {
		this.columnPosition = columnPosition;
		this.rowPosition = rowPosition;
		this.playerColor = playerColor;
	}

	public abstract List<Move> calculateLegalMoves(final Board board);
}
