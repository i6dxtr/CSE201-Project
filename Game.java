import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Player player;
    private Map<String, Room> rooms;
    private boolean isGameOver;
    private Scanner scanner;
    private Inventory inventory;

    public Game() {
        rooms = new HashMap<>();
        isGameOver = false;
        scanner = new Scanner(System.in);
    }

    public void initializeGame(String name) {
        player = new Player(name, scanner);
        createRooms();
        player.setCurrentRoom(rooms.get("Enchanted Library"));
    }

    public void createRooms() {
        Room library = RoomFactory.createEnchantedLibrary();
        Room barracks = RoomFactory.createOrcBarracks();
        Room lab = RoomFactory.createWizardsLaboratory();
        Room throneRoom = RoomFactory.createThroneRoom();

        // Connect rooms
        RoomFactory.connectRooms(library, barracks, lab, throneRoom);

        rooms.put("Enchanted Library", library);
        rooms.put("Orc Barracks", barracks);
        rooms.put("Wizard's Laboratory", lab);
        rooms.put("Throne Room", throneRoom);
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        player.displayHealth();
        while (!isGameOver) {
            Room currentRoom = player.getCurrentRoom();
            currentRoom.enter(player);
            if (player.isDefeated()) {
                gameOver();
                continue;
            }
            processPlayerInput();
            player.displayHealth();
        }
    }

    private void processPlayerInput() {
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        String[] words = input.split(" ");
        String command;
        String argument = "";

        if (words[0].equals("look") && words[1].equals("at")
            || words[0].equals("pick") && words[1].equals("up")
            || words[0].equals("interact") && words[1].equals("with")) {
            command = words[0] + " " + words[1];

            for (int i = 2; i < words.length; i++) {
                argument += words[i];
                if (i != words.length - 1) {
                    argument += " ";
                }
            }
        } else {
            command = words[0];

            for (int i = 1; i < words.length; i++) {
                argument += words[i];
                if (i != words.length - 1) {
                    argument += " ";
                }
            }
        }

        switch (command) {
            case "go":
            case "move":
                movePlayer(argument);
                break;
            case "look":
            case "look at":
                lookAt(argument);
                break;
            case "pick":
            case "pickup":
            case "pick up":
                pickUp(argument);
                break;
            case "use":
                useItem(argument);
                break;
            case "attack":
                attack(argument);
                break;
            case "equip":
                equipWeapon(argument);
                break;
            case "interact with":
            case "interact":
                interactWith(argument);
                break;
            case "quit":
            case "exit":
                exitGame();
                break;
            default:
                System.out.println("I don't understand that command.");
                break;
        }
    }

    /**
     * Method for the player to move to another room by a given direction
     * (rooms are connected via north east south and west)
     *
     * @param direction : the direction to travel into the next room
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
                if (inventory.getItem("Key") == null) {
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
     * Method for player to look at and read the desciption of an
     * object in the room
     *
     * @param target : name of the object to look at
     */
    private void lookAt(String target) {
        if (target.isEmpty()) {
            System.out.println("Look at what?");
            return;
        }
        player.getCurrentRoom().lookAt(target);
    }

    /**
     * Method for player to pick up an item
     * @param itemName : the name of the item the player tries to pickup
     */
    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Pick up what?");
            return;
        }
        Item item = player.getCurrentRoom().getItem(itemName);
        if (item != null) {
            inventory.addItem(item);
            player.getCurrentRoom().removeItem(item);
            System.out.println("You picked up the " + item.getName() + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    /**
     * Method for player to use an item
     * @param itemName : name of the item to use
     */
    private void useItem(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Use what?");
            return;
        }
        Item item = inventory.getItem(itemName);
        if (item != null) {
            item.use(player);
            if (item.isConsumable()) {
                inventory.removeItem(item);
            }
        } else {
            System.out.println("You don't have a " + itemName + ".");
        }
    }

    /**
     * Method for player to attack an enemy
     * @param enemyName : name of the enemy to attack
     */
    public void attack(String enemyName) {
        if (enemyName.isEmpty()) {
            System.out.println("Attack whom?");
            return;
        }
        Enemy enemy = player.getCurrentRoom().getEnemy(enemyName);
        if (enemy != null) {
            Combat combat = new Combat(player, enemy, scanner, inventory);
            combat.startCombat();
            if (player.isDefeated()) {
                gameOver();
            } else if (enemy.isDefeated()) {
                player.getCurrentRoom().removeEnemy(enemy);
                List<Item> drops = enemy.getDrops();
                if (drops != null && !drops.isEmpty()) {
                    System.out.println("You have defeated " + enemy.getName() + "!");
                    System.out.println("It dropped:");
                    for (Item item : drops) {
                        System.out.println("- " + item.getName());
                        inventory.addItem(item);
                    }
                }
            }
        } else {
            System.out.println("There is no " + enemyName + " here.");
        }
    }

    /**
     * Method to make the player equip a weapon
     * @param weaponName : name of the weapon for the player to equip
     */
    private void equipWeapon(String weaponName) {
        if (weaponName.isEmpty()) {
            System.out.println("Equip what?");
            return;
        }
        player.equipWeapon(weaponName);
    }

    /**
     * method for the player to interact wiht an object
     *
     * @param objectName : the object which the player will
     * interact with
     */
    private void interactWith(String objectName) {
        if (objectName.isEmpty()) {
            System.out.println("Interact with what?");
            return;
        }
        Interactable interactable = player.getCurrentRoom().getInteractable(objectName);
        if (interactable != null) {
            interactable.interact(player, this);
        } else {
            System.out.println("You can't interact with " + objectName + ".");
        }
    }

    /**
     * Method to end the game when player loses
     */
    public void gameOver() {
        System.out.println("You have been defeated!");
        System.out.println("Game Over.");
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
     * method to stop the game and exit the program
     */
    public void exitGame() {
        System.out.println("Thank you for playing!");
        isGameOver = true;
        System.exit(0);
    }
}
