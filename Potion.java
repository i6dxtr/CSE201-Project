/**
 * Class: Potion
 * Represents a potion item that can be used by a player to heal or cause damage,
 * with a certain chance of success. Potions can only be used once.
 *
 * Extends the Item class.
 *
 * @author Joshua Rosenblatt
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 1, 2024
 */
public class Potion extends Item {

    int healAmount;       // Amount of healing the potion provides
    int damageAmount;     // Amount of damage the potion causes
    double chance;        // Chance of the potion working
    boolean isConsumed;   // Indicates if the potion has been used

    /**
     * Constructs a Potion with specified attributes.
     *
     * @param name        The name of the potion.
     * @param description A description of the potion.
     * @param healAmount  The amount of healing the potion provides.
     * @param damageAmount The amount of damage the potion causes.
     * @param chance      The chance that the potion will be effective.
     */
    Potion(String name, String description, int healAmount, int damageAmount, double chance) {
        super(name, description);
        this.healAmount = healAmount;
        this.damageAmount = damageAmount;
        this.chance = chance;
        isConsumed = false;
    }

    /**
     * Constructs a default Potion with preset attributes.
     */
    Potion() {
        super("Red Potion", "Only for those who are worthy");
        healAmount = Integer.MIN_VALUE;
        damageAmount = 0;
        chance = 1.0;
        isConsumed = false;
    }

    /**
     * Uses the potion on a player, applying its effects if it has not been consumed.
     *
     * @param player The player who uses the potion.
     */
    public void use(Player player) {
        if (!isConsumed) {
            // Apply effects to player, healing or damage, based on potion attributes
            isConsumed = true;
        }
    }
}