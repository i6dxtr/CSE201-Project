/**
 * Class: Boss
 * Extends the Enemy class to represent the final boss enemy with unique properties.
 * The Boss has higher health and attack power compared to other enemies.
 * Defeating the Boss results in winning the game.
 *
 * Author: Josh Rosenblatt
 * Version: 1.0
 * Course: CSE 201 Fall 2024
 * Written: October 31, 2024
 */
public class Boss extends Enemy {

    /**
     * Constructor to create the Boss enemy with specified properties.
     *
     * @param name        The name of the Boss.
     * @param description The description of the Boss.
     * @param health      The health value of the Boss.
     * @param attackPower The attack power of the Boss.
     */
    public Boss(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
    }

    /**
     * Overrides the getFleeChance method to specify that the player cannot flee from the Boss.
     *
     * @return The flee chance against the Boss.
     */
    @Override
    public double getFleeChance() {
        return 0.0; // Cannot flee from the Boss
    }

    /**
     * Overrides the getIntendedAction to provide Boss-specific behavior.
     *
     * @return A string describing the Boss's intended action.
     */
    @Override
    public String getIntendedAction() {
        return getName() + " is summoning a devastating spell!";
    }
}
