package chess.game.player;

import chess.PlayerColor;

public class ComputerPlayer extends BasePlayer {

    @Override
    public int getPlayerId() {
        return 0;
    }

    @Override
    public void setPlayerId(int playerId) {

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
