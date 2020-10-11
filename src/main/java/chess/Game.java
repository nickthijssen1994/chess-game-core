package chess;

import chess.game.player.PlayerColor;

public interface Game {

    void addPlayer(PlayerColor color, String username);

    void setPlayerReady(PlayerColor color);

    void makeMove(PlayerColor color, int originColumn, int originRow, int targetColumn, int targetRow);

    void undoLastMove(PlayerColor color);

    void pauseGame(PlayerColor color);

    void restartGame(PlayerColor color);

    void resign(PlayerColor color);
}
