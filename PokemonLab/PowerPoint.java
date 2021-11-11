public class PowerPoint implements Item {
    
   // Variable declaration 
   int ppUP = 5;
   int newPP;

    /**
     * Void method for using player item
     * takes in Pokemon class with variable playerPoke
     * method checks to make sure using the PowerPoint up will have any effect
     */
    public void use(Pokemon playerPoke){


        System.out.println("A Power Point up was used");
        for(Move m: playerPoke.getAttacks()){
            newPP = m.getPp() + ppUP;
            if(newPP > m.getMaxPP()){
                m.setPp(m.getMaxPP());
            }
            else{
                m.setPp(newPP);
            }
        }
    }

    /**
     * Overidden Method from item
     * Returns item as PowerPoint up
     */
    @Override
    public String getPlayerItem() {
        // TODO Auto-generated method stub
        return "Power Point Up";
    }
}
