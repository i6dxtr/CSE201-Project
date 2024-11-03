/**
* Class: Enemy
* @author Josh
* @version 1.0
* Course : CSE 201 Fall 2024
* Written: October 30, 2024
*
* Purpose: – Class to store enemy Information and methods
*/
public abstract class Enemy {
    protected String name; // Enemy's name
    protected String description; // Discription of the enemy
    protected int health; // Current health of the enemy
    protected int maxHealth; // Max health
    protected int attackPower; // How much damage the enemy does per hit

    /**
     * Enemy contrstuctor
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
    }

    /**
     * Method to get the name of the enemy
     * @return name of the enemy
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the flee chance of the enemy
     * @return the enemys flee chance
     */
    public double getFleeChance() {
        return 0.5; // Or some default implementation
    }

    /**
     * Method to get the enemies action (what they decide to do)
     * @return a string with the action the enemy is preparing
     */
    public String getIntendedAction() {
        return "Enemy is preparing an attack.";
    }
}
