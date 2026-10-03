package software.ulpgc.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private final Board board = Board.inicial();

    @Test
    void returns_the_piece_on_an_occupied_square() {
        assertEquals(Piece.WhiteRook, board.pieceAt(Square.at("a1")));
        assertEquals(Piece.BlackKing, board.pieceAt(Square.at("e8")));
    }

    @Test
    void returns_null_on_an_empty_square() {
        assertNull(board.pieceAt(Square.at("e4")));
    }

    @Test
    void all_overloads_give_the_same_result() {
        Piece bySquare = board.pieceAt(Square.at("d1"));

        assertEquals(bySquare, board.pieceAt("d1"));
        assertEquals(bySquare, board.pieceAt(File.D, Rank.R1));
    }
}

    /*@Test
    void rejects_an_invalid_square() {
        assertThrows(IllegalArgumentException.class, () -> board.pieceAt("z9"));
    }

*/
