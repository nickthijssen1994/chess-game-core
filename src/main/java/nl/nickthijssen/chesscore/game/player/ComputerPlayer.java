package nl.nickthijssen.chesscore.game.player;

import nl.nickthijssen.chesscore.PlayerColor;

public class ComputerPlayer extends BasePlayer {

    @Override
    public String getSessionId() {
        return null;
    }

    @Override
    public void setSessionId(String sessionId) {

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public PlayerColor getPlayerColor() {
        return null;
    }

    @Override
    public void setPlayerColor(PlayerColor playerColor) {

    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReady(boolean ready) {

    }

    @Override
    public boolean hasTurn() {
        return false;
    }

    @Override
    public void setHasTurn(boolean hasTurn) {

    }

    @Override
    public boolean hasResigned() {
        return false;
    }

    @Override
    public void resign() {

    }
}
