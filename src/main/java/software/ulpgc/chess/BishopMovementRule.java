package software.ulpgc.chess;
public record BishopMovementRule() implements MovementRule {
    @Override
    public boolean allows(Move move) {
        return move.isDiagonal();
    }
}
