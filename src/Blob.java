/**
 * Creates a blob runner
*/
public class Blob extends Runner {
    private String shape; 
    private String[] moves; 

    /**
     * Creates a blob character
     * @param shape the blob as a string
     * @param moves blob collision animation sequence
    */
    public Blob() {
        super("o", new String[] {"*","o","O","8", "O", "o", "O", "8","O","o","O","8","O","o"});;
    }

}
