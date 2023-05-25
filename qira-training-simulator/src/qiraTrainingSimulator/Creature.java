package qiraTrainingSimulator;

import java.util.ArrayList;

/** Represents a creature. */

public class Creature {
    protected int maxHP, currentHP, STR, DEX, DEF, AGI, overkill;
    protected String name, temp;
    protected boolean dodge, crit, found, cast;
    protected ArrayList<Spell> spellList = new ArrayList<>();
    
/** Creates a creature with the specified name and stats.
 * @param sr The creature's strength.
 * @param dx The creature's dexterity.
 * @param df The creature's defense.
 * @param ai The creature's agility.
 * @param hp The creature's health.
 * @param name The creature's name.
 */
         
    public Creature(int sr, int dx, int df, int ai, int hp, String name){
        this.name = name;
        STR = sr;
        DEX = dx;
        DEF = df;
        AGI = ai;
        maxHP = hp;
        currentHP = maxHP;
    }
    
/** Gets the creature's stats. */
    
    public void getStats(){
        System.out.println("STR " + STR + " || DEX " + DEX  + " || DEF " + DEF + " || AGI " + AGI);
    }
    
/** Gets the creature's name.
 * @return A String representing the creature's name.
 */
    
    public String getName(){
        return name;
    }
    
/** Gets the chance a creature will dodge.
 * @return A Boolean representing whether the creature will dodge or not.
 */
    
    public boolean getDodge(){
        return dodge;
    }
    
/** Gets the chance a creature will land a critical hit.
 * @return A Boolean representing whether the creature will land a critical hit or not.
 */
    
    public boolean getCrit(){
        return crit;
    }
    
/** Gets the creature's strength.
 * @return An integer representing the creature's strength.
 */
    
    public int getStr(){
        return STR;
    }
    
/** Gets the creature's dexterity.
 * @return An integer representing the creature's dexterity.
 */
    
    public int getDex(){
        return DEX;
    }
    
/** Gets the creature's defense.
 * @return An integer representing the creature's defense.
 */
    
    public int getDef(){
        return DEF;
    }
    
/** Gets the creature's agility.
 * @return An integer representing the creature's agility.
 */
    
    public int getAgi(){
        return AGI;
    }
    
/** Gets the creature's current health.
 * @return An integer representing the creature's current health.
 */
    
    public int getHP(){
        return currentHP;
    }
    
/** Gets the creature's maximum health.
 * @return An integer representing the creature's maximum health.
 */
    
    public int getMaxHP(){
        return maxHP;
    }
    
/** Gets the creature's overkill.
 * @return An integer representing the creature's overkill.
 */
    
    public int getOverkill(){
        return overkill;
    }
    
/** Sets the creature's dodge to true. */
    
    public void goDodge(){
        dodge = true;
    }
    
/** Sets the creature's crit to true. */
    
    public void goCrit(){
        crit = true;
    }
    
/** Calculates if the attack will land.
 * @param i The damage that will be dealt, if ever.
 * @param c The creature.
 * @return A String containing the status of the creature.
 */
    
    public String damage(int i, Creature c){
        int rand = (int)(Math.random()*101);
        if(!(rand <= (AGI*5) || dodge) || currentHP-i > currentHP){
            currentHP = currentHP - i;
            if(currentHP-i <=0){
                c.overkill = c.overkill - (currentHP-i);
            }else if(currentHP-i > currentHP){
                return(this.getName() + " healed " + -i + " points of HP!");
            }
        }else{
            dodge = false;
            return(this.getName() + " dodged the attack!");
        }
        if(currentHP >= maxHP){
            currentHP = maxHP;
        }else if(currentHP <= 0){
            currentHP = 0;
        }
        return(null);
    }
    
/** Determines if the spell is in the list of spells.
 * @param n The indicated spell.
 * @return A Boolean representing whether the spell is in the list of spells or not.
 */
        
    public boolean hasSpell(String n){
        int i = 0;
        found = false;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                found = true;
                return true;
            }
            i++;
        }
        return false;
    }
    
/** Adds a spell to the list of spells.
 * @param s The indicated spell.
 */
      
    public void addSpell(Spell s){
        spellList.add(s);
    }
    
/** Calculates the amount of damage to be dealt by the attack.
 * @param c The intended creature.
 * @return A String containing the amount of damage dealt and the name of the opposing creature.
 */
    
    public String attack(Creature c){
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*4) || crit){
            damage = damage*2;
            damage = (int)(damage - (damage*(0.025*c.getDef())));
            c.damage(damage, this);
            return("Crit! \n Attack dealt "+ damage + " damage to " + c.name + "!");
        }
        damage = (int)(damage - (damage*(0.025*c.getDef())));
        c.damage(damage, this);
        return("Attack dealt "+ damage + " damage to " + c.name + "!");
    }
    
/** Randomly generates the action that the inputted creature does that turn.
 * @param c The intended creature.
 * @return A String containing the creature's action that turn.
 */
    
    public String turn(Creature c){
        int choice = (int)(Math.random()*5);
        if(getCrit()){
            attack(c);
        }else{
            switch(choice){
                case 1:
                    temp = attack(c);
                    break;
                case 2:
                    if(spellList.get(0) != null){
                        temp = spell(c,spellList.get(0));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 3:
                    if(!(spellList.get(1) == null)){
                        temp =spell(c,spellList.get(1));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 4:
                    if(!(spellList.get(2) == null)){
                        temp = spell(c,spellList.get(2));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 5:
                    if(!(spellList.get(3) == null)){
                        temp = spell(c,spellList.get(3));
                    }else{
                        temp =attack(c);
                    }
                    break;
                default:
                    temp = attack(c);
                    break;
            }
        }
        return(temp);
    }
    
/** Makes the creature use a spell.
 * @param c An opposing creature.
 * @param s The spell it will do.
 * @return A String representing the depending spell sequence that occurs if the spell is beneficial or not.
 */
    
    public String spell(Creature c, Spell s){
        if(s.getBenefit()){
            temp = s.cast(this, this);
            found = true;
        }else{
            temp = s.cast(c, this);
            found = true;
        }
        return(temp);
    }
    
    public void spell(Creature c, String n){
        found = false;
        int i = 0;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                while(true){
                    if(spellList.get(i).getBenefit()){
                        spellList.get(i).cast(this, this);
                        found = true;
                        break;
                    }else{
                        spellList.get(i).cast(c, this);
                        found = true;
                        break;
                    }
                }
                if(!found){
                System.out.println("Spell not found!");
                }else{
                    System.out.println("Debug");
                    break;
                }
            }
        }
    }
}