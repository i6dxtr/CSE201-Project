import java.util.*;
import java.util.function.Consumer;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private Map<String, Interactable> interactables;
    private List<Enemy> enemies;

    public Room() {
        exits = new HashMap<>();
        items = new ArrayList<>();
        interactables = new HashMap<>();
        enemies = new ArrayList<>();
    }

    // Existing methods (getName, setName, getDescription, setDescription, addExit, getExit, etc.)

    /**
     * Adds an interactable object to the room.
     *
     * @param name The name of the interactable.
     * @param interactable The interactable object.
     */
    public void addInteractable(String name, Interactable interactable) {
        interactables.put(name.toLowerCase(), interactable);
    }

    /**
     * Retrieves an interactable by name.
     *
     * @param name The name of the interactable.
     * @return The interactable object.
     */
    public Interactable getInteractable(String name) {
        return interactables.get(name.toLowerCase());
    }

    /**
     * Adds an item to the room.
     *
     * @param item The item to add.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Retrieves an item by name from the room.
     *
     * @param itemName The name of the item.
     * @return The item if found, null otherwise.
     */
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Removes an item from the room.
     *
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Other methods like displayInfo, enter, etc., remain the same.

    /**
     * Allows the player to look at an object or area.
     *
     * @param target The object or area to look at.
     */
    public void lookAt(String target) {
        // Check interactables
        Interactable interactable = interactables.get(target.toLowerCase());
        if (interactable != null) {
            System.out.println("You see " + target + ".");
            return;
        }

        // Check items
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(target)) {
                System.out.println(item.getDescription());
                return;
            }
        }

        // Check enemies
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(target)) {
                System.out.println(enemy.getDescription());
                return;
            }
        }

        System.out.println("You don't see a " + target + " here.");
    }

    /**
     * Adds an enemy to the room.
     *
     * @param enemy The enemy to add.
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    /**
     * Retrieves an enemy by name from the room.
     *
     * @param enemyName The name of the enemy.
     * @return The enemy if found, null otherwise.
     */
    public Enemy getEnemy(String enemyName) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    /**
     * Removes an enemy from the room.
     *
     * @param enemy The enemy to remove.
     */
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
}
