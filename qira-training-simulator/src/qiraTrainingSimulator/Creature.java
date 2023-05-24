package qiraTrainingSimulator;

import java.util.ArrayList;
/**
 * 
 * @author Alino-Bartolome-Mulsid
 * @version 1.3
 * @params strength, dexterity, intelligence, defense, agility, maxHealth, name, job
 * @returns strength, dexterity, defense, agility, maxHealth, currentHealth, name, consoleText
 */

public class Creature {
    protected int maxHP, currentHP, STR, DEX, DEF, AGI, overkill;
    protected String name, temp;
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
    public String damage(int i, Creature c){
        int rand = (int)(Math.random()*101);
        if(!(rand <= (AGI*5) || dodge) || currentHP-i > currentHP){
            currentHP = currentHP - i;
            if(currentHP-i <=0){
                c.overkill = c.overkill - (currentHP-i);
            }else if(currentHP-i > currentHP){
                return(this.getName() + " healed " + -i + " points of HP!");
            }
        }else{
            dodge = false;
            return(this.getName() + " dodged the attack!");
        }
        if(currentHP >= maxHP){
            currentHP = maxHP;
        }else if(currentHP <= 0){
            currentHP = 0;
        }
        return(null);
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
    public String attack(Creature c){
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*4) || crit){
            damage = damage*2;
            damage = (int)(damage - (damage*(0.025*c.getDef())));
            c.damage(damage, this);
            return("Crit! \n Attack dealt "+ damage + " damage to " + c.name + "!");
        }
        damage = (int)(damage - (damage*(0.025*c.getDef())));
        c.damage(damage, this);
        return("Attack dealt "+ damage + " damage to " + c.name + "!");
    }
    public String turn(Creature c){
        int choice = (int)(Math.random()*5);
        if(getCrit()){
            attack(c);
        }else{
            switch(choice){
                case 1:
                    temp = attack(c);
                    break;
                case 2:
                    if(spellList.get(0) != null){
                        temp = spell(c,spellList.get(0));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 3:
                    if(!(spellList.get(1) == null)){
                        temp =spell(c,spellList.get(1));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 4:
                    if(!(spellList.get(2) == null)){
                        temp = spell(c,spellList.get(2));
                    }else{
                        temp = attack(c);
                    }
                    break;
                case 5:
                    if(!(spellList.get(3) == null)){
                        temp = spell(c,spellList.get(3));
                    }else{
                        temp =attack(c);
                    }
                    break;
                default:
                    temp = attack(c);
                    break;
            }
        }
        return(temp);
    }
    public String spell(Creature c, Spell s){
        if(s.getBenefit()){
            temp = s.cast(this, this);
            found = true;
        }else{
            temp = s.cast(c, this);
            found = true;
        }
        return(temp);
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