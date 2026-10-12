package software.ulpgc.chess;
public record KnightMovementRule() implements MovementRule {
    @Override
    public boolean allows(Move move) {
        return (move.fileDistance() * move.rankDistance()) == 2;
    }
}
