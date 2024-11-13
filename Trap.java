/**
 * Class: Trap
 * Contains all necessary getters, setters and constructor for a trap.
 * These traps will be placed in rooms and will do damage to the player
 * if activated.
 * @author Finn Smart
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 3, 2024
 */
public class Trap {
    private String name; // name of trap
    private String description; // description of trap
    private int damage; // damage of trap
    private boolean isTriggered; // has the trap been triggered already

    /**
     * Trap Constructor. Will be placed in a room as something to 
     * interact with and does damage to the player if interacted with.
     * @param name name of the trap
     * @param description the trap's description, what will be displayed 
     *                      the user.
     * @param damage the amount of damage the trap does to the user.
     */
    public Trap(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        // If the trap has been triggered. Is automatically set to false.
        this.isTriggered = false;
    }

    /**
     * Getter for the trap's name
     * @return name of the trap
     */
    public String getName() {
        return name;
    }

    /**
     * Returns if the trap has been triggered or not.
     * Is used if the player happens to interact with the trap again
     * @return true if the trap has been triggered already, false otherwise
     */
    public boolean isTriggered() {
        return isTriggered;
    }

    /**
     * Returns the damage of the trap, is used to get damage
     * dealt to the player
     * @return the damage dealt by the trap
     */
    public int getDamage() {
        return damage;
    }
}
