import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: Game
 *
 * @authors
 * Demetrius Hullum Scott, Finn Smart, Tom England, Joshua Rosenblatt, Dylan Stoia, Brandon Duecaster
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Date: 11/23/24
 *
 * Purpose: This class represents the main game logic. It manages the player,
 * rooms, and overall game state, handling player interactions, commands, and
 * the progression of the game. The class also initializes the game world and
 * defines the mechanics for navigating and interacting within it.
 */
public class Game {
    private Player player;
    private Map<String, Room> rooms;
    private boolean isGameOver;
    private Scanner scanner;

    /**
     * Default constructor for Game.
     * Creates an empty map of the rooms and a scanner for player input.
     */
    public Game() {
        rooms = new HashMap<>();
        isGameOver = false;
        scanner = new Scanner(System.in);
    }

    /**
     * Initializes the game with the player's name.
     * Creates the game world and sets the starting room.
     *
     * @param name A string containing the player's name.
     */
    public void initializeGame(String name) {
        player = new Player(name, scanner);
        createRooms();
        player.setCurrentRoom(rooms.get("Enchanted Library"));
    }

    /**
     * Creates the rooms that will be used in the game.
     * Uses the RoomFactory class to create and connect rooms.
     */
    public void createRooms() {
        // Creating rooms
        Room library = RoomFactory.createEnchantedLibrary();
        Room barracks = RoomFactory.createOrcBarracks();
        Room lab = RoomFactory.createWizardsLaboratory();
        Room throneRoom = RoomFactory.createThroneRoom();

        // Connect rooms
        RoomFactory.connectRooms(library, barracks, lab, throneRoom);

        // Add rooms to the rooms map
        rooms.put("Enchanted Library", library);
        rooms.put("Orc Barracks", barracks);
        rooms.put("Wizard's Laboratory", lab);
        rooms.put("Throne Room", throneRoom);
    }

    /**
     * Starts and runs the game loop.
     * Prompts the user and takes in user input.
     */
    public void startGame() {
        // Displaying the player's information
        System.out.println("Welcome to the Adventure Game!");
        player.displayHealth();
        while (!isGameOver) {
            Room currentRoom = player.getCurrentRoom();
            currentRoom.enter(player);
            // If the player loses, display game over screen
            if (player.isDefeated()) {
                gameOver();
                continue;
            }
            processPlayerInput();
            player.displayHealth();
        }
    }

    /**
     * Processes the player's inputs using commands such as "look at", "pick up", or "interact with".
     */
    private void processPlayerInput() {
        // Take in the player's input
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        String[] words = input.split(" ");
        String command;
        String argument = "";

        // If player entered a two-word command
        if ((words[0].equals("look") && words[1].equals("at"))
            || (words[0].equals("pick") && words[1].equals("up"))
            || (words[0].equals("interact") && words[1].equals("with"))) {
            command = words[0] + " " + words[1];

            // Add whole argument to argument string (all words after command)
            for (int i = 2; i < words.length; i++) {
                argument += words[i];
                if (i != words.length - 1) {
                    argument += " ";
                }
            }
        } else {
            // Player entered a one-word command
            command = words[0];

            // Add whole argument to argument string (all words after command)
            for (int i = 1; i < words.length; i++) {
                argument += words[i];
                if (i != words.length - 1) {
                    argument += " ";
                }
            }
        }

        // Check player input
        switch (command) {
            case "go", "move" -> movePlayer(argument);
            case "look", "look at" -> lookAt(argument);
            case "pick", "pickup", "pick up" -> pickUp(argument);
            case "use" -> useItem(argument);
            case "attack" -> attack(argument);
            case "equip" -> equipWeapon(argument);
            case "interact with", "interact" -> interactWith(argument);
            case "quit", "exit" -> exitGame();
            default -> System.out.println("I don't understand that command.");
        }
    }

    /**
     * Moves the player to another room by a given direction.
     * Rooms are connected via north, east, south, and west.
     *
     * @param direction The direction to travel into the next room.
     */
    private void movePlayer(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where?");
            return;
        }
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            if (nextRoom.getName().equals("Throne Room")) {
                // Check if player has the key
                if (player.getInventory().getItem("Orc Key") == null) {
                    System.out.println("The door is locked. You need a key to enter.");
                    return;
                }
            }

            player.setCurrentRoom(nextRoom);
        } else {
            System.out.println("You can't go that way!");
        }
    }

    /**
     * Allows the player to look at and read the description of an object in the room.
     *
     * @param target Name of the object to look at.
     */
    private void lookAt(String target) {
        if (target.isEmpty()) {
            System.out.println("Look at what?");
            return;
        }
        player.getCurrentRoom().lookAt(target);
    }

    /**
     * Allows the player to pick up an item.
     *
     * @param itemName The name of the item the player tries to pick up.
     */
    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Pick up what?");
            return;
        }
        Item item = player.getCurrentRoom().getItem(itemName);
        if (item != null) {
            switch (item.getName()) {
                case "Orc Key" -> orcKeyPickup();
            }
            player.getInventory().addItem(item);
            player.getCurrentRoom().removeItem(item);
            System.out.println("You picked up the " + item.getName() + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    /**
     * Allows the player to use an item.
     *
     * @param itemName Name of the item to use.
     */
    private void useItem(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Use what?");
            return;
        }
        // retrieve item from inventory and use if item was found
        Item item = player.getInventory().getItem(itemName);
        if (item != null) {
            item.use(player);
            if (item.isConsumable()) {
                player.getInventory().removeItem(item);
            }
        } else {
            System.out.println("You don't have a " + itemName + ".");
        }
    }

    /**
     * Allows the player to attack an enemy.
     *
     * @param enemyName Name of the enemy to attack.
     */
    public void attack(String enemyName) {
        if (enemyName.isEmpty()) {
            System.out.println("Attack whom?"); // If there is no enemy
            return;
        }
        Enemy enemy = player.getCurrentRoom().getEnemy(enemyName);
        if (enemy != null) {
            Combat combat = new Combat(player, enemy, scanner);

            combat.startCombat(); // If there is an enemy, start combat
            // if player loses
            if (player.isDefeated()) {
                gameOver();
            // else if enemy loses
            } else if (enemy.isDefeated()) {
                player.getCurrentRoom().removeEnemy(enemy);
                List<Item> drops = enemy.getDrops();
                if (drops != null && !drops.isEmpty()) {
                    System.out.println("You have defeated " + enemy.getName() + "!");
                    System.out.println("It dropped:");
                    for (Item item : drops) {
                        System.out.println("- " + item.getName());
                        player.getInventory().addItem(item);
                    }
                }

                if (enemy.getName().equals("Grunk") && player.getCurrentRoom().getItem("Orc Key") != null) {
                    player.getCurrentRoom().removeItem(player.getCurrentRoom().getItem("Orc Key"));
                }

                // if player defeated boss, print win message and end game
                if (enemy instanceof Boss) {
                    System.out.println("\n\n--------------------------------------------------------------------------------------"
                            + "\nThe final boss is defeated! The darkness is gone, the realm is free, and your journey"
                            + "\nis complete!"
                            + "\n--------------------------------------------------------------------------------------\n\n");

                    while (true) {
                        System.out.println("Would you like to play again? (yes/no)"); // If they defeat the boss
                        System.out.print("> ");
                        String input = scanner.nextLine().toLowerCase();
                        // If the player wants to play again, restart the game
                        if (input.equals("yes") || input.equals("y")) {
                            isGameOver = false;
                            initializeGame(player.getName());
                            startGame();
                            break;
                        // End the game if the player inputs no
                        } else if (input.equals("no") || input.equals("n")) {
                            exitGame();
                            break;
                        } else {
                            System.out.print("Not a valid input!");
                        }
                    }
                }
            }
        } else {
            System.out.println("There is no " + enemyName + " here.");
        }
    } // Added missing closing brace here

    /**
     * Allows the player to equip a weapon.
     *
     * @param weaponName Name of the weapon for the player to equip.
     */
    private void equipWeapon(String weaponName) {
        // If no weapon to interact with
        if (weaponName.isEmpty()) {
            System.out.println("Equip what?");
            return;
        }
        // Equip the weapon
        player.equipWeapon(weaponName);
    }

    /**
     * Allows the player to interact with an object.
     *
     * @param objectName The object which the player will interact with.
     */
    private void interactWith(String objectName) {
        if (objectName.isEmpty()) {
            System.out.println("Interact with what?"); // If no object to interact with
            return;
        }
        Interactable interactable = player.getCurrentRoom().getInteractable(objectName);
        if (interactable != null) {
            interactable.interact(player, this, scanner);
        } else {
            System.out.println("You can't interact with " + objectName + ".");
        }
    }

    /**
     * Ends the game when the player loses.
     */
    public void gameOver() {
        // inform user of defeat
        System.out.println("You have been defeated!");
        System.out.println("Game Over.");
        // prompt for restart
        System.out.println("Would you like to restart? (yes/no)");
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("yes") || input.equals("y")) {
            isGameOver = false;
            initializeGame(player.getName());
            startGame();
        } else if (input.equals("no") || input.equals("n")) {
            exitGame();
        } else {
            System.out.print("Not a valid input!");
            gameOver();
        }
    }

    /**
     * Stops the game and exits the program.
     */
    public void exitGame() {
        System.out.println("Thank you for playing!");
        isGameOver = true;
        System.exit(0);
    }

    /**
     * Handles the special event when the player picks up the Orc Key.
     * There is a random chance that the player may die when picking up the key.
     */
    private void orcKeyPickup() {
        Random rand = new Random();
        // 50/50 chance to pick up the key from Grunk's pocket.
        boolean playerDead = rand.nextBoolean();

        if (playerDead) {
            System.out.println("\n--------------------------------------------------------------------------------------"
                    + "\nYou pick up the Orc Key straight from Grunk's pocket. Unfortunately you weren't fast"
                    + "\nenough, and you don't have any good weapons on you. Better luck next time..."
                    + "\n--------------------------------------------------------------------------------------\n");
            gameOver();
        }
    }
}
