package chess.engine.board;

import chess.engine.pieces.Piece;

public abstract class Tile {

	int column;
	int row;
	String name;

	Tile(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		EmptyTile(int column, int row) {
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

		Piece piece;

		public OccupiedTile(int column, int row, Piece piece) {
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
