package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

public class Dodge extends Spell{
    public Dodge(){
        name = "Dodge";
        description = "Dodge the next attack!";
        manaCost = 40;
        beneficial = false;
    }
    
    @Override
    public String cast(Creature Target, Creature Caster){
        Target.goDodge();
        return(Target.getName() + " will dodge the next attack!");
    }
    
}