public class Item {
    protected String name;
    protected String description;
    protected boolean isConsumable;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.isConsumable = true;
    }

    public Item(){
        name = "Generic item";
        description = "A perfectly generic item";
        isConsumable = true;
    }

    public void use(Player player){
        // Empty implementation
    }

    public String getName(){
        return name;
    }

    public boolean isConsumable() {
        return isConsumable;
    }
}
