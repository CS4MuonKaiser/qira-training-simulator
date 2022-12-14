/**
 * Supposedly the main class or smth
 */
import java.util.Scanner;

public class QiraTrainingSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creature yansur = new Creature(1,1,1,1,20,"Yansur");
        Player character = new Player(1, 1, 1, 1, 1, 20, "Player", "Warrior");
        System.out.println("Creating new: " + character.getName());
        character.points = 10;
        character.statBump();
        System.out.println("Character Class: " + character.getJob());
        character.getStats();
        Scanner sc = new Scanner(System.in);
        while (true){
            while(true){
                System.out.println("HP: " + character.currentHP + "/" + character.maxHP + " MANA: " + character.mana + "/100");
                System.out.println("ATTACK || SPELLS || ITEMS || STALL");
                String choice = sc.nextLine();
                if(choice.equalsIgnoreCase("attack")){
                    character.attack(yansur);
                    break;
                }else if(choice.equalsIgnoreCase("spell") || choice.equalsIgnoreCase("spells")){
                    character.spell();
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
        }
    }
    
}
