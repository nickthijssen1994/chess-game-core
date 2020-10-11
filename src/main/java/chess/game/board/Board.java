package chess.game.board;

import chess.PieceLocation;
import chess.game.player.PlayerColor;
import chess.game.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Square[][] squares = new Square[8][8]; // [columns][rows]

    private final List<Piece> pieces = new ArrayList<>();

    public Board() {
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                this.squares[column][row] = new Square(column, row);
            }
        }
    }

    public void setPiecesToStartPosition() {
        Piece piece;

        // Place White Pawns
        for (int column = 0; column < 8; column++) {
            piece = new Pawn(PlayerColor.WHITE);
            pieces.add(piece);
            squares[column][1].setPiece(piece);
        }

        // Place White Pieces
        piece = new Rook(PlayerColor.WHITE);
        pieces.add(piece);
        squares[0][0].setPiece(piece);
        piece = new Knight(PlayerColor.WHITE);
        pieces.add(piece);
        squares[1][0].setPiece(piece);
        piece = new Bishop(PlayerColor.WHITE);
        pieces.add(piece);
        squares[2][0].setPiece(piece);
        piece = new Queen(PlayerColor.WHITE);
        pieces.add(piece);
        squares[3][0].setPiece(piece);
        piece = new King(PlayerColor.WHITE);
        pieces.add(piece);
        squares[4][0].setPiece(piece);
        piece = new Bishop(PlayerColor.WHITE);
        pieces.add(piece);
        squares[5][0].setPiece(piece);
        piece = new Knight(PlayerColor.WHITE);
        pieces.add(piece);
        squares[6][0].setPiece(piece);
        piece = new Rook(PlayerColor.WHITE);
        pieces.add(piece);
        squares[7][0].setPiece(piece);

        // Place Black Pawns
        for (int column = 0; column < 8; column++) {
            piece = new Pawn(PlayerColor.BLACK);
            pieces.add(piece);
            squares[column][6].setPiece(piece);
        }

        // Place Black Pieces
        piece = new Rook(PlayerColor.BLACK);
        pieces.add(piece);
        squares[0][7].setPiece(piece);
        piece = new Knight(PlayerColor.BLACK);
        pieces.add(piece);
        squares[1][7].setPiece(piece);
        piece = new Bishop(PlayerColor.BLACK);
        pieces.add(piece);
        squares[2][7].setPiece(piece);
        piece = new Queen(PlayerColor.BLACK);
        pieces.add(piece);
        squares[3][7].setPiece(piece);
        piece = new King(PlayerColor.BLACK);
        pieces.add(piece);
        squares[4][7].setPiece(piece);
        piece = new Bishop(PlayerColor.BLACK);
        pieces.add(piece);
        squares[5][7].setPiece(piece);
        piece = new Knight(PlayerColor.BLACK);
        pieces.add(piece);
        squares[6][7].setPiece(piece);
        piece = new Rook(PlayerColor.BLACK);
        pieces.add(piece);
        squares[7][7].setPiece(piece);
    }

    public Square getSquare(int column, int row) {
        if (column < 0 || column > 7 || row < 0 || row > 7) {
            throw new IllegalArgumentException("Coordinate is outside chess board");
        }
        return squares[column][row];
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Piece> getPlayerPieces(PlayerColor playerColor) {
        List<Piece> playerPieces = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getPlayerColor() == playerColor) {
                playerPieces.add(piece);
            }
        }
        return playerPieces;
    }

    public List<PieceLocation> getPieceLocations() {
        List<PieceLocation> pieceLocations = new ArrayList<>();
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                Square square = squares[column][row];
                if (!square.isEmpty()) {
                    PieceLocation pieceLocation = new PieceLocation(column,
                            row,
                            square.getPiece().getPieceType(),
                            square.getPiece().getPlayerColor());
                    pieceLocations.add(pieceLocation);
                }
            }
        }
        return pieceLocations;
    }
}
