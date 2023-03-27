package qiraTrainingSimulator;

import java.awt.*;
import javax.swing.*;

public class BattleLayout extends JFrame{
    private JLabel map, enemyName, enemyHP, enemyIcon, playerName, playerHP, playerMana, playerIcon;
    private JButton attack, spells, items, stall;
    private JPanel centerPanel,mapPanel, enemyPanel, playerPanel, abilityPanel, enemyIPanel, playerIPanel, fillerPanel1, fillerPanel2, fillerPanel3, fillerPanel4;
    
    public BattleLayout(){
        super("Battle!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.centerPanel = new JPanel();
        this.fillerPanel1 = new JPanel();
        this.fillerPanel2 = new JPanel();
        this.fillerPanel3 = new JPanel();
        this.fillerPanel4 = new JPanel();
        this.setLayout(new BorderLayout(10,10));
        centerPanel.setLayout(new GridLayout(2,2,40,40));
        ImageIcon img;
        map = new JLabel("Map");
        enemyName = new JLabel("T-Rex");
        enemyHP = new JLabel("HP: 100/100");
        enemyIcon = new JLabel();
        playerName = new JLabel("You");
        playerHP = new JLabel("50/50");
        playerMana = new JLabel("100/100");
        playerIcon = new JLabel();
        attack = new JButton("Attack");
        spells = new JButton("Spells");
        items = new JButton("Items");
        stall = new JButton("stall");
        this.map.setHorizontalTextPosition(JLabel.CENTER);
        this.map.setVerticalTextPosition(JLabel.BOTTOM);
        mapPanel = new JPanel();
        mapPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        img = new ImageIcon(BattleLayout.class.getResource("Map.jpg"));
        map.setIcon(img);
        mapPanel.add(map);
        this.enemyPanel = new JPanel();
        this.enemyIPanel = new JPanel();
        enemyPanel.setLayout(new GridLayout(1,2,10,10));
        enemyIPanel.setLayout(new BoxLayout(enemyIPanel, BoxLayout.Y_AXIS));
        enemyIPanel.add(enemyName);
        enemyIPanel.add(enemyHP);
        img = new ImageIcon(BattleLayout.class.getResource("TRex.jpg"));
        enemyIcon.setIcon(img);
        enemyPanel.add(enemyIPanel);
        enemyPanel.add(enemyIcon);
        this.playerPanel = new JPanel();
        this.playerIPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2,10,10));
        playerIPanel.setLayout(new BoxLayout(playerIPanel, BoxLayout.Y_AXIS));
        playerIPanel.add(playerName);
        playerIPanel.add(playerHP);
        playerIPanel.add(playerMana);
        img = new ImageIcon(BattleLayout.class.getResource("man.png"));
        playerIcon.setIcon(img);
        playerPanel.add(playerIcon);
        playerPanel.add(playerIPanel);
        this.abilityPanel = new JPanel();
        abilityPanel.setLayout(new GridLayout(2,2,10,10));
        abilityPanel.add(attack);
        abilityPanel.add(spells);
        abilityPanel.add(items);
        abilityPanel.add(stall);
        centerPanel.add(map);
        centerPanel.add(enemyPanel);
        centerPanel.add(playerPanel);
        centerPanel.add(abilityPanel);
        this.add(centerPanel, "Center");
        this.add(fillerPanel1, "North");
        this.add(fillerPanel2, "East");
        this.add(fillerPanel3, "West");
        this.add(fillerPanel4, "South");
    }
}