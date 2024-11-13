/**
 * Class: Requirement
 * @author Thomas England
 * @version 1.0
 * Course : CSE 201 Fall 2024
 * Written: October 28th, 2024
 *
 * Purpose: This class creates requirements that the user must meet before entering a room.
 */
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
    public boolean check(Player player) {
        // simplified for now
        return isMet;
    }
}
