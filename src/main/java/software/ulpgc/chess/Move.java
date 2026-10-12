package software.ulpgc.chess;

import java.util.ArrayList;
import java.util.List;

public record Move(Square from, Square to ) {
    public static Move of(String from, String to) {
        return new Move(Square.at(from), Square.at(to));
    }

    public int fileDistance(){return Math.abs(from.file().ordinal() - to.file().ordinal());}

    public int rankDistance(){return Math.abs(from.rank().ordinal() - to.rank().ordinal());}

    public boolean isDiagonal(){return (fileDistance() == rankDistance()) && fileDistance() > 0;}

    public boolean isStraight(){return fileDistance() == 0 ^ rankDistance() == 0;}

    public int rankDelta(){return to.rank().ordinal() - from.rank().ordinal();}

    private int length(){return Math.max(fileDistance(), rankDistance());}

    private int fileStepSignum(){return Integer.signum(to.file().ordinal() - from.file().ordinal());}

    private int rankStepSignum(){return Integer.signum(to.rank().ordinal() - from.rank().ordinal());}

    public List<Square> squaresBetween() {
        List<Square> squares = new ArrayList<>();
        for(int step = 1; step < length(); step++){
            squares.add(from.squareShift(step * fileStepSignum(), step  * rankStepSignum()));
        }
        return List.copyOf(squares);
    }
}
