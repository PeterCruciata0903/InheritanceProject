public class Dragonite extends Pokemon {

    /**
     * 
     * @param hp hp of type int defining the total hit points of the pokemon
     * @param stat stat of type int defining the total number of health the pokemon has
     * @param name name of Pokemon type string
     * @param t type of Pokemon type string
     * super called from Pokmeon classs'
     * Attack set and defined as an object in an array list name, pp, damage
     */
    public Dragonite(int hp, int stat, String name, String t){
        super(hp, stat, name, t);
        this.attacks.add(new Move("Thunderbolt", 10 , 10, "Electric"));//Adding object in arraylist    
        this.attacks.add(new Move("Earthquake", 15, 5, "Ground"));    
        this.attacks.add(new Move("Dual Wingbeat", 10, 5, "Flying"));    
        this.attacks.add(new Move("Outrage", 25, 5, "Dragon"));
    }


    /**
     * Overriden attack metod
     * Takes in other of type Pokemon and move of type Move
     * double damageMult set to 1
     * Calculations for type effectiveness done in if else statements
     * Make sure hp does not go below 0 upon being defeated
     */
    @Override
    public void attack(Pokemon other, Move move) {
        double damageMult = 1;
        if(move.getMoveType() == "Ground" && other.getType() == "Ground"){
            damageMult = 0.5;
        }
        else if (move.getMoveType() == "Water" && other.getType() == "Ground"){
            damageMult = 2;
        }
        else if (move.getMoveType() == "Electric" && other.getType() == "Ground"){
            damageMult = 0;
        }
        int hpSetter = other.getHitPoints() - (int)(move.getDamage()*damageMult);
        if(hpSetter < 0){
            hpSetter = 0;
        }
        other.setHitPoints(hpSetter); 
        System.out.println(pokemonName + " used " + move.getName());
        System.out.println(move.getName() + " did " + move.getDamage()*damageMult + " damage to " + other.getPokemonName() + " " + other.getHitPoints()+ "/" + other.gethPStat());
        move.setPp(move.getPp() -1 );
    }
        

    /**
     * Override speak method
     */
    @Override
    public void speak() {
        // TODO Auto-generated method stub
        System.out.println("Dragonite lets out a billowing Roar upon entering the battle");
    }

     
}
