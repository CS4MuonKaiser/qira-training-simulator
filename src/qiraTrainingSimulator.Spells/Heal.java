
package qiraTrainingSimulator.Spells;
import qiraTrainingSimulator.*;

public class Heal extends Spell{
    public Heal(){
        name = "Heal";
        description = "Recover HP equal to 5x agility stat, with a minimum of 10 HP";
        manaCost = 20;
        beneficial = true;
    }
    
    @Override
    public void cast(Creature Target, Creature Caster){
        int healing;
        if(Caster.getAgi() <= 2){
            healing = 10;
        }else{
            healing = 2*Caster.getAgi();
        }
        Target.damage(-healing, Caster);
        System.out.println("Heal recovered "+ healing + " health points for " + Target.getName() + "!");
    }
    
}
