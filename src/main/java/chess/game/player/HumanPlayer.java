package chess.game.player;

import chess.PlayerColor;

public class HumanPlayer extends BasePlayer {

    private String sessionId;
    private String username;
    private PlayerColor playerColor;
    private boolean hasTurn;
    private boolean isReady;
    private boolean hasLost;
    private boolean hasResigned;

    public HumanPlayer(String sessionId, String username) {
        this.sessionId = sessionId;
        this.username = username;
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    @Override
    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public boolean isReady() {
        return isReady;
    }

    @Override
    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public boolean hasTurn() {
        return hasTurn;
    }

    @Override
    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    @Override
    public boolean hasResigned() {
        return hasResigned;
    }

    @Override
    public void resign() {
        hasResigned = true;
    }
}
