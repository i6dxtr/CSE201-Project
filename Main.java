/**
 * Class: Main
 *
 * @authors: Brandon Ducaster, Tom England, Joshua Rosenblatt, Dylan Stoia, Demetrius Hullum Scott
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 15, 2024
 *
 * Purpose: This is the main entry point for the Adventure Game application.
 * It prompts the user for their name, initializes the game, and starts the
 * game loop.
 */

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

        // Display instructions for the player
        System.out.println("\nBefore you begin, here are some commands you can use:");
        System.out.println("- 'go' or 'move [direction]': Move to an adjacent room (e.g., 'go north').");
        System.out.println("- 'look' or 'look at [item]': Inspect an item or object in the room (e.g., 'look at book').");
        System.out.println("- 'pick', 'pickup', or 'pick up [item]': Add an item to your inventory (e.g., 'pick up key').");
        System.out.println("- 'use [item]': Use an item from your inventory (e.g., 'use potion').");
        System.out.println("- 'attack [enemy]': Engage in combat with an enemy (e.g., 'attack orc').");
        System.out.println("- 'equip [weapon]': Equip a weapon from your inventory (e.g., 'equip sword').");
        System.out.println("- 'interact with' or 'interact [object]': Interact with an object in the room (e.g., 'interact with chest').");
        System.out.println("- 'quit' or 'exit': End the game and exit.\n");

        System.out.println("Good luck, " + name + "! Your adventure begins now.");

        // Begin the game
        game.startGame();

        // Close scanner
        sc.close();
    }
}
