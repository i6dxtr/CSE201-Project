import java.util.ArrayList;

/**
* Class: Inventory
* @author Brandon Duecaster
* @version 1.0
* Course : CSE 201 Fall 2024
* Written: October 29, 2024
*
* Purpose: – class to handle to players inventory
*/
public class Inventory {
    private ArrayList<Item> items;

    /**
     * default constructor, Initializes empty inventory
     */
    public Inventory(){
        items = new ArrayList<>();
    }

    /**
     * Method to add item to players inventory
     * @param item : the item to add to the inventory
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Method to get an item by name from the inventory
     * @param itemName : the name of the item to get
     * @return the item
     */
    public Item getItem(String itemName){
        for(Item item : items){
            if(item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }
}
