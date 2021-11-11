public abstract class Player {
    
    /**
     * abstract method run, allows the trainer to run from battle
     */
    public abstract void run();

    // Variable declaration
    protected Pokemon playerPoke;
    private Item playerItem;

    // default constructor
    public Player(){       
    }

    /**
     * 
     * @param poke Variable of type Pokemon
     * @param item Varibale of type Item
     * These will be assigned to a player object before the start of the battle
     */
    public Player(Pokemon poke, Item item){
        playerPoke = poke;
        playerItem = item;
    }

    /**
     * 
     * @param mon Setting mon to equal playerPoke
     */
    public Player(Pokemon mon){
        playerPoke = mon;
    }

    /**
     * 
     * @param item Setting item
     */
    public Player(Item item){
        playerItem = item;
    }

    /**
     * 
     * @return player Pokemon
     */
    public Pokemon getPlayerPoke() {
        return playerPoke;
    }

    /**
     * 
     * @param playerPoke setting playerPoke
     */
    public void setPlayerPoke(Pokemon playerPoke) {
        this.playerPoke = playerPoke;
    }

    /**
     * 
     * @return player Item 
     */
    public Item getPlayerItems() {
        return playerItem;
    }
    
    /**
     * 
     * @param playerItem Setting player Item
     */
    public void setPlayerItems(Item playerItem) {
        this.playerItem = playerItem;
    }
    
}
