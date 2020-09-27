package chess;

import chess.game.ChessGameManager;

public class ChessMain {

    private static GameManager gameManager;

    public static void main(String[] args) {
        gameManager = new ChessGameManager();
    }
}
