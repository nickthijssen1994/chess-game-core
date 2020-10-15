package chess.engine.pieces;

import chess.engine.PlayerColor;
import chess.engine.board.*;

import java.util.*;

public class Knight extends Piece {

	private static final int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

	Knight(final int piecePosition, final PlayerColor playerColor) {
		super(piecePosition, playerColor);
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {

		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();

		for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
			candidateDestinationCoordinate = this.piecePosition + currentCandidate;

			if (true) {
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				if (!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new Move());
				}
				else {
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final PlayerColor pieceColor = pieceAtDestination.getPlayerColor();

					if (this.playerColor != pieceColor) {
						legalMoves.add(new Move());
					}
				}
			}
		}
		return Collections.unmodifiableList(legalMoves);
	}
}
