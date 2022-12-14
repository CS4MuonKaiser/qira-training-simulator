
public abstract class Spell {
    protected String name;
    protected int manaCost;
    
    public Spell(String n, int m){
        name = n;
        manaCost = m;
    }
    public String getName(){
        return name;
    }
    public int getCost(){
        return manaCost;
    }
    public abstract void cast();
}
