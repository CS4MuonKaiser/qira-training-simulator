
package qiraTrainingSimulator;

import java.util.Scanner;
import qiraTrainingSimulator.Spells.*;

public class Player extends Creature{
    protected int INT, mana;
    protected String job, weapon1, weapons;
    Scanner sc = new Scanner(System.in);
    public Player(int sr, int dx, int it, int df, int ai, int hp, String name, String job){
        super(sr, dx, df, ai, hp, name);
        INT = it;
        mana = 100;
        int points = 10;
        this.job = job;
        while(points > 0){
            int temp = (int)(Math.random()*5);
            switch(temp){
                case 1:
                    STR++;
                    points--;
                    break;
                case 2:
                    DEX++;
                    points--;
                    break;
                case 3:
                    INT++;
                    points--;
                    break;
                case 4:
                    DEF++;
                    points--;
                    break;
                case 5:
                    AGI++;
                    points--;
                    break;
            }
        }
    }
    public String getJob(){
        return job;
    }
    @Override
    public void getStats(){
        System.out.println("STR " + STR + " || DEX " + DEX + " || INT " + INT + " || DEF " + DEF + " || AGI " + AGI);
    }
    
    void statBump(int points,boolean heal){
        Scanner sc = new Scanner(System.in);
        while(points>0){
            maxHP = maxHP + (int)(2*points);
            System.out.println("======================================");
            System.out.println("Increase Stat (" + points + ") remaining");
            System.out.println("STR " + STR + " || DEX " + DEX + " || INT " + INT + " || DEF " + DEF + " || AGI " + AGI);
            System.out.println("======================================");
            String temp = sc.nextLine();
            switch(temp.toUpperCase()){
                case "STR":
                    STR++;
                    points--;
                    break;
                case "DEX":
                    DEX++;
                    points--;
                    break;
                case "INT":
                    INT++;
                    points--;
                    break;
                case "DEF":
                    DEF++;
                    points--;
                    break;
                case "AGI":
                    AGI++;
                    points--;
                    break;
                default:
                    System.out.println("Wrong Input!");
            }
        }
        if(heal){
        this.damage(-(int)(maxHP/3), this);
        }
    }
    @Override
    public void attack(Creature c){
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*5) || crit == true){
            damage = damage*2;
            System.out.print("Crit! ");
        }
        mana = mana+10;
        if(mana >=100){
            mana = 100;
        }
        damage = (int)(damage - (damage*(0.025*DEF)));
        System.out.println("Attack dealt "+ damage + " damage to " + c.getName());
        c.damage(damage, this);
    }
    public void spell(Creature c){
        int i = 0;
        found = false;
        cast = false;
        while(i<=3){
            System.out.print("| " + spellList.get(i ).getName() + " |");
            i++;
        }
        System.out.print("\n");
        System.out.println("======================================");
        String choice = sc.nextLine();
        System.out.println("======================================");
        i = 0;
        while(i<=3){
            if(choice.toUpperCase().equals(spellList.get(i).getName().toUpperCase())){
                while(true){
                    if(cast){
                        break;
                    }
                    found = true;
                    System.out.println(spellList.get(i).getDescription());
                    System.out.println("| CAST || COST:" + (int)(spellList.get(i).getCost() - spellList.get(i).getCost()*(0.025*INT)) + " || MANA: " + mana + "/100 || BACK |");
                    System.out.println("======================================");
                    String ttemp = sc.nextLine();
                    System.out.println("======================================");
                    if(ttemp.equalsIgnoreCase("cast")){
                        while(true){
                            System.out.println("Targetting... \n + " + name + " \n + " + c.name);
                            System.out.println("======================================");
                            String temp = sc.nextLine();
                            System.out.println("======================================");
                            if(temp.toUpperCase().equals(name.toUpperCase())){
                                if(mana -(spellList.get(i).getCost() - spellList.get(i).getCost()*(0.025*INT)) <= 0){
                                    System.out.println("Out of Mana!");
                                    break;
                                }
                                spellList.get(i).cast(this, this);
                                mana = mana - (int)(spellList.get(i).getCost() - spellList.get(i).getCost()*(0.025*INT));
                                cast = true;
                                break;
                            }else if(temp.toUpperCase().equals(c.name.toUpperCase())){
                                if(mana - (spellList.get(i).getCost() - spellList.get(i).getCost()*(0.025*INT)) <= 0){
                                    System.out.println("Out of Mana!");
                                    break;
                                }
                                spellList.get(i).cast(c, this);
                                mana = mana - (int)(spellList.get(i).getCost() - spellList.get(i).getCost()*(0.025*INT));
                                cast = true;
                                break;
                            }else{
                                System.out.println("Creature not found!");
                            }
                        }
                    }else {
                        break;
                    }
                }
            }
            if(i == 3 || found){
                break;
            }
            i++;
            }
        if(!found){
            System.out.println("Spell not found!");
            i = 0;
        }
    }
}
