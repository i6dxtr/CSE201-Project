/**
 * Class: Weapon
 * Represents a weapon item in the game that extends the base Item class.
 * Each weapon has a specific damage value.
 * 
 * @authors 
 * Dylan Stoia
 * Brandon Duecaster
 * Demetrius Hullum Scott
 * Finn Smart
 * Josh Rosenblatt
 * Thomas England
 * 
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: October 26, 2024
 * 
 * Purpose: This class provides functionality for weapons, allowing them to be used by players
 * in combat scenarios. The damage value of each weapon can be accessed and may affect
 * combat outcomes.
 */
public class Weapon extends Item {
    
    // Initializing damage variable
    private int damage;

    /**
     * Workhorse Constructor for the Weapon class.
     * Initializes the weapon with a name, description, and damage value.
     * 
     * @param name        The name of the weapon.
     * @param description A short description of the weapon.
     * @param damage      The amount of damage the weapon can deal.
     */
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    /**
     * Retrieves the damage value of the weapon.
     * 
     * @return The damage dealt by the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Uses the weapon. Implementation left  empty
     * 
     * @param player The player using the weapon.
     */
    public void use(Player player) {
        // Implementation left empty
    }
}
