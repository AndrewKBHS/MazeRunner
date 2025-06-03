/*
   * Creates a human runner
*/
public class Runner {
    private String shape;
    private String[] moves;

   /**
    * Creates a human
    * @param shape the human as a string
    * @param moves the human falling animatikon
   */
    public Runner(String shape, String[] moves) {
        this.shape = shape;
        this.moves = moves;
    }

   /**
    * Returns the human runner as a string
   */
    public String toString() {
        return shape;
    }

   /**
    * Returns the human falling animation sequence
   */
    public String[] getMoves() {
        return moves;
    }
}
