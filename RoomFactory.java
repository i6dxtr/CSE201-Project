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
        library.name = "Enchanted Library";
        library.description = "An ancient library filled with dusty books and mysterious artifacts. "
                + "There's a strange open book on a bookshelf in the corner that seems to be expelling an 'Evil energy'. "
                + "On a table to the right, there's a suspicious-looking potion.";

        // Add the strange book interactable
        library.addInteractable("strange book", new Interactable("strange book", "A strange open book that seems to emit an 'Evil energy'."));

        // Add the suspicious potion item
        Potion suspiciousPotion = new Potion("Suspicious Potion", "A potion that looks both inviting and dangerous.", 0, 0, 0.5);
        suspiciousPotion.setSuspicious(true);
        library.addItem(suspiciousPotion);

        return library;
    }

    /**
     * Creates and returns an instance of the Orc Barracks room.
     *
     * @return A Room object representing the Orc Barracks.
     */
    public static Room createOrcBarracks() {
        Room barracks = new Room();
        barracks.name = "Orc Barracks";
        barracks.description = "A rough room where orcs rest and plan their raids. In the corner, some orcs are facing away, standing around their weapons.";

        // Add interactables
        barracks.addInteractable("sneak", new Interactable("sneak", "You can attempt to sneak around the orcs and pickpocket a key."));
        barracks.addInteractable("steal weapons", new Interactable("steal weapons", "You can choose a weapon to steal to fight the orcs."));
        barracks.addInteractable("attack orcs", new Interactable("attack orcs", "You can choose to attack the orcs head-on."));

        // Add Orc Key as an item (for pickpocketing)
        Item orcKey = new Item("Orc Key", "A key that might unlock the next room.");
        barracks.addItem(orcKey);

        // Add orcs as enemies
        Orc grunk = new Orc("Grunk", "An orc fighter guarding the key.", 60, 12);
        Orc zogzug = new Orc("Zogzug", "An orc warrior with a fierce demeanor.", 50, 10);

        // Add weapon drop to Grunk
        Weapon powerfulWeapon = new Weapon("Orcish Greatsword", "A heavy sword that deals significant damage.", 13); // 30% stronger than starting weapon
        grunk.addDrop(powerfulWeapon);
        grunk.addDrop(orcKey); // Grunk has the key as a drop

        barracks.addEnemy(grunk);
        barracks.addEnemy(zogzug);

        return barracks;
    }

    /**
     * Creates and returns an instance of the Wizard's Laboratory room.
     *
     * @return A Room object representing the Wizard's Laboratory.
     */
    public static Room createWizardsLaboratory() {
        Room laboratory = new Room();
        laboratory.name = "Wizard's Laboratory";
        laboratory.description = "An eerie lab filled with bubbling potions and strange devices. "
                + "On the wizard's desk, there are two potions: one blue and one green.";

        // Add interactables for potions
        laboratory.addInteractable("blue potion", new Interactable("blue potion", "A blue potion on the desk."));
        laboratory.addInteractable("green potion", new Interactable("green potion", "A green potion on the desk."));
        laboratory.addInteractable("yellow potion", new Interactable("yellow potion", "A single yellow potion you can choose to drink after picking a potion."));

        return laboratory;
    }

    /**
     * Creates and returns an instance of the Throne Room.
     *
     * @return A Room object representing the Throne Room.
     */
    public static Room createThroneRoom() {
        Room throneRoom = new Room();
        throneRoom.name = "Throne Room";
        throneRoom.description = "An opulent room where the ruler holds court. "
                + "There's a cursed sword and a scary-looking potion on a pedestal.";

        // Add interactables for items
        throneRoom.addInteractable("cursed sword", new Interactable("cursed sword", "A sword that looks powerful but feels ominous."));
        throneRoom.addInteractable("scary potion", new Interactable("scary potion", "A potion that might boost your strength."));

        // Add the final boss
        Boss orcKing = new Boss("Orc King", "A hulking goliath of an orc. Intimidating, regal, and brutal looking.", 150, 25);
        throneRoom.addEnemy(orcKing);

        return throneRoom;
    }

    /**
     * Connects the rooms in sequence.
     */
    public static void connectRooms(Room r1, Room r2, Room r3, Room r4) {
        r1.prevRoom = null;
        r1.nextRoom = r2;
        r2.prevRoom = r1;
        r2.nextRoom = r3;
        r3.prevRoom = r2;
        r3.nextRoom = r4;
        r4.prevRoom = r3;
        r4.nextRoom = null;

        r1.addExit("north", r2);
        r2.addExit("north", r3);
        r3.addExit("north", r4);

        r2.addExit("south", r1);
        r3.addExit("south", r2);
        r4.addExit("south", r3);
    }
}
