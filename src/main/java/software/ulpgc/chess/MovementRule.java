package software.ulpgc.chess;

import java.util.ArrayList;
import java.util.List;

public interface MovementRule{

   boolean allows(Move move);

    default List<Move> moveFrom(Board board, Square from){
        List<Move> moves = new ArrayList<>();
        for(Square to: from.allSquares()){
            Move move = new Move(from, to);
            if(!allows(move) || !canLandOn(board,move)) continue;
            moves.add(move);
        }
        return List.copyOf(moves);
    }

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