/*
 * Main File!
 */

import java.util.ArrayList;
import java.util.Scanner;

public class QiraTrainingSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean alive = true;
        Creature monster;
        int monsterLevel = 0;
        /*
         *Creature Declaration! Probably gonna get so much more complex later on!
         */
        ArrayList<Creature> monsterList = new ArrayList<>();
        Creature yansur = new Creature(2,0,3,1,25,"Yansur");
        Creature psychomancer = new Creature(1,6,1,2,35,"Psychomancer");
        Creature gale = new Creature(3,2,0,7,45,"Gale");
        Creature genesis = new Creature(12,0,3, 0,55,"Genesis-Revorse");
        Creature judge = new Creature(2,6,3, 6,65,"Oceanic Judge");
        Creature vanguard = new Creature(2,1,10, 4,75,"Solar Vanguard");
        Creature qira = new Creature(11,6,10, 7,85,"Qira, Mistress of the Hive");
        monsterList.add(yansur);
        monsterList.add(psychomancer);
        monsterList.add(gale);
        monsterList.add(genesis);
        monsterList.add(judge);
        monsterList.add(vanguard);
        monsterList.add(qira);
        /*
         * Player creation. Might include classes later on for different ways of obtaining spells.
         */
        Player character = new Player(0, 0, 0, 0, 0, 20, "Player", "Warrior");
        System.out.println("Creating new: " + character.getName());
        character.statBump(4);
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
                    System.out.println("ATTACK || SPELLS || ITEMS || STALL");
                    System.out.println("======================================");
                    System.out.print("Action: ");
                    String choice = sc.nextLine();
                    System.out.println("======================================");
                    if(choice.equalsIgnoreCase("attack")){
                        character.attack(monster);
                        break;
                    }else if(choice.equalsIgnoreCase("spell") || choice.equalsIgnoreCase("spells")){
                        character.spell(monster);
                        if(character.found){
                            break;
                        }
                    }else if(choice.equalsIgnoreCase("stall")){
                        System.out.println("You didn't do anything!");
                        break;
                    }else if(choice.equalsIgnoreCase("item") || choice.equalsIgnoreCase("items")){
                        System.out.println("placeholder");
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
                monster.attack(character);
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
                character.statBump((int)(monsterLevel*1.25) + 2);
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
