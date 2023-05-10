
package qiraTrainingSimulator;

import java.util.ArrayList;
import java.util.Scanner;
import qiraTrainingSimulator.Spells.*;

public class QiraTrainingSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean alive = true;
        Creature monster;
        int monsterLevel = 0;
        ArrayList<Creature> monsterList = new ArrayList<>();
        Creature yansur = new Creature(4,2,5,3,38,"Yansur");
        Creature psychomancer = new Creature(4,8,2,4,51,"Psychomancer");
        Creature gale = new Creature(6,5,1,9,87,"Gale");
        Creature genesis = new Creature(15,2,7, 2,141,"Genesis-Revorse");
        Creature judge = new Creature(6,10,7, 10,243,"Oceanic Judge");
        Creature vanguard = new Creature(10,6,18, 7,375,"Solar Vanguard");
        Creature qira = new Creature(13,12,13, 12,540,"Qira, Mistress of the Hive");
        monsterList.add(yansur);
        monsterList.add(psychomancer);
        monsterList.add(gale);
        monsterList.add(genesis);
        monsterList.add(judge);
        monsterList.add(vanguard);
        monsterList.add(qira);
        Player character = new Player(0, 0, 0, 0, 0, 20, "Player", "Warrior");
        Bash bash = new Bash();
        Heal heal = new Heal();
        Crit crit = new Crit();
        Dodge dodge = new Dodge();
        character.addSpell(bash);
        character.addSpell(heal);
        character.addSpell(crit);
        character.addSpell(dodge);
        yansur.addSpell(bash);
        yansur.addSpell(heal);
        yansur.addSpell(crit);
        yansur.addSpell(dodge);
        System.out.println("Creating new: " + character.getName());
        character.statBump(4,false);
        character.maxHP = 20;
        character.currentHP = 20;
        System.out.println("Character Class: " + character.getJob());
        character.getStats();
        Scanner sc = new Scanner(System.in);
        while (true){
            monster = monsterList.get(monsterLevel);
            while(true){
                while(true){
                    System.out.println("======================================");
                    System.out.println("HP: " + character.currentHP + "/" + character.maxHP + " MANA: " + character.mana + "/100");
                    System.out.println("Enemy Name: " + monster.getName() + " || Enemy HP: " + monster.getHP() + "/" + monster.getMaxHP());
                    System.out.println("| ATTACK || SPELLS || ITEMS || STALL |");
                    System.out.println("======================================");
                    String choice = sc.nextLine();
                    System.out.println("======================================");
                    if(choice.equalsIgnoreCase("attack")){
                        character.attack(monster);
                        break;
                    }else if(choice.equalsIgnoreCase("spell") || choice.equalsIgnoreCase("spells")){
                        character.spell(monster);
                        if(character.found && character.cast){
                            break;
                        }
                    }else if(choice.equalsIgnoreCase("stall")){
                        System.out.println("You didn't do anything!");
                        break;
                    }else if(choice.equalsIgnoreCase("item") || choice.equalsIgnoreCase("items")){
                        System.out.println("Hi this system doesn't exist yet");
                        break;
                    }
                }
                if(character.getHP() <= 0){
                    System.out.println("You were slain by " + monster.name + " with " + monster.overkill + " points of overkill!");
                    alive = false;
                    break;
                }else if(monster.getHP() <= 0){
                    System.out.println("You have slain " + monster.name + " with "+ character.overkill + " points of overkill!");
                    break;
                }
                monster.turn(character);
                if(character.getHP() <= 0){
                    System.out.println("You were slain by " + monster.name + " with " + monster.overkill + " points of overkill!");
                    alive = false;
                    break;
                }else if(monster.getHP() <= 0){
                    System.out.println("You have slain " + monster.name + " with "+ character.overkill + " points of overkill!");
                    break;
                }
            }
            if(monsterList.size() == monsterLevel+1 || !alive){
                break;
            }else{
                monsterLevel++;
                character.statBump((int)(monsterLevel*1.25) + 2, true);
            }
        }
        if(alive){
            System.out.println("Congratulations! You have successfully defeated the dungeon! Final Stats: ");
            character.getStats();
            System.out.println("Overkill Damage: " + character.getOverkill());
        }else{
            System.out.println("You died against " + monster.getName() + "! You survived " + (monsterLevel+1) + " waves of enemies... Final Stats: ");
            character.getStats();
            System.out.println("Overkill Damage: " + character.getOverkill());
        }
    }
    
}