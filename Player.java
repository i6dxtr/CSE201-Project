import java.util.Scanner;

public class Player {
    private String name;
    private int maxHealth;
    private int health;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Room currentRoom;
    private boolean isDefending;
    private boolean isDefeated;
    private double damageMultiplier;
    private Scanner scanner;

    public Player(String name, Scanner scanner) {
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.inventory = new Inventory();
        this.equippedWeapon = new Weapon("Basic Sword", "A simple sword.", 10);
        this.inventory.addItem(equippedWeapon);
        this.inventory.addItem(new Potion("Health Potion", "A potion that restores 50 health.", 50, 0, 1.0));
        this.isDefending = false;
        this.isDefeated = false;
        this.damageMultiplier = 1.0;
        this.scanner = scanner;
    }

    // Existing methods (moveTo, displayHealth, getCurrentRoom, setCurrentRoom, etc.)

    public Scanner getScanner() {
        return scanner;
    }

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double multiplier) {
        this.damageMultiplier = multiplier;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(String weaponName) {
        Item item = inventory.getItem(weaponName);
        if (item instanceof Weapon) {
            equippedWeapon = (Weapon) item;
            System.out.println("You have equipped the " + equippedWeapon.getName() + ".");
        } else {
            System.out.println("You don't have a weapon named " + weaponName + ".");
        }
    }

    public void restartGame() {
        // Logic to restart the game can be implemented in the Game class.
    }

    // Modify attack method to include damage multiplier
    public void attack(Enemy enemy) {
        int damage = (int) (equippedWeapon.getDamage() * damageMultiplier);
        enemy.takeDamage(damage);
        System.out.println("You attack " + enemy.getName() + " with your " + equippedWeapon.getName() + " for " + damage + " damage.");
    }

    // Modify takeDamage method to check if health drops to zero
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDefeated = true;
        }
        System.out.println("You take " + damage + " damage.");
    }
}
