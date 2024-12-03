/**
* Class: Potion
* @author Group 3
* @version 1.0
* Course : CSE201 - Intro to Software Engineering
* Written: 11/20/24
*
* Purpose: – stores and manages data that relates 
* to a potion. Players can use potions to affect some of their 
* stats such as health
*/
public class Potion extends Item {
    private int healAmount;
    private int damageAmount;
    private double chance;
    private boolean isConsumed;
    private boolean isSuspicious;

    /**
     * Constructor for Potion class
     * @param name : the name of the potion
     * @param description : the potions description
     * @param healAmount : the amount that the potion will heal 
     * the player
     * @param damageAmount : the amount that the potion will damage
     * the player
     * @param chance : a percent change (double between 0 and 1) that a potion
     * will have an effect
     */
    public Potion(String name, String description, int healAmount, int damageAmount, double chance) {
        super(name, description, true);
        this.healAmount = healAmount;
        this.damageAmount = damageAmount;
        this.chance = chance;
        isConsumed = false;
        isSuspicious = false;
    }

    /**
     * Setter method for isSuspicious
     * 
     * @param suspicious : a boolean value
     */
    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }

    /**
     * method for a player to user to use a potion
     * @param player : a pointer to the player that will use a potion
     */
    @Override
    public void use(Player player) {
        // Suspicious potions have a chance to heal or hurt the player instead of
        // a chance to have no effect
        if (isSuspicious) {
            System.out.println("You drink the suspicious potion...");
            if (Math.random() < 0.5) {
                int heal = (int) (player.getMaxHealth() * 0.2);
                player.heal(heal);
                System.out.println("You feel rejuvenated! You gain " + heal + " health.");
            } else {
                int damage = (int) (player.getMaxHealth() * 0.1);
                player.takeDamage(damage);
                System.out.println("Oh no! The potion was poisoned! You lose " + damage + " health.");
            }
            isConsumed = true;
            return;
        }

        /* Original potion behavior:
        * There is a chance that the potion will have no effect
        * if it has an effect it will heal and damage the player by
        * a specified ammount (typically heal xor hurt will be 0 so that the player is only
        * healed or hurt)
        * (consumed potions cannot be used)
        */ 
        if (!isConsumed) {
            if (Math.random() <= chance) {
                if (healAmount > 0) {
                    player.heal(healAmount);
                    System.out.println("You used " + name + " and healed for " + healAmount + " health.");
                }
                if (damageAmount > 0) {
                    player.takeDamage(damageAmount);
                    System.out.println("You used " + name + " and took " + damageAmount + " damage.");
                }
            } else {
                System.out.println("The " + name + " had no effect.");
            }
            isConsumed = true;
        } else {
            System.out.println("The " + name + " has already been consumed.");
        }
    }
}
