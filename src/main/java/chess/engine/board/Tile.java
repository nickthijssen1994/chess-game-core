package chess.engine.board;

import chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

	protected final int column;
	protected final int row;

	private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				emptyTileMap.put(column * 10 + row, new EmptyTile(column, row));
			}
		}

		return ImmutableMap.copyOf(emptyTileMap);
	}

	public static Tile createTile(final int column, final int row, final Piece piece) {
		return piece != null ? new OccupiedTile(column, row, piece) : EMPTY_TILES.get(column * 10 + row);
	}

	private Tile(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		EmptyTile(final int column, final int row) {
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

		OccupiedTile(int column, int row, Piece piece) {
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
