import java.util.ArrayList;
public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected ArrayList<Item> drops;
    protected boolean isDefeated;

    public Enemy(String name, String description, int health, int attackPower){
        this.name = name;
        this.description = description;
        this.maxHealth = health;
        this.health = health;
        this.attackPower = attackPower;
        this.drops = new ArrayList<>();
        this.isDefeated = false;
    }

    public void attack(Player player) {
        player.receiveDamage(attackPower);
        System.out.println(name + " attacked you for " + attackPower + " damage.");
    }

    public void receiveDamage(int damage) {
        health -= damage;
        System.out.println(name + " received " + damage + " damage.");
        if (health <= 0) {
            health = 0;
            isDefeated = true;
            System.out.println(name + " has been defeated!");
        }
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public void displayHealth() {
        System.out.println(name + "'s Health: " + health + "/" + maxHealth);
    }

    public String getIntendedAction() {
        // Implement logic to determine the enemy's next action
        return name + " is preparing an attack.";
    }

    public String getName() {
        return name;
    }

    public double getFleeChance() {
        // Implement logic for flee chance
        return 0.5; //Default flee chance
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getDrops() {
        return drops;
    }
}
