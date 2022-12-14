
import java.util.ArrayList;

/**
 *
 * @author kaise
 */
public class Creature {
    protected int maxHP, currentHP, STR, DEX, DEF, AGI;
    protected String name;
    protected boolean dodge, crit, found;
    protected ArrayList<Spell> spellList = new ArrayList<>();
    public Creature(int sr, int dx, int df, int ai, int hp, String name){
        this.name = name;
        STR = sr;
        DEX = dx;
        DEF = df;
        AGI = ai;
        maxHP = hp;
        currentHP = maxHP;
    }
    public void getStats(){
        System.out.println("STR " + STR + " || DEX " + DEX  + " || DEF " + DEF + " || AGI " + AGI);
    }
    public String getName(){
        return name;
    }
    public boolean getDodge(){
        return dodge;
    }
    public int getStr(){
        return STR;
    }
    public int getDex(){
        return DEX;
    }
    public int getDef(){
        return DEF;
    }
    public int getAgi(){
        return AGI;
    }
    public void hasSpell(String n){
        int i = 0;
        found = false;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                System.out.println(name + " has the spell " + n);
                found = true;
            }
            if(!found){
                System.out.println("Spell not found!");
            }
        }
    }
    public void attack(Creature c){
        int damage = (int )(Math.random()*((STR+20)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*5) || crit == true){
            damage = damage*2;
            System.out.print("Crit! ");
        }
        System.out.println("Attack dealt "+ damage + " damage!");
    }
    public void castSpell(String n){
        found = false;
        int i = 0;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                spellList.get(i).cast();
                found = true;
            }
            if(!found){
                System.out.println("Spell not found!");
            }
        }
    }
}
