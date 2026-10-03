package software.ulpgc.chess;

public record Square(File file, Rank rank) {
    public static Square at(String square){
        return Square.at(File.from(square.charAt(0)), Rank.from(square.charAt(1)));
    }

    private static Square at(File from, Rank rank) {
        return new Square(from,  rank);
    }


}
