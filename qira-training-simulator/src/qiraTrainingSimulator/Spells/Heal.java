package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

/** Represents a spell that heals the user by a certain amount. */

public class Heal extends Spell{

/** Creates a spell that heals the user by a certain amount
 * with the already set name, description, mana cost, and advantageousness. 
 */
    
    public Heal(){
        name = "Heal";
        description = "Recover HP equal to 5x agility stat, with a minimum of 10 HP";
        manaCost = 20;
        beneficial = true;
    }
    
/** Casts a spell.
 * @param Target The target creature.
 * @param Caster The creature casting the spell.
 * @return A String containing the amount of healing the target creature got and the name of the creature.
 */
    
    @Override
    public String cast(Creature Target, Creature Caster){
        int healing;
        if(Caster.getAgi() <= 2){
            healing = 10;
        }else{
            healing = 2*Caster.getAgi();
        }
        Target.damage(-healing, Caster);
        return("Heal recovered "+ healing + " health points for " + Target.getName() + "!");
    }
    
}