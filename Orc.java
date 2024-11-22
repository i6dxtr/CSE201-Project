public class Orc extends Enemy {
    public Orc() {
        super("Orc", "A brutish orc with a crude axe.", 50, 10);
        // Add drops
        Weapon axe = new Weapon("Orcish Axe", "An axe taken from a defeated orc. Deals 12 damage.", 12);
        addDrop(axe);
    }

    @Override
    public String getIntendedAction() {
        return name + " is grunting and preparing to swing its axe.";
    }
}
