package software.ulpgc.chess;

public enum Rank {
    R1(1),R2(2),R3(3),R4(4),R5(5),R6(6),R7(7),R8(8);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    static Rank from(char c) {
        int realNumber = Character.getNumericValue(c);
        for(Rank r : Rank.values()){
            if(r.value() == realNumber){
                return r;
            }
        }
        return null;
    }

    public int value() {
        return value;
    }

}
