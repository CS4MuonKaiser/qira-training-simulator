package qiraTrainingSimulator;

public abstract class Spell {
    protected String name, description, temp;
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
    public abstract String cast(Creature target, Creature Caster);
}
