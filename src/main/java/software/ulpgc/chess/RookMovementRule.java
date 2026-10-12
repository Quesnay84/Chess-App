package software.ulpgc.chess;

public record RookMovementRule() implements MovementRule{

    @Override
    public boolean allows(Move move){
        return move.isStraight();
    }
}
