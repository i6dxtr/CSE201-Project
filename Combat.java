/**
 * Class: Combat
 *
 * @authors: Josh Rosenblatt, Finn Smart, Brandon Duecaster, Dylan Stoia,
 *          Demetrius Hullum Scott, Thomas England
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Date: 11/20/24
 *
 * Purpose: This class handles the combat system between a Player and an Enemy.
 * It manages the flow of combat, allowing the Player to choose actions such as
 * attacking, defending, using items, or attempting to flee. The class also handles
 * enemy actions and determines the outcome of the combat.
 */
import java.util.Scanner;

public class Combat {
    private Player player;
    private Enemy enemy;
    private boolean isCombatOver;
    private Scanner scanner;

    /**
     * Constructs a Combat instance.
     *
     * @param player  the player involved in the combat
     * @param enemy   the enemy involved in the combat
     * @param scanner the scanner for user input
     */
    public Combat(Player player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.isCombatOver = false;
        this.scanner = scanner;
        // Constructor for player with attributes
    }

    /**
     * Starts the combat loop, allowing the Player to choose actions and the Enemy
     * to respond. The loop continues until either the Player or the Enemy is
     * defeated, or the Player successfully flees.
     */
    public void startCombat() {
        System.out.println("Combat initiated with " + enemy.getName() + "!");
        // Displaying the enemy's health and player's health
        player.displayHealth();
        enemy.displayHealth();

        while (!isCombatOver) {
            System.out.println(enemy.getIntendedAction());
            System.out.println("Choose your action: Attack, Defend, Item, Flee");
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            // Taking an input for an attack with an enemy
            switch (input) {
                case "attack":
                    player.attack(enemy);
                    break;
                case "defend":
                    player.defend();
                    break;
                case "item":
                    useItem();
                    break;
                case "flee":
                    // Display flee
                    if (Math.random() < enemy.getFleeChance()) {
                        System.out.println("You failed to flee from " + enemy.getName() + "!");
                        enemy.attack(player);
                    } else {
                        System.out.println("You successfully fled from " + enemy.getName() + ".");
                        isCombatOver = true;
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid action. Please choose Attack, Defend, Item, or Flee.");
                    continue;
            }
            // end combat, enemy loses
            if (enemy.isDefeated()) {
                System.out.println("You have defeated " + enemy.getName() + "!");
                isCombatOver = true;
                return;
            }

            enemy.attack(player);

            if (player.isDefeated()) {
                System.out.println("You have been defeated by " + enemy.getName() + "!");
                isCombatOver = true;
                return;
            }

            player.displayHealth();
            enemy.displayHealth();

            player.setDefending(false);
        }
    }

    /**
     * Allows the Player to use an item from their inventory during combat. The Player
     * can choose a weapon to attack the Enemy, or a potion to heal themselves.
     */
    private void useItem() {
        Inventory inventory = player.getInventory();
        // Displaying inventory and if the player wants to use an item
        inventory.displayItems();
        System.out.println("Type the name of the item to use, or type 'back' to cancel.");
        System.out.print("> ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back") || input.equalsIgnoreCase("cancel")) {
            return;
        }

        // Using the item in combat or a potion
        Item item = inventory.getItem(input);
        if (item != null) {
            if (item instanceof Weapon) {
                // If the item is a weapon, equip weapon
                player.equipWeapon(item.getName());
                player.attack(enemy);
            } else if (item instanceof Potion) {
                // If the item is a potion, use the potion
                item.use(player);
                inventory.removeItem(item);
            }
        } else {
            System.out.println("You don't have that item.");
        }
    }
}
