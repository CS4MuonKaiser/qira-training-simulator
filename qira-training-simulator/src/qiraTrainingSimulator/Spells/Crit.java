package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

public class Crit extends Spell{
    public Crit(){
        name = "Crit";
        description = "Your next attack will be a critical hit!";
        manaCost = 40;
        beneficial = false;
    }
    
    @Override
    public String cast(Creature Target, Creature Caster){
        Target.goCrit();
        return(Target.getName() + " will have their next attack crit!");
    }
    
}