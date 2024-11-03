public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected int maxHealth;
    protected int attackPower;

    public Enemy(String name, String description, int health, int attackPower){
        this.name = name;
        this.description = description;
        this.maxHealth = health;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public double getFleeChance() {
        return 0.5; // Or some default implementation
    }

    public String getIntendedAction() {
        return "Enemy is preparing an attack.";
    }
}
