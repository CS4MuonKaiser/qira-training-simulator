package qiraTrainingSimulator;

/** Represents a spell. */

public abstract class Spell {
    protected String name, description, temp;
    protected int manaCost;
    protected boolean beneficial;
    
/** Gets the spell's name.
 * @return A String representing the spell's name.
 */
        
    public String getName(){
        return name;
    }
    
/** Gets the cost of the mana needed to do the spell.
 * @return An integer representing the spell's mana cost.
 */
        
    public int getCost(){
        return manaCost;
    }
    
/** Gets the advantageousness of the spell.
 * @return A Boolean representing whether the spell is beneficial or not.
 */
    
    public boolean getBenefit(){
        return beneficial;
    }
    
/** Gets the spell's description.
 * @return A String representing the spell's description.
 */
        
    public String getDescription(){
        return description;
    }
    
/** Casts a spell.
 * @param target The opposing creature.
 * @param Caster The creature casting the spell.
 * @return A String containing the spell sequence.
 */
      
    public abstract String cast(Creature target, Creature Caster);
}