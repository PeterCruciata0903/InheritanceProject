import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon{

    /**
     * 
     * @param other variable of type Pokemon, takes input of other pokemon to attack
     * @param move variable of type Move, takes input of pokemon moves list
     */
    public abstract void attack(Pokemon other, Move move);
    
    public abstract void speak(); // abstract method for pokemon to speak

    // Variable definitions
    protected int hitPoints, powerPoints, hPStat;
    protected String pokemonName, type;
    protected List<Move> attacks = new ArrayList<Move>();
    
    /**
     * 
     * @param hp set to definition of hitpoints
     * @param stat set to definition of hpStat 
     * @param name set to defintion of pokemonName
     * @param t set to definition of type
     */
    public Pokemon(int hp, int stat, String name, String t){
        hitPoints = hp;
        hPStat = stat;
        pokemonName = name;
        type = t;
    }

    /**
     * Default Constructor set to default values
     */
    public Pokemon(){
        hitPoints = 0;
        powerPoints = 0;
        hPStat = 100;
        pokemonName = "missingNo";
        type =  "Normal";
        attacks = List.of(new Move("attack",0,0,"Normal"));
    }

    /**
     * 
     * @return value of hitpoints, type int
     */
    public int getHitPoints() {
        return hitPoints;
        
    }

    /**
     * 
     * @param hitPoints setting hitpoints to total number of hitpoints then updates to remaining number of hp
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * 
     * @return value of PowerPoints, type int
     */
    public int getPowerPoints() {
        return powerPoints;
    }

    /**
     * 
     * @param powerPoints setting Powerpoints to total number of Powerpoints then updates to remaining number of pp
     */
    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    /**
     * 
     * @return name of pokemon 
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * 
     * @param pokemonName setting pokemonName 
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * 
     * @return String of pokemon type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type setting type of pokemon
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * 
     * @return hpStat, hpStat is different then hitPoints, hpStat will never change
     */
    public int gethPStat() {
        return hPStat;
    }

    /**
     * 
     * @param hPStat Setting hpStat once set for a pokemon will never change, serves as total pool of health
     */
    public void sethPStat(int hPStat) {
        this.hPStat = hPStat;
    }

    /**
     * 
     * @return return the list of attacks assigned to the Pokemon
     */
    public List<Move> getAttacks() {
        return attacks;
    }

    /**
     * 
     * @param attacks sets attacks
     */
    public void setAttacks(List<Move> attacks) {
        this.attacks = attacks;
    }

    public Move getMove(int moveChoice) {
        return attacks.get(moveChoice);
    }
}