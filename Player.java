/**
 * Represents a player in the game with attributes like health, inventory, and equipped items,
 * which can be controlled by the user through the CLI.
 */

public class Player {
    private String name; // Users inputted name
    private int maxHealth; // Max health of player, what they can heal to
    private int health; // Current health of player
    private Inventory inventory; // Player's inventory
    private Weapon equippedWeapon; // Player's currently equipped weapon
    private Room currentRoom; // The room the player is in
    private boolean isDefending; // Is the player defending?

    /**
     * Creates a new Player with the specified name.
     * Initializes the player with default values:
     * - Maximum health set to 100
     * - Starting health set to 100
     * - Uses basic sword for starting weapon
     * - Inventory with only basic sword
     * 
     * @param name is the user-given name of the player
     */
    public Player(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.inventory = new Inventory();
        this.equippedWeapon = new Weapon("Basic Sword", "A simple sword.", 10);
        this.inventory.addItem(equippedWeapon);
        this.isDefending = false;
    }


    /**
     * Moves the player to a new room and displays a message to the terminal.
     * 
     * @param room is the next room the player chooses to move to
     */
    public void moveTo(Room room) {
        this.currentRoom = room;
        System.out.println("You move to " + room.getName());
    }

    /**
     * Outputs the current health status of the player to console.
     * Displayed in the format: "Health: current/max"
     */
    public void displayHealth() {
        System.out.println("Health: " + health + "/" + maxHealth);
    }

    /**
     * Gets the current room where the player is located.
     * 
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room of the player.
     * 
     * @param room the room to set the location to
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Gets the name of the player.
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }
}
