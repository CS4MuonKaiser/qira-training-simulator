package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

/** Represents a spell that makes the user dodge the next attack. */

public class Dodge extends Spell{

/** Creates a spell that makes the user dodge the next attack
 * with the already set name, description, mana cost, and advantageousness. 
 */
    
    public Dodge(){
        name = "Dodge";
        description = "Dodge the next attack!";
        manaCost = 40;
        beneficial = false;
    }
    
/** Casts a spell.
 * @param Target The target creature.
 * @param Caster The creature casting the spell.
 * @return A String containing the assurance that the user will dodge the next attack.
 */
    
    @Override
    public String cast(Creature Target, Creature Caster){
        Target.goDodge();
        return(Target.getName() + " will dodge the next attack!");
    }
    
}