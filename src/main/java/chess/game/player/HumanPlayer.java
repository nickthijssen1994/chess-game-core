package chess.game.player;

public class HumanPlayer extends BasePlayer {

    private int playerId;
    private String username;
    private PlayerColor playerColor;
    private boolean hasTurn;
    private boolean isReady;
    private boolean hasLost;
    private boolean hasResigned;

    public HumanPlayer(int playerId, String username) {
        this.playerId = playerId;
        this.username = username;
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }

    @Override
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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
