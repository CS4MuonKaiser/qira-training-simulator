import java.util.ArrayList;

public class Creature {
    protected int maxHP, currentHP, STR, DEX, DEF, AGI, overkill;
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
    public int getHP(){
        return currentHP;
    }
    public int getMaxHP(){
        return maxHP;
    }
    public int getOverkill(){
        return overkill;
    }
    public void damage(int i, Creature c){
        int rand = (int)(Math.random()*101);
        if(!(rand <= (AGI*5) || dodge) || currentHP-i > currentHP){
            if(currentHP-i <=0){
                c.overkill = c.overkill - (currentHP-i);
            }else if(currentHP-i > currentHP){
                System.out.println(c.getName() + " healed " + -i + " points of HP!");
            }
            currentHP = currentHP - i;
        }else{
            System.out.println(this.getName() + " dodged the attack!");
        }
        if(currentHP >= maxHP){
            currentHP = maxHP;
        }else if(currentHP <= 0){
            currentHP = 0;
        }
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
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*4) || crit){
            damage = damage*2;
            System.out.print("Crit! ");
        }
        damage = (int)(damage - (damage*(0.025*DEF)));
        c.damage(damage, this);
        System.out.println("Attack dealt "+ damage + " damage to " + c.name + "!");
    }
    public void spell(Creature c, String n){
        found = false;
        int i = 0;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                while(true){
                    if(spellList.get(i).getBenefit()){
                        spellList.get(i).cast(this);
                        found = true;
                        break;
                    }else{
                        spellList.get(i).cast(c);
                        found = true;
                        break;
                    }
                }
                if(!found){
                System.out.println("Spell not found!");
                }
            }
        }
    }
}
