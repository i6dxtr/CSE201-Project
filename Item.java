



/**
* Class: Item
* @author Brandon Duecaster
* @version 1.0
* Course : CSE 201 Fall 2024
* Written: October 29, 2024
*
* Purpose: – Class to store information about items for player to use
*/
public class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;

    /**
     * constructor for item
     * @param name : Name of item
     * @param description : description of item
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.isConsumable = true;
    }

    /**
     * default constructor for item
     */
    public Item(){
        name = "Generic item";
        description = "A perfectly generic item";
        isConsumable = true;
    }

    /**
     * Method for player to use the item
     * @param player : that will use the item
     */
    public void use(Player player){
        // Empty implementation (used for child classes)
    }

    /** 
     * Method to get item's name
     */
    public String getName(){
        return name;
    }

    /**
     * method to check if item is consumable
     * @return true if the item is consumable
     */
    public boolean isConsumable() {
        return isConsumable;
    }
}
