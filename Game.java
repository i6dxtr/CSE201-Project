import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Game {
    private Player player;
    private Map<String, Room> rooms; // Changed from List to Map for easier access
    private boolean isGameOver;

    public Game() {
        rooms = new HashMap<>();
        isGameOver = false;
    }

    public void initializeGame(String name) {
        // Initialize player and rooms
        player = new Player(name);
        createRooms();
        player.setCurrentRoom(rooms.get("Enchanted Library"));
    }

    public void createRooms() {
        Room enchantedLibrary = RoomFactory.createEnchantedLibrary();
        Room orcBarracks = RoomFactory.createOrcBarracks();
        Room wizardsLaboratory = RoomFactory.createWizardsLaboratory();
        Room throneRoom = RoomFactory.createThroneRoom();

        // Connect rooms
        enchantedLibrary.addExit("north", orcBarracks);
        orcBarracks.addExit("south", enchantedLibrary);
        orcBarracks.addExit("east", wizardsLaboratory);
        wizardsLaboratory.addExit("west", orcBarracks);
        wizardsLaboratory.addExit("north", throneRoom);
        throneRoom.addExit("south", wizardsLaboratory);

        // Add rooms to the map
        rooms.put("Enchanted Library", enchantedLibrary);
        rooms.put("Orc Barracks", orcBarracks);
        rooms.put("Wizard's Laboratory", wizardsLaboratory);
        rooms.put("Throne Room", throneRoom);
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        player.displayHealth();
        while (!isGameOver) {
            Room currentRoom = player.getCurrentRoom();
            currentRoom.displayInfo();
            processPlayerInput();
        }
    }

    private void processPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        String[] words = input.split(" ");
        if (words[0].equals("go") && words.length > 1) {
            String direction = words[1];
            Room nextRoom = player.getCurrentRoom().getExit(direction);
            if (nextRoom != null) {
                player.moveTo(nextRoom);
            } else {
                System.out.println("You can't go that way!");
            }
        } else if (input.equals("quit") || input.equals("exit")) {
            exitGame();
        } else {
            System.out.println("I don't understand that command.");
        }
    }

    public void exitGame() {
        System.out.println("Thank you for playing!");
        isGameOver = true;
        System.exit(0);
    }
}
