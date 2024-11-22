public class Weapon extends Item {

    // Initializing damage variable
    private int damage;

    /**
     * Constructor for the Weapon class.
     * Initializes the weapon with a name, description, and damage value.
     *
     * @param name        The name of the weapon.
     * @param description A short description of the weapon.
     * @param damage      The amount of damage the weapon can deal.
     */
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    /**
     * Retrieves the damage value of the weapon.
     *
     * @return The damage dealt by the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Uses the weapon.
     *
     * @param player The player using the weapon.
     */
    public void use(Player player) {
        System.out.println("You swing the " + name + " but nothing happens.");
    }
}
