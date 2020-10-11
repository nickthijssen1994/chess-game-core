package chess.game.pieces;

import chess.game.player.PlayerColor;
import chess.game.board.Board;
import chess.game.board.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private PieceType pieceType;
    private PlayerColor playerColor;
    private int movesDone = 0;
    private boolean isCaptured;
    private int columnPosition;
    private int rowPosition;

    public Piece(PieceType pieceType, PlayerColor playerColor) {
        this.pieceType = pieceType;
        this.playerColor = playerColor;
        this.isCaptured = false;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public PlayerColor getPlayerColor() {
        return this.playerColor;
    }

    public boolean getHasMoved() {
        return movesDone > 0;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public abstract List<Square> getValidMoves(Board board);

    public void incrementMovesDone() {
        movesDone++;
    }

    public void decrementMovesDone() {
        if (movesDone > 0) {
            movesDone--;
        }
    }

    public int getMovesDone() {
        return movesDone;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setPosition(int columnPosition, int rowPosition) {
        this.columnPosition = columnPosition;
        this.rowPosition = rowPosition;
    }

    public boolean canBeCaptured(Board board) {
        List<Square> possibleOpponentMoves = new ArrayList<>();

        if (playerColor == PlayerColor.WHITE) {
            for (Piece opponentPiece : board.getPlayerPieces(PlayerColor.BLACK)) {
                possibleOpponentMoves.addAll(opponentPiece.getValidMoves(board));
            }
        } else {
            for (Piece opponentPiece : board.getPlayerPieces(PlayerColor.WHITE)) {
                possibleOpponentMoves.addAll(opponentPiece.getValidMoves(board));
            }
        }

        return possibleOpponentMoves.contains(board.getSquare(columnPosition, rowPosition));
    }
}
