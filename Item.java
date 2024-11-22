public class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;

    /**
     * Constructor for item.
     * @param name        Name of the item.
     * @param description Description of the item.
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.isConsumable = true;
    }

    /**
     * Default constructor for item.
     */
    public Item(){
        name = "Generic item";
        description = "A perfectly generic item";
        isConsumable = true;
    }

    /**
     * Method for player to use the item.
     * @param player The player that will use the item.
     */
    public void use(Player player){
        // Empty implementation (used for child classes)
    }

    /**
     * Method to get item's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Method to get item's description.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Method to check if item is consumable.
     * @return true if the item is consumable.
     */
    public boolean isConsumable() {
        return isConsumable;
    }
}
