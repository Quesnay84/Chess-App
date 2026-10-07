package software.ulpgc.chess;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private final Board board = MapBoard.inicial();

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
    void both_overloads_give_the_same_result() {
        assertEquals(board.pieceAt(Square.at("d1")), board.pieceAt(File.D, Rank.R1));
    }

    @Test
    void moving_a_piece_leaves_the_original_board_untouched() {
        Board moved = board.applyMove(Move.of("e2", "e4"));

        assertEquals(Piece.WhitePawn, moved.pieceAt(Square.at("e4")));
        assertEquals(Piece.WhitePawn, board.pieceAt(Square.at("e2")));
    }
}