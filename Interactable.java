import java.util.Random;
import java.util.Scanner;

public class Interactable {
    private String name;
    private String description;

    public Interactable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    void interact(Player player, Game game, Scanner scanner) {
        switch (name) {
            case "book1" -> book1Interaction(game);
            case "book2" -> book2Interaction(game);
            case "sneak" -> sneakInteraction(player, game);
            case "steal weapons" -> stealWeaponsInteraction(player, game, scanner);
        }
    }

    private void book1Interaction(Game game) {
        System.out.println("\n--------------------------------------------------------------------------------------"
                        + "\nYou open \"The Chronicles of the Forgotten Vale\". The book is richly illustrated"
                        + "\nwith scenes of a peaceful, idyllic valley. Upon looking at the pictures in detail, the"
                        + "\nroom suddenly closes in around you, and everything fades to black.\n"
                        + "--------------------------------------------------------------------------------------\n");
        game.gameOver();
    }

    private void book2Interaction(Game game) {
        System.out.println("\n--------------------------------------------------------------------------------------"
                        + "\nYou open \"A Treatise on Arcane Geometry\". The book is dense and mundane, filled"
                        + "\nwith diagrams and discussions about the mathematical underpinnings of spellcasting."
                        + "\nUnfortunately, as soon as you begin to understand it, Grug has already noticed you.\n"
                        + "--------------------------------------------------------------------------------------\n");
        game.attack("Grug");
    }

    private void sneakInteraction(Player player, Game game) {
        if (player.getInventory().containsItem("Orc Key")) {
            Random rand = new Random();
            boolean playerDead = rand.nextBoolean();

            if (playerDead) {
                System.out.println("\n--------------------------------------------------------------------------------------"
                                + "\nYou sneak past the orcs with the key in your pocket. Just as you reach the exit, you "
                                + "\nrealize you've been noticed. You try to run, but the distance between you and the orcs "
                                + "\ncloses quickly."
                                + "\n--------------------------------------------------------------------------------------\n");
                game.gameOver();
            } else {
                System.out.println("\n--------------------------------------------------------------------------------------"
                                + "\nYou begin to walk past the orcs with the key clutched tightly in your hand. The orcs are"
                                + "\ntoo distracted by the fire, and by some miracle, you escape their notice."
                                + "\n--------------------------------------------------------------------------------------\n");
                player.setCurrentRoom(player.getCurrentRoom().getExit("north"));
            }
        } else {
            System.out.println("\n--------------------------------------------------------------------------------------"
                            + "\nYou begin to walk past the orcs without the key. You realize it might be smart to have"
                            + "\nit, so you walk back to get it, and Grunk and Zozug notice you. Better luck next time."
                            + "\n--------------------------------------------------------------------------------------\n");
            game.gameOver();
        }
    }

    private void stealWeaponsInteraction(Player player, Game game, Scanner scanner) {
        System.out.println("\n--------------------------------------------------------------------------------------"
                        + "\nIn the corner of the room, you see 3 weapons. Choose wisely:"
                        + "\n 1: An old, heavy crossbow"
                        + "\n 2: A light, thin, but heavily barbed spear"
                        + "\n 3: A big, shiny, but extremely heavy sword"
                        + "\n--------------------------------------------------------------------------------------\n");
        System.out.print("> ");

        String response = scanner.nextLine().trim();
        int responseNum;

        try {
            responseNum = Integer.parseInt(response);
            switch (responseNum) {
                case 1 -> {
                    Weapon crossbow = new Weapon("crossbow", "An old, heavy crossbow", 12);
                    player.getInventory().addItem(crossbow);
                    System.out.println("You picked up the crossbow.");
                }
                case 2 -> {
                    Weapon spear = new Weapon("spear", "A light, thin, but heavily barbed spear", 13);
                    player.getInventory().addItem(spear);
                    System.out.println("You picked up the spear.");
                }
                case 3 -> {
                    Weapon sword = new Weapon("sword", "A big, shiny, but extremely heavy sword", 20);
                    player.getInventory().addItem(sword);
                    System.out.println("You picked up the sword.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.println("Grunk and Zozug noticed you stealing their weapons, and they won't let you flee...");
        while (player.getCurrentRoom().getEnemy("Grunk") != null) {
            game.attack("Grunk");
        }
        while(player.getCurrentRoom().getEnemy("Zozug") != null) {
            game.attack("Zozug");
        }

        // add orc key to player inventory after successfully killing orcs
    }

    String getDescription(){
        return description;
    }
}
