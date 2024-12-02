/**
 * Class: Boss
 *
 * @author Joshua Rosenblatt
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Date: 11/20/24
 *
 * Purpose: This class represents a Boss enemy in the game, which is a type of Enemy.
 * It includes specific behaviors for a Boss, such as preventing the player from fleeing
 * and defining a unique intended action.
 */
public class Boss extends Enemy {

    /**
     * Boss Constructor
     *
     * @param name        name of boss
     * @param description boss description
     * @param health      boss max health
     * @param attackPower boss attack
     */
    public Boss(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
        // Add drops if any
    }

    /**
     * Returns the flee chance of the player, which will always be 0.
     *
     * @return the flee chance, which is 0.0 since fleeing from the Boss is not allowed.
     */
    @Override
    public double getFleeChance() {
        return 0.0; // Cannot flee from the Boss
    }

    /**
     * Returns the next action of the boss.
     *
     * @return a String describing the Boss's intended action.
     */
    @Override
    public String getIntendedAction() {
        return getName() + " is summoning a devastating spell!";
    }
}
