public class Trap {
    private String name; // name of trap
    private String description; // description of trap
    private int damage; // damage of trap
    private boolean isTriggered; // has the trap been triggered already

    /**
     * Trap Constructor.
     * @param name name of the trap
     * @param description the trap's description
     * @param damage the amount of damage the trap does to the user
     */
    public Trap(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.isTriggered = false;
    }

    /**
     * Getter for the trap's name
     * @return name of the trap
     */
    public String getName() {
        return name;
    }

    /**
     * Returns if the trap has been triggered or not.
     * @return true if the trap has been triggered already, false otherwise
     */
    public boolean isTriggered() {
        return isTriggered;
    }

    /**
     * Returns the damage of the trap.
     * @return the damage dealt by the trap
     */
    public int getDamage() {
        return damage;
    }
}
