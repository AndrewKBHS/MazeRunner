import java.io.*;
import java.util.*;

/* 
    *Runs the MazeRunner game
    *@author Andrew Kim 
*/
public class MazeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //setup input system
        Scanner in = new Scanner(System.in);
        Runner runner;

        //Setup file to be read
        Scanner file = new Scanner(new File("leaderboard.txt"));

        System.out.println("Hello");
        System.out.println("Please enter your name: ");
        String name = in.nextLine();

        //Choose a character
        System.out.println("Character 1 or 2?");
        int n = in.nextInt(); in.nextLine();
        if (n==1) {
            runner = new Runner("i", new String[] {"*","|","/","|","\\","_","_","_","_","_","_","\\","\\","|","i"});
        }
        else {
            runner = new Blob();
        }

        //Create a new maze
        Maze maze = new Maze(runner);

        System.out.println("Starting now...");

        in.useDelimiter("");

        //Run the program
        while (true) {
            //Print maze and ask for next user's next move
            System.out.println(maze);
            String input = in.nextLine();

            //If the move is valid, move the runner
            if (maze.move(input) == true) {
                maze.increment();
            }
            //The runner has hit a wall or boundary
            else {
                maze.explosion(runner);
                System.out.println("OUCH!");
            }

            //If the runner reaches the exit ("e")
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
