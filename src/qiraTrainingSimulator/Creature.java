package qiraTrainingSimulator;

import java.util.ArrayList;
import qiraTrainingSimulator.Spells.*;

public class Creature {
    protected int maxHP, currentHP, STR, DEX, DEF, AGI, overkill;
    protected String name;
    protected boolean dodge, crit, found, cast;
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
    public boolean getCrit(){
        return crit;
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
    public void goDodge(){
        dodge = true;
    }
    public void goCrit(){
        crit = true;
    }
    public void damage(int i, Creature c){
        int rand = (int)(Math.random()*101);
        if(!(rand <= (AGI*5) || dodge) || currentHP-i > currentHP){
            if(currentHP-i <=0){
                c.overkill = c.overkill - (currentHP-i);
            }else if(currentHP-i > currentHP){
                System.out.println(this.getName() + " healed " + -i + " points of HP!");
            }
            currentHP = currentHP - i;
        }else{
            System.out.println(this.getName() + " dodged the attack!");
            dodge = false;
        }
        if(currentHP >= maxHP){
            currentHP = maxHP;
        }else if(currentHP <= 0){
            currentHP = 0;
        }
    }
    
    public boolean hasSpell(String n){
        int i = 0;
        found = false;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                found = true;
                return true;
            }
            i++;
        }
        return false;
    }
    public void addSpell(Spell s){
        spellList.add(s);
    }
    public void attack(Creature c){
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*4) || crit){
            damage = damage*2;
            System.out.print("Crit! ");
        }
        damage = (int)(damage - (damage*(0.025*c.getDef())));
        c.damage(damage, this);
        System.out.println("Attack dealt "+ damage + " damage to " + c.name + "!");
    }
    public void turn(Creature c){
        int choice = (int)(Math.random()*5);
        if(getCrit()){
            attack(c);
        }else{
            switch(choice){
                case 1:
                    attack(c);
                    break;
                case 2:
                    if(spellList.get(0) != null){
                        spell(c,spellList.get(0));
                    }else{
                        attack(c);
                    }
                    break;
                case 3:
                    if(!(spellList.get(1) == null)){
                        spell(c,spellList.get(1));
                    }else{
                        attack(c);
                    }
                    break;
                case 4:
                    if(!(spellList.get(2) == null)){
                        spell(c,spellList.get(2));
                    }else{
                        attack(c);
                    }
                    break;
                case 5:
                    if(!(spellList.get(3) == null)){
                        spell(c,spellList.get(3));
                    }else{
                        attack(c);
                    }
                    break;
                default:
                    attack(c);
                    break;
            }
        }
        
    }
    public void spell(Creature c, Spell s){
        if(s.getBenefit()){
            s.cast(this, this);
            found = true;
        }else{
            s.cast(c, this);
            found = true;
        }
    }
    public void spell(Creature c, String n){
        found = false;
        int i = 0;
        while(i<=3){
            if(n.equals(spellList.get(i).getName())){
                while(true){
                    if(spellList.get(i).getBenefit()){
                        spellList.get(i).cast(this, this);
                        found = true;
                        break;
                    }else{
                        spellList.get(i).cast(c, this);
                        found = true;
                        break;
                    }
                }
                if(!found){
                System.out.println("Spell not found!");
                }else{
                    System.out.println("Debug");
                    break;
                }
            }
        }
    }
}