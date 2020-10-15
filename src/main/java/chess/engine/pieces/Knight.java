package chess.engine.pieces;

import chess.engine.PlayerColor;
import chess.engine.board.*;

import java.util.*;

import static chess.engine.board.BoardUtils.isValidTileCoordinate;

public class Knight extends Piece {

	private static final int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

	Knight(final int piecePosition, final PlayerColor playerColor) {
		super(piecePosition, playerColor);
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 || candidateOffset == 6 || candidateOffset == 15);
	}

	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
	}

	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 || candidateOffset == 10 || candidateOffset == 17);
	}

	@Override
	public List<Move> calculateLegalMoves(final Board board) {

		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();

		for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
			candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;

			if (isValidTileCoordinate(candidateDestinationCoordinate)) {

				if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) || isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) || isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) || isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)) {
					continue;
				}

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
			}
		}
		return Collections.unmodifiableList(legalMoves);
	}
}
