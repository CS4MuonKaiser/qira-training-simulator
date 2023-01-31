package qiraTrainingSimulator;

public abstract class Spell {
    protected String name, description;
    protected int manaCost;
    protected boolean beneficial;
    
    public String getName(){
        return name;
    }
    public int getCost(){
        return manaCost;
    }
    public boolean getBenefit(){
        return beneficial;
    }
    public String getDescription(){
        return description;
    }
    public abstract void cast(Creature target, Creature Caster);
}
