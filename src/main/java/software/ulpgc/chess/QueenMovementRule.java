package software.ulpgc.chess;
public record QueenMovementRule() implements MovementRule {
    @Override
    public boolean allows(Move move){
        return move.isDiagonal() || move.isStraight();
    }
}
