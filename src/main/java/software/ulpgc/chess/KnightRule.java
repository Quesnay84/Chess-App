package software.ulpgc.chess;

import java.util.ArrayList;
import java.util.List;

public record KnightRule(Board board, Square square, Move move) implements MovementRule {

    @Override
    public List<Move> moveFrom(Board board, Square from) {
        List<Move> moves = new ArrayList<>();
        for(Square to : from.allSquares()) {
            Move move = new Move(from, to);
            if(!canLandOn(board, move) && !move().isKnightJump()) continue;
            moves.add(move);
        }
        return List.copyOf(moves);
    }

}
