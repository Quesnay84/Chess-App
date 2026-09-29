package software.ulpgc.chess;

import java.util.Map;

public record Board(Map<Square, Piece> pieces) {
    Piece pieceAt(File file, Rank rank){
        return pieceAt(new Square(file, rank));
    }
    private Piece pieceAt(Square square){
        return null;
    }

    public Board(Map<Square, Piece> pieces){
        this.pieces = pieces;
    }

    Piece pieceAt(String Square){
        return null;
    }



}
