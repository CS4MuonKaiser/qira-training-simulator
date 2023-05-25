package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

/** Represents a spell that makes the next attack a critical hit. */

public class Crit extends Spell{

/** Creates a spell that makes the next attack a critical hit
 * with the already set name, description, mana cost, and advantageousness. 
 */
    
    public Crit(){
        name = "Crit";
        description = "Your next attack will be a critical hit!";
        manaCost = 40;
        beneficial = false;
    }
    
/** Casts a spell.
 * @param Target The target creature.
 * @param Caster The creature casting the spell.
 * @return A String containing the assurance that the user's next attack will be a critical hit.
 */
    
    @Override
    public String cast(Creature Target, Creature Caster){
        Target.goCrit();
        return(Target.getName() + " will have their next attack crit!");
    }
    
}