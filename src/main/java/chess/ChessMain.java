package chess;

import chess.game.ChessGame;
import chess.game.Game;
import chess.game.player.PlayerColor;

public class ChessMain {

    public static void main(String[] args) {
        Game game = new ChessGame(true);
        game.addPlayer(PlayerColor.WHITE, "Nick");
        game.setPlayerReady(PlayerColor.WHITE);
        game.makeMove(PlayerColor.WHITE, 0, 1, 0, 2);
    }
}
