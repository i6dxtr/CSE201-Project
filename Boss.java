public class Boss extends Enemy {

    /**
     * Boss Constructor
     * @param name name of boss
     * @param description boss description
     * @param health boss maxhealth
     * @param attackPower boss attack
     */
    public Boss(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
    }

    /**
     * Returns the flee chance of the player, which wil always be 0.
     */
    @Override
    public double getFleeChance() {
        return 0.0; // Cannot flee from the Boss
    }

    /**
     * Returns the next action of the boss.
     */
    @Override
    public String getIntendedAction() {
        return getName() + " is summoning a devastating spell!";
    }
}
