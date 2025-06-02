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
    private int r2 = 0;
    private int c2 = 3;
    private int step = 0;
    private int size = maze.length;
    private Runner runner;

    public Maze(Runner person) {
        r = 4;
        c = 1;
        runner = person;
        maze[r][c] = person.toString();
    }

    public boolean verifyMove(int row, int col) {
        if (0<=row && row<size){
            if (0<=col && col<size) {
                if (!maze[row][col].equals("#")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void explosion(Runner runner) {
        String[] arr = runner.getMoves();
        for (String s : arr) {
            maze[r][c] = s;
            for (int r=0; r<130000; r++) {
                System.out.println(this);
            }
        }
    }

    public boolean move(String letter) {
        if (letter.equals("w")) {
            if (verifyMove(r-1, c)) {
                maze[r][c] = " ";
                r-=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }
        if (letter.equals("a")) {
            if (verifyMove(r, c-1)) {
                maze[r][c] = " ";
                c-=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }
        if (letter.equals("s")) {
            if (verifyMove(r+1, c)) {
                maze[r][c] = " ";
                r+=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }
        if (letter.equals("d")) {
            if (verifyMove(r, c+1)) {
                maze[r][c] = " ";
                c+=1;
                maze[r][c] = runner.toString();
                return true;
            }
        }

        return false;
    }

    public void increment() {
        step ++;
    }

    public boolean completed() {
        if (r==r2 && c==c2) {
            return true;
        }

        return false;
    }

    public int getStep() {
        return step;
    }

    public String toString() {
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