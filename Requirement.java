/**
 * This class creates requirements that the player must meet.
 *
 * @author Thomas England
 */
class Requirement {
    // string to store description of the requirement
    private String description;
    // boolean to store status of whether the requirement has been met
    private boolean isMet;

    /**
     * Creates a requirement with a specified description.
     *
     * @param description A string containing the description for the requirement to create.
     * @return A newly created Requirement object with the specified description.
     */
    public Requirement(String description) {
        this.description = description;
    }

    /**
     * Retrieves the description for this requirement.
     *
     * @return A string containing the description for this requirement.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the status of whether the requirement has been met by the player.
     *
     * @param player The player object representing the player who has or has not met this
     * requirement.
     * @return A boolean indicating true if the requirement has been met, or false otherwise.
     */
    public boolean check(Player player) {
        // add logic to determine if the requirement has been met by the player.
        return false;
    }

    /**
     * Sets the status on whether the requirement has been met.
     *
     * @param isMet A boolean value indicating whether the requirement has been met.
     */
    public void setIsMet(boolean isMet) {
        this.isMet = isMet;
    }
}
