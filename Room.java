import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class: Room
 * @author Thomas England
 * @version 1.0
 * Course : CSE 201 Fall 2024
 * Written: October 28th, 2024
 *
 * Purpose: This class creates rooms that the user can navigate through. Each room has a name,
 * description, items, enemies, exits, traps, and a requirement that the user must meet before
 * entering.
 */
public class Room {
    // Strings to store room name and description
    private String name;
    private String description;
    // lists to store room's items and enemies
    private List<Item> items;
    private List<Enemy> enemies;
    // maps to store room's exits and traps
    private Map<String, Room> exits;
    private Map<String, Trap> traps;
    // boolean to store rooms' locked status
    private boolean isLocked;
    // Requirement object to hold requirement the user must meet to unlock room.
    private Requirement requirement;

    /**
     * Constructs a blank room object with no items, enemies, exits, or traps.
     */
    public Room() {
        // initialize array lists and hashmaps
        items = new ArrayList<>();
        enemies = new ArrayList<>();
        exits = new HashMap<>();
        traps = new HashMap<>();
    }

    /**
     * Enters the player into the room, acts as main driver to walk user through room and allow
     * user to interact with items and enemies. Not implemented yet.
     *
     * @param player The player object who has entered the room.
     */
    public void enter(Player player) {
        // For now, do nothing
    }

    /**
     * Displays information about this room to the user.
     */
    public void displayInfo() {
        // print room name and description
        System.out.println("You are in " + name);
        System.out.println(description);
        // print available exits
        System.out.println("Exits:");
        for (String direction : exits.keySet()) {
            System.out.println(direction);
        }
    }

    /**
     * Changes the room's name to a specified string.
     *
     * @param name A string containing the new name for the room.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Retrieves the name of this room.
     *
     * @return A string containing the name of this room.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Modifies the description of this room.
     *
     * @param description A string containing the new description for this room.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Retrieves the description of this room.
     *
     * @return A string containing the description of this room.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Adds an exit to this room (leads to another room).
     *
     * @param direction String indicating the cardinal direction of the exit.
     * @param room Room object indicating the room that the exit leads to.
     */
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    /**
     * Retrieves an exit from this room by a specified cardinal direction.
     *
     * @param direction String containing the cardinal direction of the exit to retrieve.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
