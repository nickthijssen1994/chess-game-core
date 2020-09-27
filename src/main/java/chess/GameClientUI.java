package chess;

public interface GameClientUI {

    void processGeneralMessage(String message);

    void processWhitePlayerName(String username);

    void processBlackPlayerName(String username);

    void processPlayerWhoHasTurnMessage(String message);

    void processLoadPieceLocation(PieceLocation pieceLocation);

    void processMoveDoneMessage(String message);

    void processPieceMoved(int originColumn, int originRow, int targetColumn, int targetRow);

    void processMoveDone(String time, String player, String piece, String capture, String origin, String target);

    void processMoveUndoneMessage(String message);

    void processMoveUndone();
}
