package software.ulpgc.chess;

public interface Board {

    Board applyMove(Move move);

    Piece pieceAt(Square square);

    default Piece pieceAt(File file, Rank rank) {
        return pieceAt(new Square(file, rank));
    }

    default Piece pieceAt(String square) {
        return pieceAt(Square.at(square));
    }

}