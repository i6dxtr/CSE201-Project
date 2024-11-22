import java.util.ArrayList;

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
     * @param item The item to add to the inventory.
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Method to get an item by name from the inventory.
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
     * Removes an item from the inventory.
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
