package chess;

public interface Player {

    String getSessionId();

    void setSessionId(String sessionId);

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
