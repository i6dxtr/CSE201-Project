import java.util.Scanner;

public class Combat {
    private Player player;
    private Enemy enemy;
    private boolean isCombatOver;
    private Scanner scanner;

    public Combat(Player player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.isCombatOver = false;
        this.scanner = scanner;
    }

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
                        // Enemy attacks immediately
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

            // Enemy's turn
            enemy.attack(player);

            if (player.isDefeated()) {
                System.out.println("You have been defeated by " + enemy.getName() + "!");
                isCombatOver = true;
                return;
            }

            player.displayHealth();
            enemy.displayHealth();

            // Reset defending status after enemy's attack
            player.setDefending(false);
        }
    }

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
            // item.use(player);
            // if (item.isConsumable()) {
            //     inventory.removeItem(item);
            // }
        } else {
            System.out.println("You don't have that item.");
        }
    }
}
