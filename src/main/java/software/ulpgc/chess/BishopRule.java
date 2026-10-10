package software.ulpgc.chess;


import java.util.ArrayList;
import java.util.List;

public record BishopRule() implements MovementRule {


    @Override
    public List<Move> moveFrom(Board board, Square from) {
        List<Move> moves = new ArrayList<>();
        for(Square to : from.allSquares()){
            Move move = new Move(from, to);
            if(!isBishopDiagonal(move) || !canLandOn(board, move)) continue;
            moves.add(move);
        }
        return List.copyOf(moves);
    }

    private boolean isBishopDiagonal(Move move){
        return (move.fileDistance() == move.rowDistance()) && move.fileDistance() > 0;
    }
}
