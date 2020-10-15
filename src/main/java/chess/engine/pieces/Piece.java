package chess.engine.pieces;

import chess.engine.PlayerColor;
import chess.engine.board.Board;
import chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

	protected final int piecePosition;
	protected final PlayerColor playerColor;

	Piece(final int piecePosition, final PlayerColor playerColor) {
		this.piecePosition = piecePosition;
		this.playerColor = playerColor;
	}

	public PlayerColor getPlayerColor(){
		return this.playerColor;
	}

	public abstract List<Move> calculateLegalMoves(final Board board);
}
