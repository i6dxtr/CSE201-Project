public class Requirement {
    private String description;
    private boolean isMet;

    public Requirement(String description) {
        this.description = description;
        this.isMet = false;
    }

    public boolean check(Player player) {
        // Simplified for now
        return isMet;
    }
}
