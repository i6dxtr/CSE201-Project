import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Enemy> enemies;
    private Map<String, Room> exits; // Added to store exits
    private Map<String, Trap> traps;
    private boolean isLocked;
    private Requirement requirement;

    public Room() {
        items = new ArrayList<>();
        enemies = new ArrayList<>();
        exits = new HashMap<>(); // Initialize exits
        traps = new HashMap<>();
    }

    public void enter(Player player) {
        // For now, do nothing
    }

    public void displayInfo() {
        System.out.println("You are in " + name);
        System.out.println(description);
        // Display available exits
        System.out.println("Exits:");
        for (String direction : exits.keySet()) {
            System.out.println(direction);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    // Method to add an exit
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    // Method to get an exit
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
