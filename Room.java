import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Enemy> enemies;
    private Map<String, String> areas;
    private Map<String, Trap> traps;
    private boolean isLocked;
    private Requirement requirement;

    public Room() {
        items = new ArrayList<>();
        enemies = new ArrayList<>();
        areas = new HashMap<>();
        traps = new HashMap<>();
    }

    /**
     * Assuming that this function modifies the state of the class so it doesn't return a value.
     */
    public void enter(Player player) {

    }

    /**
     * Assuming that this just diplays the info of the class so it doesn't return a value.
     */
    public void displayInfo() {

    }

    /**
     * Assuming that this returns an item from the room based on item name.
     */
    public Item getItem(String itemName) {
        return null;
    }

    /**
     * Assuming that this returns an enemy from the room based on enemy name.
     */
    public Enemy getEnemy(String enemyName) {
        return enemies.get(0);
    }

    /**
     * Assuming that this returns nothing since it modifies the state of the room by removing an
     * item from it.
     */
    public void removeItem(Item itemToRemove) {

    }

    /**
     * Assuming that this returns nothing since it modifies the state of the room by adding an
     * item to it.
     */
    public void addItem(Item itemToAdd) {

    }

    public String getName() {
        return this.name;
    }

    public String lookAt(String thing) {
        return ("looking at " + thing + ".");
    }
}
