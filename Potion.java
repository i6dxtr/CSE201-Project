public class Potion extends Item {

    int healAmount;
    int damageAmount;
    double chance;

    boolean isConsumed;



    Potion(String name, String description, int healAmount, int damageAmount, double chance){
        super(name, description);
        this.healAmount = healAmount;
        this.damageAmount = damageAmount;
        this.chance = chance;
        isConsumed = false;
    }

    // I'm having alot of fun with these default constructors,
    // its gonna be really sad when they have to be replaced
    Potion(){
        super("Red Potion", "Only for those who are worthy");
        healAmount = Integer.MIN_VALUE;
        damageAmount = 0;
        chance = 1;
        isConsumed = false;
    }

    public void use(Player player){
        if(!isConsumed){
            //player.heal(healAmount);
            // or
            //player.health += healAmount;
            //player.health = min(player.maxHealth, player.health);
            isConsumed = true;
        }
    }
}
