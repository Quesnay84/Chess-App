package software.ulpgc.chess;

public record Move(Square from, Square to ) {
    public static Move of(String from, String to) {
        return new Move(Square.at(from), Square.at(to));
    }
}
