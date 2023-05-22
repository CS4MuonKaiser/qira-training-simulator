package qiraTrainingSimulator.Layout;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import qiraTrainingSimulator.*;

public class BattleLayout extends JFrame implements ActionListener, MouseListener{
    private JLabel map, enemyName, enemyHP, enemyIcon, playerName, playerHP, playerMana;
    private JButton attack, spells, items, stall, bash, crit, dodge, heal;
    private JPanel centerPanel,mapPanel, enemyPanel, playerPanel, abilityPanel, spellsPanel, spellsContainer, enemyIPanel, playerIPanel, fillerPanel1, fillerPanel2, fillerPanel3, fillerPanel4, infoLog;
    private Player character;
    private Creature monster;
    private CardLayout card;
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
        
        spellsContainer = new JPanel();
        card = new CardLayout();
        spellsContainer.setLayout(card);
        spellsContainer.add("a", abilityPanel);
        spellsContainer.add("b", spellsPanel);
        
        centerPanel.add(map);
        centerPanel.add(enemyPanel);
        centerPanel.add(playerPanel);
        centerPanel.add(spellsContainer);
        
        this.add(centerPanel, "Center");
        this.add(fillerPanel1, "North");
        this.add(fillerPanel2, "East");
        this.add(fillerPanel3, "West");
        this.add(fillerPanel4, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == items) {
            this.dispose();
        }
        if (e.getSource() == spells) {
            card.next(spellsContainer);
        }
        if (e.getSource() == attack){
            String temp = character.attack(monster);
            JLabel consoleLog = new JLabel(temp);
            enemyHP.setText("HP:" + monster.getHP() + "/" + monster.getMaxHP());
            if(monster.getHP()<=0){
                character.statBump(2, false);
                this.dispose();
                new MapLayout();
            }
            console.add(consoleLog);
            this.infoLog.add(consoleLog);
            monster.turn(character);
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
