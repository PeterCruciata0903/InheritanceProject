public class Potion implements Item {

    // Variable declaration
    int maxHP;
    int potion = 50;
    
    /**
     * Void method for using a potion
     * Checks that the player is able to use the potion
     * Adds 50 to the health if necessary 
     * Makes sure it does not go over the total health pool of the pokemon
     */
    public void use(Pokemon playerPoke){
        if(playerPoke.getHitPoints()==playerPoke.gethPStat()){
            System.out.println("This Item will have no effect your" + playerPoke +" is already at max HP");
        }
        else if(playerPoke.getHitPoints() < playerPoke.gethPStat()){
            System.out.println("A Potion was used");
            maxHP = playerPoke.getHitPoints() + potion;
            if(maxHP > playerPoke.gethPStat()){
                playerPoke.setHitPoints(playerPoke.gethPStat());
            }
            else{
                playerPoke.setHitPoints(maxHP);
            }
        }
    }

    /**
     * Override from the item class
     * Returns Potion
     */
    @Override
    public String getPlayerItem() {
        // TODO Auto-generated method stub
        return "Potion";
    }
}
