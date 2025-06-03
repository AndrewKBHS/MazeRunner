/**
 * Creates a blob runner to finish the maze
*/
public class Blob extends Runner {
    private String shape; 
    private String[] moves; 

    /**
     * Creates a blob character with a body and an animation sequence
     * Takes from the runner constructor
    */
    public Blob() {
        super("o", new String[] {"*","o","O","8", "O", "o", "O", "8","O","o","O","8","O","o"});;
    }

}
