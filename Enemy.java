/**
 * Class: Enemy
 *
 * @authors Finn Smart, Brandon Ducaster
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Date: 11/27/24
 *
 * Purpose: This abstract class represents an Enemy in the game. It defines the
 * core attributes and behaviors common to all enemies, such as health, attack
 * power, and the ability to attack players. Specific enemy types should extend
 * this class and provide additional or overridden functionality as needed.
 */

import java.util.List;
import java.util.ArrayList;

public abstract class Enemy {
    protected String name; // Enemy's name
    protected String description; // Description of the enemy
    protected int health; // Current health of the enemy
    protected int maxHealth; // Max health
    protected int attackPower; // How much damage the enemy does per hit
    protected List<Item> drops; // Items the enemy will drop upon defeat

    /**
     * Enemy constructor
     * @param name : name of the enemy
     * @param description : description of the enemy
     * @param health : health of the enemy
     * @param attackPower : how much damage the enemy does per hit
     */
    public Enemy(String name, String description, int health, int attackPower){
        this.name = name;
        this.description = description;
        this.maxHealth = health;
        this.health = health;
        this.attackPower = attackPower;
        this.drops = new ArrayList<>();
    }

    /**
     * Method to get the name of the enemy
     * @return name of the enemy
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the description of the enemy
     * @return description of the enemy
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to get the flee chance of the enemy
     * @return the enemy's flee chance
     */
    public double getFleeChance() {
        return 0.5; // Or some default implementation
    }

    /**
     * Method to get the enemy's intended action (what they decide to do)
     * @return a string with the action the enemy is preparing
     */
    public String getIntendedAction() {
        return name + " is preparing an attack.";
    }

    /**
     * Enemy attacks the player
     * @param player The player to attack
     */
    public void attack(Player player) {
        if (player.isDefending()) {
            System.out.println(name + "'s attack is completely blocked!");
            player.setDefending(false); // Reset defending status
            return;
        }
        int damage = attackPower;
        player.takeDamage(damage);
        System.out.println(name + " attacks you for " + damage + " damage.");
    }

    /**
     * Reduces enemy's health by the specified damage
     * @param damage The damage to deal to the enemy
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage.");
    }

    /**
     * Checks if the enemy is defeated
     * @return true if enemy's health is 0 or less
     */
    public boolean isDefeated() {
        return health <= 0;
    }

    /**
     * Displays the enemy's health status
     */
    public void displayHealth() {
        System.out.println(name + " Health: " + health + "/" + maxHealth);
    }

    /**
     * Gets the current health of the enemy
     * @return current health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Adds an item to the enemy's drop list.
     * @param item The item to add.
     */
    public void addDrop(Item item) {
        drops.add(item);
    }

    /**
     * Returns the list of items the enemy will drop upon defeat.
     * @return List of items.
     */
    public List<Item> getDrops() {
        return drops;
    }
}
