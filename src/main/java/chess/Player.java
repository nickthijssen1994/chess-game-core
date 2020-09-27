package chess;

public interface Player {

    int getPlayerId();

    void setPlayerId(int playerId);

    String getUsername();

    void setUsername(String username);

    PlayerColor getPlayerColor();

    void setPlayerColor(PlayerColor playerColor);

    boolean isReady();

    void setReady(boolean ready);

    boolean hasTurn();

    void setHasTurn(boolean hasTurn);

    boolean hasResigned();

    void resign();
}
