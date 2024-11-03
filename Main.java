import java.util.Scanner;

/**
 * Class: Main
 * Entry point for the text-based adventure game. Prompts the user to input a name,
 * initializes the game with that name, and starts the game loop.
 *
 * @author Joshua Rosenblatt
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 1, 2024
 */
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
        System.out.println("Please input a name.");
        String name = sc.nextLine();

        game.initializeGame(name); // Initialize the game with the provided name
        game.startGame();
    }
}
