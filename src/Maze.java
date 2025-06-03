/**
 * Creates a maze for the runner to exit
*/
public class Maze {
    private String[][] maze = {
            {"#","#","#","e","#"},
            {"#"," ","#"," ","#"},
            {"#"," "," "," ","#"},
            {"#"," "," "," ","#"},
            {"#","i","#","#","#"}
    };
    private int r;
    private int c;
    private int r2 = 0; //the y-coordinate of the exit
    private int c2 = 3; //the x-coordinate of the exit
    private int step = 0; //the number of moves made
    private int size = maze.length; //the size of the array
    private Runner runner;

    /**
     * Creates a maze with the runner in starting position
     * @param person the runner type
    */
    public Maze(Runner person) {
        r = 4;
        c = 1;
        runner = person;
        maze[r][c] = person.toString();
    }

    /**
     * Returns true if the position is not a wall
     * Returns false if the position is a wall or out of bounds
     * @param row the next row
     * @param col the next column
    */
    public boolean verifyMove(int row, int col) {
        if (0<=row && row<size){ //row boundaries
            if (0<=col && col<size) { //column boundaries
                if (!maze[row][col].equals("#")) { //is not a wall
                    return true;
                }
            }
        }
        return false; //is a wall
    }

    /**
     * Prints a series of mazes to animated the runner colliding into a wall/boundary
     * @param runner the runner that is colliding
    */
    public void explosion(Runner runner) {
        String[] arr = runner.getMoves();
        //each move in moves
        for (String s : arr) {
            //set the animation frame into the maze
            maze[r][c] = s;
            for (int r=0; r<10000; r++) { //the max r depends on the cpu power for delay animation speed
                System.out.println(this);
            }
        }
    }

    /**
     * Verifies a user's input to move the runner
     * Moves the runner in the respective WASD direcitons
     * Increments the number of valid moves made
     * @param letter the input move used
    */
    public boolean move(String letter) {
        //when the move is "w"
        if (letter.equals("w")) {
            if (verifyMove(r-1, c)) { //verify the move, then update the maze
                maze[r][c] = " ";
                r-=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }
        //when the move is "a"
        if (letter.equals("a")) { //verify the move, then update the maze
            if (verifyMove(r, c-1)) {
                maze[r][c] = " ";
                c-=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }

        //when the move is "s"
        if (letter.equals("s")) {
            if (verifyMove(r+1, c)) { //verify the move, then update the maze
                maze[r][c] = " ";
                r+=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }

        //when the move is "d"
        if (letter.equals("d")) {
            if (verifyMove(r, c+1)) { //verify the move, then update the maze
                maze[r][c] = " ";
                c+=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }

        //invalid move
        return false;
    }

    /**
     * Increments the step (move) count
    */
    public void increment() {
        step ++;
    }

    /**
     * Returns true if the runner reaches the exit. If not, returns false
    */
    public boolean completed() {
        //if the runner position is at the exit
        if (r==r2 && c==c2) {
            return true;
        }

        return false;
    }

    /**
     * Returns the number of valid steps/moves made
    */
    public int getStep() {
        return step;
    }

    /**
     * Returns the maze in its current form
    */
    public String toString() {
        //print out the 2d version of the maze (array to string)
        String string = "";
        for (String[] s : maze) {
            String str = "";
            for (String l : s) {
                str += l;
            }
            string = string + str + "\n";
        }
        return string;
    }


}
