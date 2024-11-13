import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class: Game
 * Represents a text-based adventure game with a player and rooms.
 * Manages the game's initialization, main game loop, and player interactions.
 *
 * @author Joshua Rosenblatt
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 3, 2024
 */
public class Game {
    private Player player; // The player in the game
    private Map<String, Room> rooms; // Collection of rooms in the game
    private boolean isGameOver; // Indicates if the game is over

    /**
     * Constructor for the Game class.
     * Initializes the rooms map and sets the game to not over.
     */
    public Game() {
        rooms = new HashMap<>();
        isGameOver = false;
    }

    /**
     * Initializes the game with the player's name and sets up the rooms.
     *
     * @param name The name of the player.
     */
    public void initializeGame(String name) {
        player = new Player(name); // Initialize player with provided name
        createRooms(); // Set up the game rooms
        player.setCurrentRoom(rooms.get("Enchanted Library")); // Set starting room
    }

    /**
     * Creates the rooms in the game and connects them with exits.
     */
    public void createRooms() {
        // Create specific rooms for the game
        Room enchantedLibrary = RoomFactory.createEnchantedLibrary();
        Room orcBarracks = RoomFactory.createOrcBarracks();
        Room wizardsLaboratory = RoomFactory.createWizardsLaboratory();
        Room throneRoom = RoomFactory.createThroneRoom();

        // Connect rooms with exits
        enchantedLibrary.addExit("north", orcBarracks);
        orcBarracks.addExit("south", enchantedLibrary);
        orcBarracks.addExit("east", wizardsLaboratory);
        wizardsLaboratory.addExit("west", orcBarracks);
        wizardsLaboratory.addExit("north", throneRoom);
        throneRoom.addExit("south", wizardsLaboratory);

        // Add rooms to the map for easy access
        rooms.put("Enchanted Library", enchantedLibrary);
        rooms.put("Orc Barracks", orcBarracks);
        rooms.put("Wizard's Laboratory", wizardsLaboratory);
        rooms.put("Throne Room", throneRoom);
    }

    /**
     * Starts the game loop, displaying the player's health and processing inputs until the game ends.
     */
    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        player.displayHealth();
        while (!isGameOver) {
            Room currentRoom = player.getCurrentRoom(); // Get the current room of the player
            currentRoom.displayInfo(); // Display room information
            processPlayerInput(); // Process player commands
        }
    }

    /**
     * Processes player input commands for moving or exiting the game.
     * Valid commands are "go <direction>", "quit", and "exit".
     */
    private void processPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        String[] words = input.split(" ");

        if (words[0].equals("go") && words.length > 1) {
            String direction = words[1];
            Room nextRoom = player.getCurrentRoom().getExit(direction); // Get the room in the specified direction

            if (nextRoom != null) {
                player.moveTo(nextRoom); // Move player to the next room
            } else {
                System.out.println("You can't go that way!"); // Invalid direction
            }
        } else if (input.equals("quit") || input.equals("exit")) {
            exitGame(); // Exit the game if the player enters "quit" or "exit"
        } else {
            System.out.println("I don't understand that command."); // Unknown command
        }
    }

    /**
     * Exits the game by displaying a thank-you message and stopping the game loop.
     */
    public void exitGame() {
        System.out.println("Thank you for playing!");
        isGameOver = true; // Mark the game as over
        System.exit(0); // Terminate the program
    }
}