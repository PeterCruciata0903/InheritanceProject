import java.util.Random;

public class CPUPlayer extends Player {
    
    /**
     * 
     * @param poke of type Pokemon
     * @param item of type Item
     * Super calls them from extended Player class and assigns a value
     */
    public CPUPlayer(Pokemon poke, Item item){
        super(poke, item);
    }

    public CPUPlayer(Pokemon mon){
        super(mon);
    }

    public CPUPlayer(Item item){
        super(item);
    }

    public CPUPlayer() {
    }

    /**
     * 
     * @param other of type Pokemon
     * RNG for player actions
     * 10% chance to use an item 
     * 85% chance to attack
     * 5% chance to run
     * if CPU attacks, it chooses from 1 of 4 moves
     */
    public void cpuAction(Pokemon other){
        Random cpu = new Random();
        int cpuBattler = cpu.nextInt(20);
        if(cpuBattler < 3){
            System.out.println("Computer battler used a " + this.getPlayerItems().getPlayerItem());
            this.getPlayerItems().use(this.getPlayerPoke());
        }
        else if(cpuBattler > 3 && cpuBattler < 18){
            System.out.println("Computer battler is preparing to attack");
            int moveChoice = cpu.nextInt(4);
            Move move = playerPoke.getMove(moveChoice);
            this.getPlayerPoke().attack(other, move);
        }
        else{
            run();
        }
    }
    

    @Override
    public void run(){
        Random run = new Random();
        int bound = 1;
        int flee = run.nextInt(bound);
        if (flee == 0){
            System.out.println("You fool you cannot escape");
        }
        else{
            System.out.println("You got away safely");
        }
    }
}
