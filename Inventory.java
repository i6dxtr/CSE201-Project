import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items;

    Inventory(){
        items = new ArrayList<Item>();
    }
    
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Method to remove item from inventory
     * @param item : the item to be removed
     * @return item that was removed (or null)
     */
    public Item removeItem(Item item){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == item){
                return items.remove(i);
                
            }
        }
        return null;
    }

    /**
     * Method to get an item from the inventory
     * based on its name (if there are multiple
     * items of the same name, it will get the
     * lower indexed item)
     * 
     * (note: may exchange arraylist for map if
     * we are only accessing by name)
     * 
     * @param itemName : the name of the item to get
     * @return the item from the inventory (or null)
     */
    public Item getItem(String itemName){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).name.equals(itemName)){
                return items.get(i);
                
            }
        }
        return null;
    }

    /**
     * Method to display all items in inventory
     * (placeholder)
     */
    public void displayItems(){
        System.out.println("---Inventory---");
        for(Item item : items){
            System.out.println(item.getName());
            System.out.println(item.getDescription());
            System.out.println("---------------");
        }
    }

}
