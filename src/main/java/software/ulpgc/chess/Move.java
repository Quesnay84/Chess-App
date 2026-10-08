package software.ulpgc.chess;

public record Move(Square from, Square to ) {
    public static Move of(String from, String to) {
        return new Move(Square.at(from), Square.at(to));
    }

    private int fileDistance(){
        return Math.abs(from.file().ordinal() - to.file().ordinal());
    }

    private int rowDistance(){
        return Math.abs(from.rank().ordinal() - to.rank().ordinal());
    }

    public boolean isKnightJump(){
        return (fileDistance() * rowDistance()) == 2;
    }

}
