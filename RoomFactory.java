public class RoomFactory {

    public static Room createEnchantedLibrary() {
        Room library = new Room();
        library.setName("Enchanted Library");
        library.setDescription("A room filled with magical books and artifacts.");
        return library;
    }

    public static Room createOrcBarracks() {
        Room barracks = new Room();
        barracks.setName("Orc Barracks");
        barracks.setDescription("A rough room where orcs rest and plan their raids.");
        return barracks;
    }

    public static Room createWizardsLaboratory() {
        Room laboratory = new Room();
        laboratory.setName("Wizard's Laboratory");
        laboratory.setDescription("An eerie lab filled with bubbling potions and strange devices.");
        return laboratory;
    }

    public static Room createThroneRoom() {
        Room throneRoom = new Room();
        throneRoom.setName("Throne Room");
        throneRoom.setDescription("An opulent room where the ruler holds court.");
        return throneRoom;
    }
}
