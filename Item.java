/**
 *
 *  * Class: Item
 *  *
 *  * @authors: Brandon Ducaster, Tom England, Joshua Rosenblatt, Dylan Stoia, Demetrius Hullum Scott
 *  * @version 1.0
 *  * Course: CSE 201 Fall 2024
 *  * Written: November 12, 2024
 *  *
 *  * Purpose: This class represents a generic item in the game. It provides
 *  * attributes for the item's name, description, and whether it is consumable.
 *  * Specific item types can extend this class to provide additional functionality.
 *  */

public class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;

    /**
     * Constructor for item.
     *
     * @param name        Name of the item.
     * @param description Description of the item.
     * @param isConsumable Whether the item is consumable or not.
     */
    public Item(String name, String description, boolean isConsumable) {
        this.name = name;
        this.description = description;
        this.isConsumable = isConsumable;
    }

    /**
     * Default constructor for item.
     */
    public Item() {
        name = "Generic item";
        description = "A perfectly generic item";
        isConsumable = true;
    }

    /**
     * Method for player to use the item.
     *
     * @param player The player that will use the item.
     */
    public void use(Player player) {
        // Empty implementation (used for child classes)
    }

    /**
     * Method to get item's name.
     *
     * @return the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set item's name.
     *
     * @param name the name to set for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get item's description.
     *
     * @return the description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set item's description.
     *
     * @param description the description to set for the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to check if item is consumable.
     *
     * @return true if the item is consumable, false otherwise.
     */
    public boolean isConsumable() {
        return isConsumable;
    }

    /**
     * Method to set item's consumable status.
     *
     * @param isConsumable the consumable status to set for the item.
     */
    public void setConsumable(boolean isConsumable) {
        this.isConsumable = isConsumable;
    }
}
