package qiraTrainingSimulator;

import java.util.*;
import javax.swing.*;
import qiraTrainingSimulator.Layout.*;

/** Represents the player. */

public class Player extends Creature{
    protected int INT, mana;
    protected String job, weapon1, weapons;
    Scanner sc = new Scanner(System.in);
    
/** Creates a player with the specified name, job, and stats.
 * @param sr The player's strength.
 * @param dx The player's dexterity.
 * @param it The player's intelligence.
 * @param df The player's defense.
 * @param ai The player's agility.
 * @param hp The player's health.
 * @param name The player's name.
 * @param job The player's job.
 */
      
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
    
/** Gets the player's job.
 * @return A String representing the player's job.
 */
    
    public String getJob(){
        return job;
    }
    
/** Gets the player's mana.
 * @return An integer representing the player's mana.
 */
    
    public int getMana(){
        return mana;
    }

/** Gets the player's stats. */
    
    @Override
    public void getStats(){
        System.out.println("STR " + STR + " || DEX " + DEX + " || INT " + INT + " || DEF " + DEF + " || AGI " + AGI);
    }
    
/** Allows the player to level up their stats.
 * @param points The number of points the player can use to level up.
 */
        
    public void statBump(int points,boolean heal){
        JFrame window = new SkillLayout();
        Scanner sc = new Scanner(System.in);
        while(points>0){
            Object[] options = { "STR", "DEX", "INT", "DEF", "AGI"};
            int temp = JOptionPane.showOptionDialog(null, "Increase Stat (" + points + ") remaining", "Level Up!", 0, 3, null, options, options[0]);
            switch(temp){
                case 0:
                    STR++;
                    points--;
                    break;
                case 1:
                    DEX++;
                    points--;
                    break;
                case 2:
                    INT++;
                    points--;
                    break;
                case 3:
                    DEF++;
                    points--;
                    break;
                case 4:
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
    
/** Calculates the amount of damage to be dealt by the attack.
 * @param c The intended creature.
 * @return A String containing the amount of damage dealt and the name of the opposing creature.
 */
    
    @Override
    public String attack(Creature c){
        int damage = (int )(Math.random()*((STR+10)-STR+1)+STR);
        int rand = (int )(Math.random()*101);
        if (rand <= 5+(DEX*5) || crit == true){
            damage = damage*2;
            System.out.print("Crit! ");
            damage = (int)(damage - (damage*(0.025*DEF)));
            c.damage(damage, this);
            return("Crit \n Attack dealt "+ damage + " damage to " + c.getName());
        }
        mana = mana+10;
        if(mana >=100){
            mana = 100;
        }
        damage = (int)(damage - (damage*(0.025*DEF)));
        c.damage(damage, this);
        return("Attack dealt "+ damage + " damage to " + c.getName());
    }
    
/** Makes the creature use a spell.
 * @param c An opposing creature.
 * @param s The spell it will do.
 * @return A String representing the depending spell sequence that occurs if the spell is beneficial or not.
 */
    
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