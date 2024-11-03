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
    }

    public void displayHealth() {
        System.out.println("Health: " + health + "/" + maxHealth);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public String getName() {
        return name;
    }
}
