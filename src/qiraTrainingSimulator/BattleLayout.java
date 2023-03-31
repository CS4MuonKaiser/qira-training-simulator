package qiraTrainingSimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleLayout extends JFrame implements ActionListener, MouseListener{
    private JLabel map, enemyName, enemyHP, enemyIcon, playerName, playerHP, playerMana, playerIcon;
    private JButton attack, spells, items, stall;
    private JPanel centerPanel,mapPanel, enemyPanel, playerPanel, abilityPanel, enemyIPanel, playerIPanel, fillerPanel1, fillerPanel2, fillerPanel3, fillerPanel4;
    
    public BattleLayout(){
        super("Battle!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10,10));
        
        centerPanel = new JPanel();
        fillerPanel1 = new JPanel();
        fillerPanel2 = new JPanel();
        fillerPanel3 = new JPanel();
        fillerPanel4 = new JPanel();
        
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
        attack.addActionListener(this);
        spells = new JButton("Spells");
        spells.addActionListener(this);
        items = new JButton("Items");
        items.addActionListener(this);
        stall = new JButton("stall");
        stall.addActionListener(this);
        
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
        
        playerPanel = new JPanel();
        playerIPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2,10,10));
        playerIPanel.setLayout(new BoxLayout(playerIPanel, BoxLayout.Y_AXIS));
        playerIPanel.add(playerName);
        playerIPanel.add(playerHP);
        playerIPanel.add(playerMana);
        img = new ImageIcon(BattleLayout.class.getResource("man.png"));
        playerIcon.setIcon(img);
        playerPanel.add(playerIcon);
        playerPanel.add(playerIPanel);
        
        abilityPanel = new JPanel();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spells) {
            this.dispose();
            new SpellsLayout();
        } if (e.getSource() == items) {
            this.dispose();
            new ItemsLayout();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == map) {
            this.dispose();
            new MapLayout();
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