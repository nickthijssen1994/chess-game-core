package chess.engine.board;

import chess.engine.pieces.Piece;

import java.util.*;

public abstract class Tile {

	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	protected final int coordinate;

	private Tile(final int coordinate) {
		this.coordinate = coordinate;
	}

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

		for (int nextCoordinate = 0; nextCoordinate < BoardUtils.NUM_TILES; nextCoordinate++) {
			emptyTileMap.put(nextCoordinate, new EmptyTile(nextCoordinate));
		}

		return Collections.unmodifiableMap(emptyTileMap);
	}

	public static Tile createTile(final int coordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(coordinate, piece) : EMPTY_TILES_CACHE.get(coordinate);
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		private EmptyTile(final int coordinate) {
			super(coordinate);
		}

		@Override
		public boolean isTileOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}
	}

	public static final class OccupiedTile extends Tile {

		private final Piece piece;

		private OccupiedTile(int coordinate, final Piece piece) {
			super(coordinate);
			this.piece = piece;
		}

		@Override
		public boolean isTileOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return piece;
		}
	}
}
