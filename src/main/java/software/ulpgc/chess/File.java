package software.ulpgc.chess;

public enum File {
    A('a'),B('b'),C('c'),D('d'),E('e'),F('f'),G('g'),H('h');

    private final char symbol;
    File(char symbol){
        this.symbol = symbol;
    }

    static File from(char character){
        for(File f : File.values()){
            if(f.symbol == character){
                return f;
            }
        }
        return null;
    }
}
