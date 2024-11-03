public class Boss extends Enemy {

    public Boss(String name, String description, int health, int attackPower) {
        super(name, description, health, attackPower);
    }

    @Override
    public double getFleeChance() {
        return 0.0; // Cannot flee from the Boss
    }

    @Override
    public String getIntendedAction() {
        return getName() + " is summoning a devastating spell!";
    }
}
