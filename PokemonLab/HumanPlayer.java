public class HumanPlayer extends Player {
    
    /**
     * 
     * @param poke Human Player will get a pokemon of type Pokemon
     * @param item Human Player will get an item of type Item
     * Super called from the player class
     */
    public HumanPlayer(Pokemon poke, Item item){
        super(poke, item); 
    }

    /**
     * 
     * @param mon Super called to player class to get playerPokemon and set it
     */
    public HumanPlayer(Pokemon mon){
        super(mon);
    }

    /**
     * 
     * @param item Super called to player class to get a playerItem amd set it
     */
    public HumanPlayer(Item item){
        super(item);
    }

    // Default Constructor
    public HumanPlayer() {
    }

    /**
     * Defined run class for Human Player
     */
    @Override
    public void run(){
    System.out.println("You got away safely");
    }

}
