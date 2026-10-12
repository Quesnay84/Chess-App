package software.ulpgc.chess;
import java.util.List;

public record PawnMovementRule(Color color) implements MovementRule {

    @Override
    public boolean allows(Move move) {
        return isOneStep(move) || isTwoStepsFromBeginning(move) || isDiagonalStep(move);
    }

    @Override
    public boolean canLandOn(Board board, Move move) {
        return move.isDiagonal() ? isEnemyAt(board, move): isFreePath(board,move);
    }

    public boolean isOneStep(Move move) {return move.fileDistance() == 0 && move.rankDelta() == direction();}

    private int direction() {return color == Color.White ? 1: -1;}

    public boolean isTwoStepsFromBeginning(Move move) {
        return move.fileDistance() == 0 && move.rankDelta() == direction() * 2 && move.from().rank() == startRank();
    }

    private Rank startRank() {return color == Color.White ? Rank.R2: Rank.R7;}

    public boolean isDiagonalStep(Move move) {
        return move.isDiagonal() && move.fileDistance() == 1 && move.rankDelta() == direction();
    }

    private boolean isFreePath(Board board, Move move) {
        return isEmpty(board, move.to()) && arePathEmpty(board, move.squaresBetween());
    }

    private boolean arePathEmpty(Board board, List<Square> squares) {
        for (Square square : squares) {
            if(!isEmpty(board, square)) return false;
        }
        return true;
    }

    private boolean isEnemyAt(Board board, Move move) {return !isEmpty(board, move.to()) && isEnemy(board, move);}

}
