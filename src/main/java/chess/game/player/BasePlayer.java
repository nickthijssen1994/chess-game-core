package chess.game.player;

public abstract class BasePlayer implements Player {

    private String username;
    private PlayerColor color;
    private boolean isReady;
    private boolean hasResigned;

    public BasePlayer(PlayerColor color, String username) {
        this.username = username;
        this.color = color;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public PlayerColor getColor() {
        return color;
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
    public boolean hasResigned() {
        return hasResigned;
    }

    @Override
    public void resign() {
        hasResigned = true;
    }
}
