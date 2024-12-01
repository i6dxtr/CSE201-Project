import java.util.*;


/**
* Class: Potion
* @author Group 3
* @version 1.0
* Course : CSE201 - Intro to Software Engineering
* Written: 
*
* Purpose: – stores and manages data that relates 
* to a Room. In the game, players will traverse through rooms
* and interact with the items in them
*/
public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private Map<String, Interactable> interactables;
    private List<Enemy> enemies;
    private Room nextRoom;
    private Room prevRoom;

    public Room() {
        exits = new HashMap<>();
        items = new ArrayList<>();
        interactables = new HashMap<>();
        enemies = new ArrayList<>();
    }

    /**
     * method to set the next room
     * @param nextRoom : the room that comes after the current room
     */
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    /**
     * method to set the previous room
     * @param prevRoom : the room that comes before the current room
     */
    public void setPrevRoom(Room prevRoom) {
        this.prevRoom = prevRoom;
    }

    /**
     * method to get the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the name of a room
     * @param name : name to set the room to
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * method to get the description of a room
     */
    public String getDescription() {
        return description;
    }

    /**
     * method to set the description of the room
     *
     * @param description : the description of the room to be set to
     */
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    /**
     * method to get the next room
     */
    public Room getNextRoom() {
        return nextRoom;
    }

    /**
     * Method to get the previous room
     */
    public Room getPrevRoom() {
        return prevRoom;
    }

    /**
     * method to add an exit to a room
     *
     * @param direction : the direction of an exit
     * @param room : the room which the exit will take the player
     */
    public void addExit(String direction, Room room) {
        if (direction == null || direction.trim().isEmpty() || room == null) {
            throw new IllegalArgumentException("Direction and room cannot be null or empty.");
        }
        exits.put(direction.toLowerCase(), room);
    }

    /**
     * Method to get the next room via exit direction
     * @param direction : the direction that the exit is
     */
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    /**
     * method to remove an exit from the room
     *
     * @param direction : the direction of the exit to remove
     */
    public void removeExit(String direction) {
        exits.remove(direction.toLowerCase());
    }

    /**
     * method to get a set of the exits of a room
     */
    public Set<String> listExits() {
        return exits.keySet();
    }

    /**
     * method to add an item to the room
     * @param item : the item to add
     */
    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        items.add(item);
    }

    /**
     * Method to get an item from the room
     * @param itemName : the name of the item to get
     */
    public Item getItem(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) return null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * method to remove item from the room
     * @param item : a pointer to the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Method to get a list of the rooms items
     */
    public List<Item> listItems() {
        return new ArrayList<>(items);
    }

    /**
     * method to add an interactable to the room
     *
     * @param name : the name of the interactable (map key)
     * @param interactable : the interactable to add (map value)
     */
    public void addInteractable(String name, Interactable interactable) {
        if (name == null || name.trim().isEmpty() || interactable == null) {
            throw new IllegalArgumentException("Name and interactable cannot be null or empty.");
        }
        interactables.put(name.toLowerCase(), interactable);
    }

    /**
     * Method to get an interactable by its name
     * @param name : name of the interactable to get
     */
    public Interactable getInteractable(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        return interactables.get(name.toLowerCase());
    }

    /**
     * Method to get the names of all the rooms interactables
     */
    public Set<String> listInteractables() {
        return interactables.keySet();
    }

    /**
     * Method to add an enemy to the rooms enemy list
     * @param enemy : the enemy to add
     */
    public void addEnemy(Enemy enemy) {
        if (enemy == null) {
            throw new IllegalArgumentException("Enemy cannot be null.");
        }
        enemies.add(enemy);
    }

    /**
     * Method to get an enemy by name from the list of enemies
     * @param enemyName : the name of the enemy to get from the list
     */
    public Enemy getEnemy(String enemyName) {
        if (enemyName == null || enemyName.trim().isEmpty()) return null;
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    /**
     * Method to remove an enemy from a room
     * @param enemy : a pointer to the enemy to remove
     */
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    /**
     * method to get a list of the enemies within the room
     */
    public List<Enemy> listEnemies() {
        return new ArrayList<>(enemies);
    }

    /**
     * method for a player to look at an object (items, interactables, enemies, etc)
     * within a room
     *
     * @param target : the name of the object for a player to look at
     */
    public void lookAt(String target) {
        if (target == null || target.trim().isEmpty()) {
            System.out.println("There's nothing specific to look at.");
            return;
        }

        // Check interactables
        Interactable interactable = interactables.get(target.toLowerCase());
        if (interactable != null) {
            System.out.println("You see " + interactable.getDescription() + ".");
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
                System.out.println("You see " + enemy.getName() + ": " + enemy.getDescription());
                return;
            }
        }

        System.out.println("You don't see a " + target + " here.");
    }

    /**
     * Method to display the info of a room
     */
    public void displayInfo() {
        System.out.println("Room: " + (name != null ? name : "Unnamed Room"));
        System.out.println("Description: " + (description != null ? description : "No description provided."));
        System.out.println("Exits: " + (exits.isEmpty() ? "None" : String.join(", ", exits.keySet())));
        System.out.println("Items: " + (items.isEmpty() ? "None" : String.join(", ", items.stream().map(Item::getName).toList())));
        System.out.println("Interactables: " + (interactables.isEmpty() ? "None" : String.join(", ", interactables.keySet())));
        System.out.println("Enemies: " + (enemies.isEmpty() ? "None" : String.join(", ", enemies.stream().map(Enemy::getName).toList())));
    }

    /**
     * Method called when the player enters a room
     *
     */
    public void enter(Player player) {
        displayInfo();
    }
}
