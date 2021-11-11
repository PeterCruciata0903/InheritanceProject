import java.util.Scanner;

public class PokemonBattleRunner{

    public static void main(String[] args) {

        // Variable Declaration 
        char chosenBall;
        int chosenItem;
        int fightOrFlight;
        /**
         * Object Declaration of Players and Pokemon
         */
        HumanPlayer player1 = new HumanPlayer();
        CPUPlayer cpu = new CPUPlayer();
        Dragonite dragonite = new Dragonite(150, 150,"Dragonite","Dragon");
        Cubone cubone = new Cubone(100, 100, "Cubone", "Ground");


        System.out.println("You are Starting your journey as a Pokemon Trainer, you walk into the Professors lab and you do not seem him there. You see two PokeBalls sitting on his desk with a note that says take one");
        System.out.println("The ball on the right is Dragonite a Dragon type Pokemon, the ball on the left contains Cubone a Ground type Pokemon.");
        System.out.println("Press R for the ball on the Right and L for the ball on the Left");
        Scanner decision = new Scanner(System.in);
        
        /**
         * do while loop for choosing a Pokeball L or R
         * Validity checker 
         */
        do{
            chosenBall = decision.next().charAt(0);
            if(chosenBall == 'R'){
                choosePokemon(dragonite,cubone,player1,cpu);                          
            }
            else if (chosenBall == 'L'){
                choosePokemon(cubone,dragonite,player1,cpu);
            }
            else{
                System.out.println("That is an invalid choice please press R or L");
            }
        }while (chosenBall != 'R'&& chosenBall != 'L');
        System.out.println("You see a Potion and Power Point up on the floor which one will you take");
        System.out.println("Press 1 for Potion and 2 for Power Point up");
        // Declaration of Item objects
        Potion potion = new Potion();
        PowerPoint pp = new PowerPoint();
        /**
         * do while loop for choosing a item 1 or 2
         * Validity checker 
         */
        do{
            chosenItem = decision.nextInt();
            if(chosenItem == 1){
                chooseItem(potion, pp, player1, cpu);
            }
            else if (chosenItem == 2){
                chooseItem(pp, potion, player1, cpu);
            }
            else{
                System.out.println("That is an invalid choice please press 1 or 2");
            }
        }while(chosenItem != 1 && chosenItem != 2);
        System.out.println("A enemy trainer approaches you ready to battle what will you do");
        System.out.println("1: Battle \n2: Run");
        fightOrFlight = decision.nextInt();
        // if else if statement to determine battling
        if(fightOrFlight == 1){
            System.out.println("You have chosen to battle you turn your cap around in anticipation for a fight");
            System.out.println("You send out " + player1.getPlayerPoke().getPokemonName());
            player1.getPlayerPoke().speak();
            boolean isDead = false; // boolean statement to check if battlers are dead
            /**
             * do while loop for battling 
             * Displays battle menu fight or item
             */
            do{
                System.out.println("1. Fight \n2. Item");
                int battleMenu = decision.nextInt();
                do{
                    if(battleMenu == 1){
                        int i =1;
                        // for each loop displaying the attacks of the pokemon
                        for(Move m: player1.getPlayerPoke().getAttacks()){
                            System.out.println(i + "." + m.getName() + " " + m.getPp() + "/" + m.getMaxPP() + " " + m.getDamage());
                            i++;
                        }
                        System.out.println("Choose a move with the number keys");
                        int moveChoice;
                        /**
                         * Do while loop to check the move choice
                         * validity check 
                         */
                        do{
                            moveChoice = decision.nextInt();
                            if(moveChoice <1 && moveChoice >4){
                                System.out.println("This is an invalid input");
                            }
                        }while(moveChoice <1 && moveChoice >4);
                        player1.getPlayerPoke().attack(cpu.getPlayerPoke(), player1.getPlayerPoke().getAttacks().get(moveChoice -1));
                        if(cpu.getPlayerPoke().getHitPoints() <= 0){
                            isDead = true;
                            break;
                        }
                        cpu.cpuAction(player1.getPlayerPoke());
                        if(player1.getPlayerPoke().getHitPoints() <= 0){
                            isDead = true;
                            break;
                        }
                    }
                    else if(battleMenu == 2){
                        player1.getPlayerItems().use(player1.getPlayerPoke());
                        cpu.cpuAction(player1.getPlayerPoke());
                        if(player1.getPlayerPoke().getHitPoints() <= 0){
                            isDead = true;
                            break;
                        }
                    }
                    else{
                        System.out.println("That is an invalid choice please press 1 or 2");
                    }
                }while(battleMenu != 1 && battleMenu != 2);
            }while(!isDead);
            winLose(player1, cpu);
        }
        else if (fightOrFlight == 2){
            System.out.println("You take one look at the trainer and you decide that you stand no chance so you run away in fear never to become the Pokemon Champion");
            player1.run();
        }
        decision.close();
    }

    /**
     * 
     * @param playerPokemon of type Pokemon  assigns a pokemon to the player
     * @param cpuPokemon of type Pokemon assigns a pokemon to computer
     * @param humPlayer of type Player takes assignment of the Pokemon and sets it
     * @param cpuPLayer of type Player takes assignment of the Pokemon and sets it
     */
    public static void choosePokemon(Pokemon playerPokemon, Pokemon cpuPokemon, HumanPlayer humPlayer, CPUPlayer cpuPLayer){
        humPlayer.setPlayerPoke(playerPokemon);
        cpuPLayer.setPlayerPoke(cpuPokemon);
        System.out.println("You have chosen " + playerPokemon.getPokemonName());
        System.out.println("The CPU player got stuck with " + cpuPokemon.getPokemonName());
    }

    /**
     * 
     * @param playerItem  of type Item assigns an item to the player
     * @param cpuItem of type Item assigns an item to the computer 
     * @param humPlayer of type Player takes the assignment of the item and sets it
     * @param cpuPlayer of type Player takes the assignment of the item and sets it
     */
    public static void chooseItem(Item playerItem, Item cpuItem, HumanPlayer humPlayer, CPUPlayer cpuPlayer){
        humPlayer.setPlayerItems(playerItem);
        cpuPlayer.setPlayerItems(cpuItem);
        System.out.println("You have chosen " + playerItem.getPlayerItem());
        System.out.println("The CPU player has " + cpuItem.getPlayerItem());
    }

    /**
     * 
     * @param humanPlayer of type player, checks to see if the assigned Pokemon has fainted
     * @param cpuPlayer of type player, checks to see if the assigned Pokemon has fainted
     * Print statements
     */
    public static void winLose(HumanPlayer humanPlayer, CPUPlayer cpuPlayer){
        if(humanPlayer.getPlayerPoke().getHitPoints() <= 0){
            System.out.println("You have lost the battle you white out and drop all your cash");
        }
        else{
            System.out.println("You won the trainer paid you 5000 Poke Dollars for winning");
        }
    }
}
