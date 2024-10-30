public class Weapon extends Item {
    int damage;

    // implemented in UML diagram, but should
    // discuss this being handled in inventory class
    boolean isEquipped;

    Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage;
    }

    // dont call this
    Weapon(){
        super("The Default Constructor Deconstructor", 
        "Instantly Deconstructs anything");
        damage = Integer.MAX_VALUE;
    }

    /**
     * I am of the opinion that this is
     * implemented in the inventory class
     * but here is following the uml for now
     * until we discuss
     * @param player
     */
    public void equip(Player player){

    }

    /**
     * method to get weapons damage
     * @return damage
     */
    public int getDamage(){
        return damage;
    }

    /**
     * not sure how this is going to work
     */
    public void use(Player player){

    }
}
