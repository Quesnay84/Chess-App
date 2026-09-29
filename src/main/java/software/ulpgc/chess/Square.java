package software.ulpgc.chess;

public record Square(File file, Rank rank) {
    public static Square at(String Square){
        return new Square(File.A.Rank,R1);
    }


}
