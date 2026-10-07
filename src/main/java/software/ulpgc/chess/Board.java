package software.ulpgc.chess;

public interface Board {
    Piece pieceAt(Square square);

    default Piece pieceAt(File file, Rank rank){
        return pieceAt(new Square(file, rank));
    }
    Board move(Square from, Square to);

    static Board inicial(){
        return MapBoard.inicial();
    }
}
