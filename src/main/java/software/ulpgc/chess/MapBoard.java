package software.ulpgc.chess;

import java.util.HashMap;
import java.util.Map;

public record MapBoard(Map<Square, Piece> pieces) implements Board {
    public MapBoard {
        pieces = Map.copyOf(pieces);
    }

    public Piece pieceAt(File file, Rank rank){
        return pieceAt(new Square(file, rank));
    }
    @Override
    public Piece pieceAt(Square square){
        return pieces.get(square);
    }

    public Piece pieceAt(String square){
        return pieceAt(Square.at(square));
    }

    @Override
    public Board move(Square from, Square to){
        return new MapBoard(piecesAfterMovement(from, to));
    }

    private Map<Square, Piece> piecesAfterMovement(Square from, Square to){
        Map<Square, Piece> newMap = new HashMap<>(pieces);
        newMap.put(to, newMap.remove(from));
        return newMap;
    }


    static Board inicial() {
        Map<Square, Piece> pieces = Map.ofEntries(
                Map.entry(Square.at("a1"), Piece.WhiteRook),
                Map.entry(Square.at("b1"), Piece.WhiteKnight),
                Map.entry(Square.at("c1"), Piece.WhiteBishop),
                Map.entry(Square.at("d1"), Piece.WhiteQueen),
                Map.entry(Square.at("e1"), Piece.WhiteKing),
                Map.entry(Square.at("f1"), Piece.WhiteBishop),
                Map.entry(Square.at("g1"), Piece.WhiteKnight),
                Map.entry(Square.at("h1"), Piece.WhiteRook),

                Map.entry(Square.at("a2"), Piece.WhitePawn),
                Map.entry(Square.at("b2"), Piece.WhitePawn),
                Map.entry(Square.at("c2"), Piece.WhitePawn),
                Map.entry(Square.at("d2"), Piece.WhitePawn),
                Map.entry(Square.at("e2"), Piece.WhitePawn),
                Map.entry(Square.at("f2"), Piece.WhitePawn),
                Map.entry(Square.at("g2"), Piece.WhitePawn),
                Map.entry(Square.at("h2"), Piece.WhitePawn),

                Map.entry(Square.at("a7"), Piece.BlackPawn),
                Map.entry(Square.at("b7"), Piece.BlackPawn),
                Map.entry(Square.at("c7"), Piece.BlackPawn),
                Map.entry(Square.at("d7"), Piece.BlackPawn),
                Map.entry(Square.at("e7"), Piece.BlackPawn),
                Map.entry(Square.at("f7"), Piece.BlackPawn),
                Map.entry(Square.at("g7"), Piece.BlackPawn),
                Map.entry(Square.at("h7"), Piece.BlackPawn),

                Map.entry(Square.at("a8"), Piece.BlackRook),
                Map.entry(Square.at("b8"), Piece.BlackKnight),
                Map.entry(Square.at("c8"), Piece.BlackBishop),
                Map.entry(Square.at("d8"), Piece.BlackQueen),
                Map.entry(Square.at("e8"), Piece.BlackKing),
                Map.entry(Square.at("f8"), Piece.BlackBishop),
                Map.entry(Square.at("g8"), Piece.BlackKnight),
                Map.entry(Square.at("h8"), Piece.BlackRook)
        );
        return new MapBoard(pieces);
    }

}
