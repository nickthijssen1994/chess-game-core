package chess;

import chess.game.move.Move;

import java.util.List;

public interface Game {

    int getID();

    void addPlayer(Player player);

    void setPlayerReady(Player player);

    void makeMove(Player player, int originColumn, int originRow, int targetColumn, int targetRow);

    void undoLastMove(Player player);

    void pauseGame(Player player);

    void restartGame(Player player);

    void resign(Player player);

    int getNumberOfPlayers();

    boolean getHasStarted();

    boolean getHasEnded();

    Player getOtherPlayer(Player player);

    List<Player> getPlayers();

    List<Move> getDoneMoves();

    List<PieceLocation> getPieceLocations();
}
