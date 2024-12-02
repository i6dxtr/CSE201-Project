/**
 * Class: Combat
 *
 * @authors Tom England, Joshua Rosenblatt, Finn Smart
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Date: 12/2/24
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
    }

    /**
     * Starts the combat loop, allowing the Player to choose actions and the Enemy
     * to respond. The loop continues until either the Player or the Enemy is
     * defeated, or the Player successfully flees.
     */
    public void startCombat() {
        System.out.println("Combat initiated with " + enemy.getName() + "!");
        player.displayHealth();
        enemy.displayHealth();

        while (!isCombatOver) {
            System.out.println(enemy.getIntendedAction());
            System.out.println("Choose your action: Attack, Defend, Item, Flee");
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

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
        inventory.displayItems();
        System.out.println("Type the name of the item to use, or type 'back' to cancel.");
        System.out.print("> ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back") || input.equalsIgnoreCase("cancel")) {
            return;
        }

        Item item = inventory.getItem(input);
        if (item != null) {
            if (item instanceof Weapon) {
                player.equipWeapon(item.getName());
                player.attack(enemy);
            } else if (item instanceof Potion) {
                item.use(player);
                inventory.removeItem(item);
            }
        } else {
            System.out.println("You don't have that item.");
        }
    }
}
