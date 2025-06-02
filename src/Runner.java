/*
    *Stores a runner object
*/
public class Runner {
    private String shape;
    private String[] moves;

    public Runner(String shape, String[] moves) {
        this.shape = shape;
        this.moves = moves;
    }

    public String toString() {
        return shape;
    }

    public String[] getMoves() {
        return moves;
    }


}
