package chess.engine.pieces;

import chess.engine.PlayerColor;
import chess.engine.board.*;

import java.util.*;

public class Bishop extends Piece {

	private static final int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-9, -7, 7, 9};

	Bishop(final int piecePosition, final PlayerColor playerColor) {
		super(piecePosition, playerColor);
	}

	@Override
	public List<Move> calculateLegalMoves(final Board board) {

		final List<Move> legalMoves = new ArrayList<>();

		for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int candidateDestinationCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				candidateDestinationCoordinate += candidateCoordinateOffset;

				if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
					final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
					if (!candidateDestinationTile.isTileOccupied()) {
						legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
					} else {
						final Piece pieceAtDestination = candidateDestinationTile.getPiece();
						final PlayerColor pieceColor = pieceAtDestination.getPlayerColor();

						if (this.playerColor != pieceColor) {
							legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate,
									pieceAtDestination));
						}
					}
					break;
				}
			}
		}

		return Collections.unmodifiableList(legalMoves);
	}
}
