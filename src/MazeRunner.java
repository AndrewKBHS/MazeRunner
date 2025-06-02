import java.io.*;
import java.util.*;

public class MazeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Runner runner;

        //=File file2 = new File("leaderboard.txt");
        Scanner file = new Scanner(new File("leaderboard.txt"));

        System.out.println("Hello");
        System.out.println("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Character 1 or 2?");
        int n = in.nextInt(); in.nextLine();
        if (n==1) {
            runner = new Runner("i", new String[] {"*","|","/","|","\\","_","_","_","_","_","_","\\","\\","|","i"});
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
                maze.explosion(runner);
                System.out.println("OUCH!");
            }

            if (maze.completed()) {
                break;
            }
        }


        System.out.println("It took you " + maze.getStep() + " moves to complete the maze!");

        int[] scores = new int[5];
        String[] names = new String[5];

        Scanner in2;
        for (int r=0; r<5; r++) {
            in2 = new Scanner(file.nextLine());
            scores[r] = in2.nextInt();
            names[r] = in2.next();
        }
        for (int r=0; r<5; r++) {
            if (maze.getStep() < scores[r]) {
                for (int a=4; a>r; a--) {
                    scores[a] = scores[a - 1];
                    names[a] = names[a - 1];
                }
                scores[r] = maze.getStep();
                names[r] = name;
                break;
            }
        }

        PrintWriter writer = new PrintWriter("leaderboard.txt");

        System.out.println("Leaderboard:");
        for (int r=0; r<5; r++) {
            System.out.println(names[r] + ": " + scores[r]);
            writer.print(scores[r] + " " + names[r] + "\n");
        }

        writer.close();
    }

}
