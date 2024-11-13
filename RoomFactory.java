/**
 * Class: RoomFactory
 * A factory class responsible for creating different types of rooms in the game.
 * Provides methods to create specific room instances such as the Enchanted Library, Orc Barracks,
 * Wizard's Laboratory, and Throne Room, each with unique descriptions.
 * 
 * @authors 
 * Dylan Stoia
 * Brandon Duecaster
 * Demetrius Hullum Scott
 * Finn Smart
 * Josh Rosenblatt
 * Thomas England

 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: October 27, 2024
 * 
 * Purpose: This class simplifies the process of creating various room types, each with specific
 * characteristics, by using factory methods.
 */
public class RoomFactory {

    /**
     * Creates and returns an instance of the Enchanted Library room.
     * 
     * @return A Room object representing the Enchanted Library.
     */
    public static Room createEnchantedLibrary() {
        Room library = new Room();
        library.setName("Enchanted Library");
        library.setDescription("A room filled with magical books and artifacts.");
        return library;
    }

    /**
     * Creates and returns an instance of the Orc Barracks room.
     * 
     * @return A Room object representing the Orc Barracks.
     */
    public static Room createOrcBarracks() {
        Room barracks = new Room();
        barracks.setName("Orc Barracks");
        barracks.setDescription("A rough room where orcs rest and plan their raids.");
        return barracks;
    }

    /**
     * Creates and returns an instance of the Wizard's Laboratory room.
     * 
     * @return A Room object representing the Wizard's Laboratory.
     */
    public static Room createWizardsLaboratory() {
        Room laboratory = new Room();
        laboratory.setName("Wizard's Laboratory");
        laboratory.setDescription("An eerie lab filled with bubbling potions and strange devices.");
        return laboratory;
    }

    /**
     * Creates and returns an instance of the Throne Room.
     * 
     * @return A Room object representing the Throne Room.
     */
    public static Room createThroneRoom() {
        Room throneRoom = new Room();
        throneRoom.setName("Throne Room");
        throneRoom.setDescription("An opulent room where the ruler holds court.");
        return throneRoom;
    }
}
