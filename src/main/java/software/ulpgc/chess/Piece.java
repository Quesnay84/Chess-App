package software.ulpgc.chess;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum Piece {
    WhitePawn,
    BlackPawn,
    WhiteRook,
    BlackRook,
    WhiteKnight,
    BlackKnight,
    WhiteQueen,
    BlackQueen,
    WhiteKing,
    BlackKing,
    WhiteBishop,
    BlackBishop;

    private static final Set<Piece> setWhite = Collections.unmodifiableSet(EnumSet.of(WhitePawn, WhiteRook, WhiteKnight, WhiteQueen, WhiteKing, WhiteBishop));

    Color color(){
        return isWhite() ? Color.White: Color.Black;
    }
    private boolean isWhite(){
        return setWhite.contains(this);
    }

    public boolean isPawn(){
        return this == WhitePawn || this == BlackPawn;
    }
    public boolean isKing(){
        return this == WhiteKing|| this == BlackKing;
    }
    public boolean isQueen(){
        return this == WhiteQueen || this == BlackQueen;
    }
    public boolean isKnight(){
        return this == WhiteKnight || this == BlackKnight;
    }
    public boolean isBishop(){
        return this == WhiteBishop || this == BlackBishop;
    }
    public boolean isRook(){
        return this == WhiteRook || this == BlackRook;
    }
}
