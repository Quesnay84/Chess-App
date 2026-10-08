package software.ulpgc.chess;

import java.util.List;

public interface MovementRule{

    List<Move> moveFrom(Board board, Square from);

    default boolean isEmpty(Board board, Square to) {
        return board.pieceAt(to) == null;
    }

    default boolean isEnemy(Board board, Move move) {
        return board.pieceAt(move.from()).color() != board.pieceAt(move.to()).color();
    }

    default boolean canLandOn(Board board, Move move) {
        return isEmpty(board, move.to()) || isEnemy(board, move);
    }


}
