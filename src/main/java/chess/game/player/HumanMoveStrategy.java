package chess.game.player;

import chess.game.board.Board;
import chess.game.move.Move;

public class HumanMoveStrategy {

    private HumanMoveStrategy() {
        throw new IllegalStateException("Utility Class");
    }

    public static Move makeHumanMove(Board board, PlayerColor color, int originColumn, int originRow, int targetColumn, int targetRow){
        Move move = new Move(color, board.getSquare(originColumn, originRow), board.getSquare(targetColumn,targetRow));
        move.execute();
        return move;
    }
}
