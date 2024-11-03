public class Trap {
    private String name;
    private String description;
    private int damage;
    private boolean isTriggered;

    public Trap(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.isTriggered = false;
    }

    public String getName() {
        return name;
    }

    public boolean isTriggered() {
        return isTriggered;
    }
}
