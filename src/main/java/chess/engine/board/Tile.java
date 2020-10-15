package chess.engine.board;

import chess.engine.pieces.Piece;

import java.util.*;

public abstract class Tile {

	protected final int column;
	protected final int row;

	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				emptyTileMap.put(column * 10 + row, new EmptyTile(column, row));
			}
		}

		return Collections.unmodifiableMap(emptyTileMap);
	}

	public static Tile createTile(final int column, final int row, final Piece piece) {
		return piece != null ? new OccupiedTile(column, row, piece) : EMPTY_TILES_CACHE.get(column * 10 + row);
	}

	private Tile(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		private EmptyTile(final int column, final int row) {
			super(column, row);
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

		private OccupiedTile(int column, int row, Piece piece) {
			super(column, row);
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
