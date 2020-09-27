package chess.game;

import chess.Game;
import chess.GameManager;
import chess.PieceLocation;
import chess.Player;
import chess.game.move.Move;
import chess.game.player.HumanPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGameManager implements GameManager {

    private Map<Integer, Game> playerIdGames = new HashMap<>();

    @Override
    public void handleStartGameRequest(int playerId, String username, boolean singlePlayer) {
        if (!playerIdGames.containsKey(playerId)) {
            Game game = new ChessGame(this, singlePlayer);
            game.addPlayer(new HumanPlayer(playerId, username));
            playerIdGames.put(playerId, new ChessGame(this, singlePlayer));
        }
    }

    @Override
    public void handlePlayerReadyRequest(int playerId) {

    }

    @Override
    public void handleMakeMoveRequest(int playerId, int originColumn, int originRow, int targetColumn, int targetRow) {

    }

    @Override
    public void handleUndoLastMoveRequest(int playerId) {

    }

    @Override
    public void handlePauseGameRequest(int playerId) {

    }

    @Override
    public void handleResignRequest(int playerId) {

    }

    @Override
    public void processStartGame(Game game) {

    }

    @Override
    public void processPlayerAdded(Player player) {

    }

    @Override
    public void processOpponentAdded(Player player, Player opponent) {

    }

    @Override
    public void processPlayerTurn(List<Player> players, Player playerWhoHasTurn) {

    }

    @Override
    public void processPieceLocations(Player player, List<PieceLocation> pieceLocations) {

    }

    @Override
    public void processMoveDone(List<Player> players, Move doneMove) {

    }

    @Override
    public void processMoveUndone(List<Player> players, Move undoneMove) {

    }

    @Override
    public void processShowMessageToPlayers(List<Player> players, String message) {

    }

    @Override
    public void processShowMessageToPlayer(Player player, String message) {

    }

    @Override
    public void processClientDisconnect(String sessionId) {

    }
}
