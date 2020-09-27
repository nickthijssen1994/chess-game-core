package chess;

import chess.game.move.Move;

import java.util.List;

public interface GameListener {

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
}
