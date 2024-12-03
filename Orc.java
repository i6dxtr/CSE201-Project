/**
 * Class: Orc
 *
 * @author Brandon Ducaster, Tom England, Joshua Rosenblatt, Dylan Stoia, Demetrius Hullum Scott
 * @version 1.0
 * Course: CSE 201 Fall 2024
 * Written: November 2, 2024
 *
 * Purpose: This class represents an Orc enemy in the game. Orcs are brutish
 * enemies with specific behaviors, including a default intended action and the
 * ability to customize their intended action. This class extends the Enemy
 * class and provides additional functionality specific to Orcs.
 */
public class Orc extends Enemy {
    // The intended action of the Orc (e.g., attacking, defending)
    private String intendedAction;

    /**
     * Default constructor for creating a standard Orc with predefined attributes
     * and a default drop.
     */
    public Orc() {
        super("Orc", "A brutish orc with a crude axe.", 50, 10);

        // Add default weapon drop
        Weapon axe = new Weapon("Orcish Axe", "An axe taken from a defeated orc. Deals 12 damage.", 12);
        addDrop(axe);

        intendedAction = null;
    }

    /**
     * Constructor for creating a custom Orc with specific attributes.
     *
     * @param name        The name of the Orc.
     * @param description The description of the Orc.
     * @param health      The maximum health of the Orc.
     * @param attackPower The attack power of the Orc.
     */
    public Orc(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
    }

    /**
     * Sets the intended action of the Orc, which determines its behavior in combat.
     *
     * @param intendedAction The action the Orc is preparing to take.
     */
    public void setIntendedAction(String intendedAction) {
        this.intendedAction = intendedAction;
    }

    /**
     * Returns the Orc's intended action in combat. If no specific action is set,
     * a default action is returned.
     *
     * @return A string describing the Orc's intended action.
     */
    @Override
    public String getIntendedAction() {
        if (intendedAction == null) {
            return name + " is grunting and preparing to swing its axe.";
        } else {
            return intendedAction;
        }
    }
}
