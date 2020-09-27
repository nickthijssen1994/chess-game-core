package chess;

import chess.game.move.Move;

import java.util.List;

public interface GameManager {

    /*
     * Methods that need to be mapped to right game and/or player
     */
    void handleStartGameRequest(int playerId, String username, boolean singlePlayer);

    void handlePlayerReadyRequest(int playerId);

    void handleMakeMoveRequest(int playerId, int originColumn, int originRow, int targetColumn, int targetRow);

    void handleUndoLastMoveRequest(int playerId);

    void handlePauseGameRequest(int playerId);

    void handleResignRequest(int playerId);

    /*
     * Methods for sending data to certain player or players
     */
    void processStartGame(Game game);

    void processPlayerAdded(Player player);

    void processOpponentAdded(Player player, Player opponent);

    void processPlayerTurn(List<Player> players, Player playerWhoHasTurn);

    void processPieceLocations(Player player, List<PieceLocation> pieceLocations);

    void processMoveDone(List<Player> players, Move doneMove);

    void processMoveUndone(List<Player> players, Move undoneMove);

    void processShowMessageToPlayers(List<Player> players, String message);

    void processShowMessageToPlayer(Player player, String message);

    void processClientDisconnect(String sessionId);
}
