
import java.util.Scanner;

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
    
    void statBump(int points){
        Scanner sc = new Scanner(System.in);
        while(points>0){
            maxHP = maxHP + (int)(2.5*points);
            System.out.println("Increase Stat (" + points + ") remaining");
            System.out.println("STR " + STR + " || DEX " + DEX + " || INT " + INT + " || DEF " + DEF + " || AGI " + AGI);
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
        this.damage(-(int)(maxHP/1.5), this);
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
        while(i<=3){
            System.out.print("| " + spellList.get(i ) + " |");
            i++;
        }
        String choice = sc.nextLine();
        i = 0;
        while(i<=3){
            if(choice.equals(spellList.get(i).getName())){
                while(true){
                    System.out.println("Targetting... \n + " + name + " \n + " + c.name);
                    String temp = sc.nextLine();
                    if(temp.toUpperCase().equals(name.toUpperCase())){
                        spellList.get(i).cast(this);
                        found = true;
                        break;
                    }else if(temp.toUpperCase().equals(c.name.toUpperCase())){
                        spellList.get(i).cast(c);
                        found = true;
                        break;
                    }else{
                        System.out.println("Creature not found!");
                    }
                }
            }
            if(!found){
                System.out.println("Spell not found!");
            }
        }
    }
}
