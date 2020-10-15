/*******************************************************************************
 * GNU General Public License
 * Copyright © 2020 Nick Thijssen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ******************************************************************************/

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
