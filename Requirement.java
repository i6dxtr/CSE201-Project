public class Requirement {
    // String to store requirement description
    private String description;
    // boolean to store status of whether requirement has been met
    private boolean isMet;

    /**
     * Constructs a requirement with a specified description.
     *
     * @param description A string value containing the requirement description
     */
    public Requirement(String description) {
        // every requirement starts off as not met
        this.description = description;
        this.isMet = false;
    }

    /**
     * Checks the status of whether the specified player has met the requirement.
     *
     * @param player The specified player to check requirement status.
     * @return A boolean value indicating true if the requirement has been met or false otherwise.
     */
    public boolean check() {
        // simplified for now
        return isMet;
    }

    public void setRequirementStatus(boolean status) {
        isMet = status;
    }

    public String getRequirementDescription() {
        return this.description;
    }
}
