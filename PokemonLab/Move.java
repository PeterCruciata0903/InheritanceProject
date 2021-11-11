public class Move {
    
    // Variable declaration
    String name, moveType;
    int damage;
    int pp , maxPP;


    /**
     * 
     * @return type of attacking move
     */
    public String getMoveType() {
        return moveType;
    }

    /**
     * 
     * @param moveType sets type of attacking move
     */
    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    /**
     * 
     * @return max PowerPoints, every move has a max PP
     */
    public int getMaxPP() {
        return maxPP;
    }

    /**
     * 
     * @param maxPP setting maxPP
     */
    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }

    /**
     * 
     * @return Name of move
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name setting name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return Damage as an integer of an attack
     */
    public int getDamage() {
        return damage;
    }

    /**
     * 
     * @param damage setting damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * 
     * @return get remamining PP this is the method that will be updated
     */
    public int getPp() {
        return pp;
    }

    /**
     * 
     * @param pp setting pp 
     */
    public void setPp(int pp) {
        this.pp = pp;
    }
    
    // default constructor 
    public Move(String name, int damage, int pp, String mT) {
        this.name = name;
        this.damage = damage;
        this.pp = pp;
        this.maxPP = pp;
        this.moveType = mT;
    }

}