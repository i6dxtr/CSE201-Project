import java.util.ArrayList;

/**
 * Class: Inventory
 * Authors: Josh Rosenblatt, Finn Smart, Brandon Duecaster, Dylan Stoia, 
 *          Demetrius Hullum Scott, Thomas England
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 25, 2024
 *
 * Purpose: This class represents a player's inventory, allowing items to be added,
 *          removed, retrieved, and displayed.
 */
public class Inventory {
    private ArrayList<Item> items;

    /**
     * Default constructor, initializes an empty inventory.
     */
    public Inventory(){
        items = new ArrayList<>();
    }

    /**
     * Method to add an item to the player's inventory.
     * 
     * @param item The item to add to the inventory.
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Method to get an item by name from the inventory.
     * 
     * @param itemName The name of the item to get.
     * @return The item if found, null otherwise.
     */
    public Item getItem(String itemName){
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if an item with the given name exists in the inventory.
     * @param itemName The name of the item to check.
     * @return True if the item exists, false otherwise.
     */
    public boolean containsItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the items in the inventory.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your items:");
            for (Item item : items) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    /**
     * Removes a specific item from the inventory.
     * 
     * @param item The item to remove from the inventory.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
