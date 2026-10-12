package software.ulpgc.chess;

import java.util.ArrayList;
import java.util.List;

public record Square(File file, Rank rank) {
    public static Square at(String square){
        return Square.at(File.from(square.charAt(0)), Rank.from(square.charAt(1)));
    }

    private static Square at(File from, Rank rank) {
        return new Square(from,  rank);
    }

    public List<Square> allSquares() {
        List<Square> squares = new ArrayList<>();
        for(File f: File.values()){
            for(Rank r: Rank.values()){
                squares.add(at(f, r));
            }
        }
        return List.copyOf(squares);
    }

    public Square squareShift(int files, int ranks){
        return new Square(File.values()[file.ordinal() + files], Rank.values()[rank.ordinal() + ranks]);
    }



}
