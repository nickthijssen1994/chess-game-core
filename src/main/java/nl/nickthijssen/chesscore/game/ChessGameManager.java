package nl.nickthijssen.chesscore.game;

import nl.nickthijssen.chesscore.Game;
import nl.nickthijssen.chesscore.GameManager;
import nl.nickthijssen.chesscore.PieceLocation;
import nl.nickthijssen.chesscore.Player;
import nl.nickthijssen.chesscore.game.move.Move;

import java.util.List;

public class ChessGameManager implements GameManager {

    @Override
    public void handleStartGameRequest(String sessionId, String username) {

    }

    @Override
    public void handlePlayerReadyRequest(String sessionId) {

    }

    @Override
    public void handlePieceLocationsRequest(String sessionId) {

    }

    @Override
    public void handleMakeMoveRequest(String sessionId, int originColumn, int originRow, int targetColumn, int targetRow) {

    }

    @Override
    public void handleUndoLastMoveRequest(String sessionId) {

    }

    @Override
    public void handlePauseGameRequest(String sessionId) {

    }

    @Override
    public void handleResignRequest(String sessionId) {

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
