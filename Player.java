
import java.util.Scanner;

/**
* Class: Player
* @author Group 3
* @version 1.0
* Course : CSE201 - Intro to Software Engineering
* Written: 
*
* Purpose: – stores and manages data that relates 
to the games player character
*/
public class Player {
    private String name;
    private int maxHealth;
    private int health;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Room currentRoom;
    private boolean isDefending;
    private boolean isDefeated;
    private double damageMultiplier;
    private Scanner scanner;

    public Player(String name, Scanner scanner) {
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.inventory = new Inventory();
        this.equippedWeapon = new Weapon("Basic Sword", "A simple sword.", 10);
        this.inventory.addItem(equippedWeapon);
        this.inventory.addItem(new Potion("Health Potion", "A potion that restores 50 health.", 50, 0, 1.0));
        this.isDefending = false;
        this.isDefeated = false;
        this.damageMultiplier = 1.0;
        this.scanner = scanner;
    }

    /**
     * Method to get the players inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * getter method for is defeated variable
     */
    public boolean isDefeated() {
        return isDefeated;
    }

    /**
     * setter method for damageMultiplier
     */
    public void setDamageMultiplier(double multiplier) {
        this.damageMultiplier = multiplier;
    }

    /**
     * method to set make the player defend or not
     */
    public void setDefending(boolean value) {
        isDefending = value;
    }

    /**
     * Method to display the players health stats
     */
    public void displayHealth() {
        System.out.println("Health: " + getHealth() + "/" + getMaxHealth());
    }

    /**
     * Method to make the player defend
     */
    public void defend() {
        isDefending = true;
    }

    /**
     * getter method for the isDefending variable
     * @return isDefending
     */
    public boolean isDefending() {
        return isDefending;
    }

    /**
     * method for player to equip a weapon
     * @param weaponName : The name of the weapon to equip
     */
    public void equipWeapon(String weaponName) {
        Item item = inventory.getItem(weaponName);
        if (item instanceof Weapon) {
            equippedWeapon = (Weapon) item;
            System.out.println("You have equipped the " + equippedWeapon.getName() + ".");
        } else {
            System.out.println("You don't have a weapon named " + weaponName + ".");
        }
    }

    /**
     * Method for a player to attack an enemy
     * The attacks damage is based on the players weapon and
     * the players damage multiplier
     * @param enemy : pointer to enemy that is being attacked
     */
    public void attack(Enemy enemy) {
        int damage = (int) (equippedWeapon.getDamage() * damageMultiplier);
        enemy.takeDamage(damage);
        System.out.println("You attack " + enemy.getName() + " with your " + equippedWeapon.getName() + " for " + damage + " damage.");
    }

    /**
     * Method for the player to take damage
     *
     * If the players health drops below zero, they
     * become defeated (isDefeated becomes true)
     *
     * @param damage : damamge for the player to take
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDefeated = true;
        }
        System.out.println("You take " + damage + " damage.");
    }

    /**
     * Method to heal the player
     *
     * @param amount : amount to heal the player by
     * (this is capped at the players max heath)
     */
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println("you heal for " + amount + " health. You now have " + health + " health");
    }

    /**
     * Method to move the player to a new room
     * @param room : a pointer to the room to move to
     */
    public void moveTo(Room room) {
        if (currentRoom.getNextRoom().equals(room) || currentRoom.getPrevRoom().equals(room))
            currentRoom = room;
        else
            System.out.println("Attempted to move outside of player bounds");
    }

    //
    // GETTER METHODS
    //

    /**
     * getter method for current room
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * getter method for the players scanner (user input)
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * getter method for maxHealth
     * @return maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * getter method for health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * getter method for damageMultiplier
     * @return damageMultiplier
     */
    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    /**
     * getter method for equipped weapon
     * @return equippedWeapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * getter method for players name
     * @return name
     */
    public String getName() {
        return name;
    }

    //
    // SETTERS
    //

    /**
     * setter method for isDefeated
     * @param defeated : boolean value to set defeated to
     */
    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

    /**
     * setter method for current room
     * @param room : room to set the current room to
     */
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
}
