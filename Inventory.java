import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(String itemName){
        for(Item item : items){
            if(item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }
}
