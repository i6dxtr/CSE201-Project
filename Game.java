public class Game {
    public Player player;
    public List<Room> rooms;
    public int currentRoomIndex;
    public boolean isGameOver;

    public Game() {
        rooms = new ArrayList<>();
        currentRoomIndex = 0;
        isGameOver = false;
        initializeGame();
    }

    public void initializeGame() {
        // Initialize rooms, player, and other game elements
        player = new Player(name);
        createRooms();
        player.setCurrentRoom(rooms.get(currentRoomIndex));
    }

    public void createRooms() {
        // Create and set up rooms according to the game requirements
        rooms.add(RoomFactory.createEnchantedLibrary());
        rooms.add(RoomFactory.createOrcBarracks());
        rooms.add(RoomFactory.createWizardsLaboratory());
        rooms.add(RoomFactory.createThroneRoom());
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        player.displayHealth();
        while (!isGameOver) {
            Room currentRoom = player.getCurrentRoom();
            currentRoom.enter(player);
            if (isGameOver) {
                break;
            }
            // Process player commands
            processPlayerInput();
        }
    }

    private void processPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine();
        Command command = CommandFactory.getCommand(input, player);
        if (command != null) {
            command.execute(input.split(" "));
        } else {
            System.out.println("I don't understand that command.");
        }
    }

    public void restartGame() {
        // Logic to restart the game
        initializeGame();
        startGame();
    }

    public void exitGame() {
        System.out.println("Thank you for playing!");
        isGameOver = true;
        System.exit(0);
    }

    public void gameOver() {
        System.out.println("Game Over!");
        isGameOver = true;
        // Offer to restart or exit
        System.out.println("Would you like to restart? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            restartGame();
        } else {
            exitGame();
        }
    }


}
