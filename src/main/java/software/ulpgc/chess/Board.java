package software.ulpgc.chess;

import java.util.HashMap;
import java.util.Map;

public record Board(Map<Square, Piece> pieces) {
    Piece pieceAt(File file, Rank rank){
        return pieceAt(new Square(file, rank));
    }
    private Piece pieceAt(Square square){
        return null;
    }

    public Board move(Square from, Square to){

    }

    public static Board inicial(){
        Map<Square, Piece> pieces = Map.ofEntries(
                Square.at('a1'), Piece.WhiteRook),
                Map.entry(at('b1'), Piece.WhiteKing);

        return new Board(Initial);
    }

    Piece pieceAt(String Square){
        return null;
    }
    /*factory method*/



}
