import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class MazeRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Runner runner;

        File file = new File("Leaderboard.txt");
        //PrintWriter out = new PrintWriter("Leaderboard.txt");

        System.out.println("Hello");
        System.out.println("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Character 1 or 2?");
        int n = in.nextInt(); in.nextLine();
        if (n==1) {
            runner = new Runner("i");
        }
        else {
            runner = new Blob();
        }

        Maze maze = new Maze(runner);

        System.out.println("Starting now...");

        in.useDelimiter("");

        while (true) {
            System.out.println(maze);
            String input = in.nextLine();
            if (maze.move(input) == true) {
                maze.increment();
            }
            else {
                System.out.println("OUCH!");
            }

            if (maze.completed()) {
                break;
            }
        }

        //writer.write(name + ": " + maze.getStep());
        //String line = reader.readLine();
        System.out.println("It took you " + maze.getStep() + " moves to complete the maze!");
    }
}
