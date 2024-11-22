public class Potion extends Item {
    private int healAmount;
    private int damageAmount;
    private double chance;
    private boolean isConsumed;
    private boolean isSuspicious;

    public Potion(String name, String description, int healAmount, int damageAmount, double chance) {
        super(name, description);
        this.healAmount = healAmount;
        this.damageAmount = damageAmount;
        this.chance = chance;
        isConsumed = false;
        isSuspicious = false;
    }

    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }

    @Override
    public void use(Player player) {
        if (isSuspicious) {
            System.out.println("You drink the suspicious potion...");
            if (Math.random() < 0.5) {
                int heal = (int) (player.getMaxHealth() * 0.2);
                player.heal(heal);
                System.out.println("You feel rejuvenated! You gain " + heal + " health.");
            } else {
                int damage = (int) (player.getMaxHealth() * 0.1);
                player.takeDamage(damage);
                System.out.println("Oh no! The potion was poisoned! You lose " + damage + " health.");
            }
            isConsumed = true;
            return;
        }

        // Original potion behavior
        if (!isConsumed) {
            if (Math.random() <= chance) {
                if (healAmount > 0) {
                    player.heal(healAmount);
                    System.out.println("You used " + name + " and healed for " + healAmount + " health.");
                }
                if (damageAmount > 0) {
                    player.takeDamage(damageAmount);
                    System.out.println("You used " + name + " and took " + damageAmount + " damage.");
                }
            } else {
                System.out.println("The " + name + " had no effect.");
            }
            isConsumed = true;
        } else {
            System.out.println("The " + name + " has already been consumed.");
        }
    }
}
