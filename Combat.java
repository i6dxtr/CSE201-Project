///**
// * Class: Combat
// * Represents a combat scenario between the player and an enemy.
// * Handles combat actions such as attack, defend, use item, and flee.
// * Manages the turn-based combat flow and displays relevant information.
// *
// * Author: Josh Rosenblatt
// * Version: 1.0
// * Course: CSE 201 Fall 2023
// * Written: October 1, 2023
// */
//
//
//import java.util.Scanner;
//
//public class Combat {
//    // The player involved in combat
//    private Player player;
//
//    // The enemy involved in combat
//    private Enemy enemy;
//
//    // Indicates whether combat is over
//    private boolean isCombatOver;
//
//    // Scanner for user input during combat
//    private Scanner scanner;
//
//    /**
//     * Constructor to create a combat scenario between the player and an enemy.
//     *
//     * @param player The player.
//     * @param enemy  The enemy.
//     */
//    public Combat(Player player, Enemy enemy) {
//        this.player = player;
//        this.enemy = enemy;
//        this.isCombatOver = false;
//        this.scanner = new Scanner(System.in);
//    }
//
//    /**
//     * Starts the combat loop.
//     */
//    public void startCombat() {
//        System.out.println("Combat initiated with " + enemy.getName() + "!");
//        player.displayHealth();
//        enemy.displayHealth();
//
//        while (!isCombatOver) {
//            System.out.println(enemy.getIntendedAction());
//            System.out.println("Choose your action: Attack, Defend, Item, Flee");
//            System.out.print("> ");
//            String input = scanner.nextLine().toLowerCase();
//
//            switch (input) {
//                case "attack":
//                    player.attack(enemy);
//                    break;
//                case "defend":
//                    player.defend();
//                    break;
//                case "item":
//                    useItem();
//                    break;
//                case "flee":
//                    if (player.flee(enemy)) {
//                        isCombatOver = true;
//                        return;
//                    }
//                    break;
//                default:
//                    System.out.println("Invalid action. Please choose Attack, Defend, Item, or Flee.");
//                    continue;
//            }
//
//            if (enemy.isDefeated()) {
//                System.out.println("You have defeated " + enemy.getName() + "!");
//                isCombatOver = true;
//                return;
//            }
//
//            // Enemy's turn
//            enemy.attack(player);
//
//            if (player.getHealth() <= 0) {
//                isCombatOver = true;
//                return;
//            }
//
//            player.displayHealth();
//            enemy.displayHealth();
//        }
//    }
//
//    /**
//     * Allows the player to use an item during combat.
//     */
//    private void useItem() {
//        player.getInventory().displayItems();
//        System.out.println("Type the name of the item to use, or type 'back' to cancel.");
//        System.out.print("> ");
//        String input = scanner.nextLine().toLowerCase();
//
//        if (input.equals("back") || input.equals("cancel")) {
//            return;
//        }
//
//        Item item = player.getInventory().getItem(input);
//        if (item != null) {
//            item.use(player);
//            if (item.isConsumable()) {
//                player.getInventory().removeItem(item);
//            }
//        } else {
//            System.out.println("You don't have that item.");
//        }
//    }
//}
