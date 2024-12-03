import java.util.Scanner;

public class Main {

    /**
     * Main method that serves as the entry point for the game.
     * Prompts the user for a player name, initializes the game, and starts it.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Game game = new Game(); // Create a new game instance
        Scanner sc = new Scanner(System.in);

        // Display title screen
        System.out.println("=======================================");
        System.out.println("      WELCOME TO THE ADVENTURE GAME    ");
        System.out.println("=======================================");

        // Introduction
        System.out.println("You are about to embark on a perilous journey through mysterious rooms filled with dangers and treasures.");
        System.out.print("Please input your name: ");

        String name = sc.nextLine();

        game.initializeGame(name); // Initialize the game with the provided name
        game.startGame();

        // sc.close();
    }
}
