package chess.game.player;

public interface Player {

    String getUsername();

    PlayerColor getColor();

    boolean isReady();

    void setReady(boolean ready);

    boolean hasResigned();

    void resign();
}
