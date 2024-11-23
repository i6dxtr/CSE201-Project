public class Orc extends Enemy {
    private String intendedAction;

    public Orc() {
        super("Orc", "A brutish orc with a crude axe.", 50, 10);
        // Add drops
        Weapon axe = new Weapon("Orcish Axe", "An axe taken from a defeated orc. Deals 12 damage.", 12);
        addDrop(axe);
        intendedAction = null;
    }

    public Orc(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
    }

    public void setIntendedAction(String intendedAction) {
        this.intendedAction = intendedAction;
    }

    @Override
    public String getIntendedAction() {
        if (intendedAction == null) {
            return name + " is grunting and preparing to swing its axe.";
        } else {
            return intendedAction;
        }
    }
}
