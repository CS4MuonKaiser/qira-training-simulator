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
    public void cast(Creature Target, Creature Caster){
        Target.goCrit();
        System.out.println(Target.getName() + " will have their next attack crit!");
    }
    
}
