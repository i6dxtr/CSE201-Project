public class Interactable {
    private String name;
    private String description;

    public Interactable() {

    }

    public Interactable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    void interact(Player player, Game game) {
        if (name.equals("book1")) {
            System.out.println("You open \"The Chronicles of the Forgotten Vale\". The book is richly illustrated"
                + "\nwith scenes of a peaceful, idyllic valley. Upon looking at the pictures in detail, the"
                + "\nroom suddenly closes in around you, and everything fades to black.");
            game.gameOver();
        } else if (name.equals("book2")) {
            System.out.println("You open \"A Treatise on Arcane Geometry\". The book is dense and mundane, filled"
                + "\nwith diagrams and discussions about the mathematical underpinnings of spellcasting."
                + "\nUnfortunately, as soon as you begin to understand it, Grug has already noticed you.");
            game.attack("Grug");
        }
    }

    String getDescription(){
        return description;
    }
}
