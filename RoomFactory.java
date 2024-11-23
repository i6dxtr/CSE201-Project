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
        library.setDescription("A room filled with magical books and artifacts. On your left, you see a large bookshelf with multiple mysterious looking books." +
        "On the right, you see an orc sleeping in the corner.");
        library.addInteractable("book1", new Interactable("book1", "The Chronicles of the Forgotten Vale"));
        library.addInteractable("book2", new Interactable("book2", "Book 2: A Treatise on Arcane Geometry"));

        Weapon club = new Weapon("Rusty Spiked Club", "A club taken from a defeated orc. Deals 5 damage.", 12);
        Orc grug = new Orc("Grug", "A hunched, brutish orc with a rusty spiked club.", 25, 5);
        grug.addDrop(club);
        grug.setIntendedAction("Grug is grunting and preparing to swing his rusty club at you.");

        library.addEnemy(grug);
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
        barracks.setDescription("A rough room where orcs rest and plan their raids. In the middle of the room, multiple orcs rest, around a fire.");
        barracks.addInteractable("sneak", new Interactable("Sneak", "Sneaking past the orcs to the treasure"));
        barracks.addItem(new Item("Orc Key", "A key that might unlock some treasure."));
        barracks.addEnemy(new Orc("Grunk", "Orc Fighter", 60, 12));
        barracks.addEnemy(new Orc("Zogzug", "Orc Warrior", 50, 10));
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
        laboratory.addInteractable("blue potion", new Interactable("Blue Potion", "This potion glows faintly. It might have strange effects if consumed."));
        laboratory.addInteractable("green potion", new Interactable("Green Potion", "A potion that smells sweet and earthy. It could be beneficial."));
        laboratory.addItem(new Item("Yellow Potion", "A mysterious potion that might heal you if consumed."));

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
        throneRoom.addInteractable("throne", new Interactable("Throne", "A grand throne made of gold and jewels. It radiates power and authority."));

        // Add enemies
        throneRoom.addEnemy(new Orc("Orc King", "A hulking golliath of an orc. Intimidating, regal, and brutal looking.", 100, 20)); // Final boss

        // Add items
        throneRoom.addItem(new Item("Cursed Sword", "A powerful sword, but it comes with a curse. Reduces damage by 33%."));
        throneRoom.addItem(new Item("Power Potion", "Boosts your damage by 25% when consumed."));

        return throneRoom;
    }

    public static void connectRooms(Room r1, Room r2, Room r3, Room r4) {
        r1.setPrevRoom(null);
        r1.setNextRoom(r2);
        r2.setPrevRoom(r1);
        r2.setNextRoom(r3);
        r3.setPrevRoom(r2);
        r3.setNextRoom(r4);
        r4.setPrevRoom(r3);
        r4.setNextRoom(null);
    }
}
