package software.ulpgc.chess;

import java.util.HashMap;
import java.util.Map;

record MapBoard(Map<Square, Piece> pieces) implements Board {
    public MapBoard {
        pieces = Map.copyOf(pieces);
    }

    @Override
    public Piece pieceAt(Square square){
        return pieces.get(square);
    }

    @Override
    public Board applyMove(Move move){
        return new MapBoard(piecesAfterMovement(move));
    }

    private Map<Square, Piece> piecesAfterMovement(Move move){
        Map<Square, Piece> newMap = new HashMap<>(pieces);
        newMap.put(move.to(), newMap.remove(move.from()));
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
