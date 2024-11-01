/**
 * Class: Trap
 * Represents a trap in the game that can be triggered by the player.
 * Traps can cause damage or other negative effects when activated.
 *
 * Author: Josh Rosenblatt
 * Version: 1.0
 * Course: CSE 201 Fall 2023
 * Written: October 1, 2023
 */
public class Trap {
    // Name of the trap
    private String name;

    // Description of the trap
    private String description;

    // Amount of damage the trap inflicts
    private int damage;

    // Indicates whether the trap has been triggered
    private boolean isTriggered;

    /**
     * Constructor to create a trap with specified properties.
     *
     * @param name        The name of the trap.
     * @param description The description of the trap.
     * @param damage      The damage amount of the trap.
     */
    public Trap(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.isTriggered = false;
    }

    /**
     * Triggers the trap, causing it to affect the player.
     *
     * @param player The player who triggered the trap.
     */
    public void trigger(Player player) {
        if (!isTriggered) {
            System.out.println("Trap triggered! " + description);
            player.receiveDamage(damage);
            isTriggered = true;
        } else {
            System.out.println("The trap has already been triggered.");
        }
    }

    /**
     * Checks if the trap has been triggered.
     *
     * @return True if the trap has been triggered, false otherwise.
     */
    public boolean isTriggered() {
        return isTriggered;
    }

    /**
     * Gets the name of the trap.
     *
     * @return The name of the trap.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the trap.
     *
     * @return The description of the trap.
     */
    public String getDescription() {
        return description;
    }
}
