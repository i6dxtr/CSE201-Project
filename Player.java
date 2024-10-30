public class Player {
    private String name;
    private int maxHealth;
    private int health;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Room currentRoom;
    private boolean isDefending;

    public Player(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.inventory = new Inventory();
        this.equippedWeapon = new Weapon("Basic Sword", "A simple sword.", 10);
        this.inventory.addItem(equippedWeapon);
        this.isDefending = false;
    }

    public void moveTo(Room room) {
        this.currentRoom = room;
        System.out.println("You move to " + room.getName());
        room.displayInfo();
    }

    public void pickUp(Item item) {
        inventory.addItem(item);
        System.out.println("You picked up " + item.getName());
    }

    public void useItem(String itemName) {
        Item item = inventory.getItem(itemName);
        if (item != null) {
            item.use(this);
            if (item.getConsumable() == true) {
                inventory.removeItem(item);
            }
        } else {
            System.out.println("You don't have " + itemName + " in your inventory.");
        }
    }

    public void attack(Enemy enemy) {
        int damage = equippedWeapon.getDamage();
        enemy.receiveDamage(damage);
        System.out.println("You attacked " + enemy.getName() + " for " + damage + " damage.");
    }

    public void defend() {
        isDefending = true;
        System.out.println("You brace yourself for the next attack.");
    }

    public void flee(Enemy enemy) {
        double chance = enemy.getFleeChance();
        if (Math.random() < chance) {
            System.out.println("You successfully fled from " + enemy.getName());
            currentRoom = previousRoom();
        } else {
            System.out.println("Failed to flee!");
        }
    }

    public void lookAt(String target) {
        currentRoom.lookAt(target);
    }

    public void displayHealth() {
        System.out.println("Health: " + health + "/" + maxHealth);
    }

    public void receiveDamage(int damage) {
        if (isDefending) {
            System.out.println("You blocked the attack!");
            isDefending = false;
        } else {
            health -= damage;
            System.out.println("You received " + damage + " damage.");
            if (health <= 0) {
                health = 0;
                displayHealth();
                System.out.println("You have been defeated!");
                Game game = new Game();
                game.gameOver();
            }
        }
        displayHealth();
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println("You healed for " + amount + " health.");
        displayHealth();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("You equipped " + weapon.getName());
    }

    private Room previousRoom() {
        // Implement logic to return to the previous room
        return null; // Placeholder
    }

    public String getName() {
        return name;
    }
}
