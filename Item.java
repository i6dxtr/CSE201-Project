public class Item {
    String name;
    String description;
    Boolean isConsumable;

    Item(String name, String description){
        this.name = name;
        this.description = description;
        isConsumable = true;
    }
    Item(){
        name = "Generic item";
        description = "A perfectly generic item";
        isConsumable = true;
    }

    /**
     * Use method for Item class
     * Player will probably be directly
     * effected by item so nothing will be
     * returned
     * @param player : The player object that uses the item
     */
    public void use(Player player){

    }

    /**
     *  Method to get item's name
     * @return name of item
     */
    public String getName(){
        return name;
    }

    /**
     *  Method to get items description
     * @return description of item
     */
    public String getDescription(){
        return description;
    }

    public boolean getConsumable() {
        return this.isConsumable;
    }
}
