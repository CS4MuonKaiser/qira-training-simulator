package qiraTrainingSimulator.Layout;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import qiraTrainingSimulator.*;

public class BattleLayout extends JFrame implements ActionListener, MouseListener{
    private JLabel map, enemyName, enemyHP, enemyIcon, playerName, playerHP, playerMana;
    private JButton attack, spells, items, stall, bash, crit, dodge, heal, shield, fireball, sword, healthPotion;
    private JPanel centerPanel,mapPanel, enemyPanel, playerPanel, abilityPanel, spellsPanel, spellsContainer, itemsPanel, itemsContainer, enemyIPanel, playerIPanel, fillerPanel1, fillerPanel2, fillerPanel3, fillerPanel4, infoLog;
    private Player character;
    private Creature monster;
    private CardLayout spellsCard, itemsCard;
    private ArrayList<JLabel> console = new ArrayList<JLabel>();
    
    public BattleLayout(Creature c, Player p){
        super("Battle!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10,10));
        this.character = p;
        this.monster = c;
        
        centerPanel = new JPanel();
        fillerPanel1 = new JPanel();
        fillerPanel2 = new JPanel();
        fillerPanel3 = new JPanel();
        fillerPanel4 = new JPanel();
        
        centerPanel.setLayout(new GridLayout(2,2,40,40));
        
        ImageIcon img;
        map = new JLabel("Map");
        
        enemyName = new JLabel(monster.getName());
        enemyHP = new JLabel("HP:" + monster.getHP() + "/" + monster.getMaxHP());
        enemyIcon = new JLabel();
        
        playerName = new JLabel("You");
        playerHP = new JLabel("HP:" + character.getHP() + "/" + character.getMaxHP());
        playerMana = new JLabel("HP:" + character.getMana() + "/100");
        
        attack = new JButton("Attack");
        attack.addActionListener(this);
        spells = new JButton("Spells");
        spells.addActionListener(this);
        items = new JButton("Items");
        items.addActionListener(this);
        stall = new JButton("Stall");
        stall.addActionListener(this);
        
        bash = new JButton("Bash");
        bash.addActionListener(this);
        crit = new JButton("Crit");
        crit.addActionListener(this);
        dodge = new JButton("Dodge");
        dodge.addActionListener(this);
        heal = new JButton("Heal");
        heal.addActionListener(this);
        
        shield = new JButton("Shield");
        shield.addActionListener(this);
        fireball = new JButton("Crit");
        fireball.addActionListener(this);
        sword = new JButton("Dodge");
        sword.addActionListener(this);
        healthPotion = new JButton("Health Potion");
        healthPotion.addActionListener(this);
        
        map.setHorizontalTextPosition(JLabel.CENTER);
        map.setVerticalTextPosition(JLabel.BOTTOM);
        
        mapPanel = new JPanel();
        mapPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        img = new ImageIcon(BattleLayout.class.getResource("Map.jpg"));
        map.setIcon(img);
        map.addMouseListener(this);
        mapPanel.add(map);
        
        enemyPanel = new JPanel();
        enemyIPanel = new JPanel();
        enemyPanel.setLayout(new GridLayout(1,2,10,10));
        enemyIPanel.setLayout(new BoxLayout(enemyIPanel, BoxLayout.Y_AXIS));
        enemyIPanel.add(enemyName);
        enemyIPanel.add(enemyHP);
        img = new ImageIcon(BattleLayout.class.getResource("TRex.jpg"));
        enemyIcon.setIcon(img);
        enemyPanel.add(enemyIPanel);
        enemyPanel.add(enemyIcon);
        
        infoLog = new JPanel();
        playerPanel = new JPanel();
        playerIPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2,10,10));
        playerIPanel.setLayout(new BoxLayout(playerIPanel, BoxLayout.Y_AXIS));
        playerIPanel.add(playerName);
        playerIPanel.add(playerHP);
        playerIPanel.add(playerMana);
        playerPanel.add(infoLog);
        playerPanel.add(playerIPanel);
        
        abilityPanel = new JPanel();
        abilityPanel.setLayout(new GridLayout(2,2,10,10));
        abilityPanel.add(attack);
        abilityPanel.add(spells);
        abilityPanel.add(items);
        abilityPanel.add(stall);
        
        spellsPanel = new JPanel();
        spellsPanel.setLayout(new GridLayout(2,2,10,10));
        spellsPanel.add(bash);
        spellsPanel.add(crit);
        spellsPanel.add(dodge);
        spellsPanel.add(heal);
        
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2,2,10,10));
        itemsPanel.add(shield);
        itemsPanel.add(fireball);
        itemsPanel.add(sword);
        itemsPanel.add(healthPotion);
        
        spellsContainer = new JPanel();
        spellsCard = new CardLayout();
        spellsContainer.setLayout(spellsCard);
        spellsContainer.add("a", abilityPanel);
        spellsContainer.add("b", spellsPanel);
        
        itemsContainer = new JPanel();
        itemsCard = new CardLayout();
        itemsContainer.setLayout(itemsCard);
        itemsContainer.add("a", abilityPanel);
        itemsContainer.add("b", itemsPanel);
        
        centerPanel.add(map);
        centerPanel.add(enemyPanel);
        centerPanel.add(playerPanel);
        centerPanel.add(spellsContainer);
        centerPanel.add(itemsContainer);
        
        this.add(centerPanel, "Center");
        this.add(fillerPanel1, "North");
        this.add(fillerPanel2, "East");
        this.add(fillerPanel3, "West");
        this.add(fillerPanel4, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack){
            String temp = character.attack(monster);
            JLabel consoleLog = new JLabel(temp);
            enemyHP.setText("HP:" + monster.getHP() + "/" + monster.getMaxHP());
            if(monster.getHP()<=0){
                character.statBump(2, false);
                this.dispose();
                new MapLayout(character);
            }
            console.add(consoleLog);
            this.infoLog.add(consoleLog);
            this.infoLog.add(consoleLog);
            temp = monster.turn(character);
            consoleLog.setText(temp);
            this.infoLog.add(consoleLog);
            playerHP.setText("HP:" + character.getHP() + "/" + character.getMaxHP());
            if(character.getHP()<=0){
                this.dispose();
                new MapLayout(character);
            }
        }
        if (e.getSource() == items) {
            itemsCard.next(itemsContainer);
        }
        if (e.getSource() == shield) {
            
        }
        if (e.getSource() == fireball) {
            
        }
        if (e.getSource() == sword) {
            
        }
        if (e.getSource() == healthPotion) {
            
        }
        if (e.getSource() == spells) {
            spellsCard.next(spellsContainer);
        }
        if (e.getSource() == bash) {
            
        }
        if (e.getSource() == crit) {
            
        }
        if (e.getSource() == dodge) {
            
        }
        if (e.getSource() == heal) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == map) {
            this.dispose();
            new MapLayout(character);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}