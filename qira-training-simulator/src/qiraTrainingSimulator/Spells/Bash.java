package qiraTrainingSimulator.Spells;

import qiraTrainingSimulator.*;

public class Bash extends Spell{
    public Bash(){
        name = "Bash";
        description = "High Damage attack that is less affected by Defense";
        manaCost = 30;
        beneficial = false;
    }
    
    @Override
    public String cast(Creature Target, Creature Caster){
        int damage = (int )(Math.random()*((Caster.getStr()+15)-Caster.getStr()+11)+Caster.getStr()+11);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(Caster.getDex()*4) || Caster.getCrit()){
            damage = damage*2;
            temp = ("Crit! ");
        }
        damage = (int)(damage - (damage*(0.015*Target.getDef())));
        Target.damage(damage, Caster);
        return(temp + " \n Bash dealt "+ damage + " damage to " + Target.getName() + "!");
    }
    
}