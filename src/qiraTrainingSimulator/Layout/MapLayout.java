package qiraTrainingSimulator.Layout;

import qiraTrainingSimulator.Encounters.Coin;
import qiraTrainingSimulator.Encounters.ImmovableObject;
import qiraTrainingSimulator.Encounters.Enemy;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class MapLayout extends JFrame implements ActionListener, KeyListener{   
    private ArrayList<JLabel> roomsList;
    private JButton back, battle;
    private JLabel room;
    private JPanel center, west, east, rooms;
    private Player p;
    private int current, next, encounter0, encounter1, encounter2, encounter3, encounter4, encounter5, encounter6, encounter7, encounter8;
    
    public MapLayout(){
        super("Qira's Training Simulator");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
        
        center = new JPanel();
        west = new JPanel();
        east = new JPanel();
        
        back = new JButton("Back");
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Monospaced",Font.ITALIC,15));
        back.addActionListener(this);
        
        battle = new JButton("       ");
        battle.setContentAreaFilled(false);
        battle.setBorderPainted(false);
        battle.setFont(new Font("Monospaced",Font.BOLD,20));
        battle.addActionListener(this);
        
        west.add(Box.createRigidArea(new Dimension(320, 280)));
        west.add(back);
        
        center.setBorder(new EmptyBorder(125, -420, 0, -430));
        
        east.add(battle);
        east.add(Box.createRigidArea(new Dimension(300, 280)));
        
        rooms = new JPanel();
        rooms.setLayout(new GridLayout(3, 3, 25, 25));
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        roomsList = new ArrayList();
        
        for(int i=0; i<9; i++){
            room = new JLabel(" ");
            room.setPreferredSize(new Dimension(125, 125));
            room.setBorder(blackline);
            room.setHorizontalAlignment(JLabel.CENTER);
            roomsList.add(room);
            rooms.add(room);
        }
        
        current = 4;
        roomsList.get(current).setText("You are here.");
        
        setEncounter();
        
        center.add(rooms);     
        
        this.add(center, BorderLayout.CENTER);
        this.add(west, BorderLayout.WEST);
        this.add(east, BorderLayout.EAST);
        this.addKeyListener(this);
        this.setVisible(true);
    }
    
    private void setEncounter(){
        ImmovableObject object1 = new ImmovableObject(0);
        Enemy enemy1 = new Enemy(2);
        Enemy enemy2 = new Enemy(3);
        Enemy enemy3 = new Enemy(5);
        Enemy enemy4 = new Enemy(8);
        Coin coin1 = new Coin(1);
        Coin coin2 = new Coin(6);
        
        encounter0 = object1.getRoom();
        encounter1 = coin1.getRoom();
        encounter2 = enemy1.getRoom();
        encounter3 = enemy2.getRoom();
        encounter4 = 4;
        encounter5 = enemy3.getRoom();
        encounter6 = coin2.getRoom();
        encounter7 = 7;
        encounter8 = enemy4.getRoom();
    }
    
    private void determineEncounter(){
        battle.setText("       ");
        
        if (next == encounter4 || next == encounter7) {
            current = next;
            roomsList.get(current).setText("You are here.");
        } else if (next == encounter0) {
            roomsList.get(current).setText("Immovable object present.");
        } else if (next == encounter1 || next == encounter6) {
            current = next;
            roomsList.get(current).setText("Coin collected!");
        } else if (next == encounter2 || next == encounter3 || next == encounter5 || next == encounter8) {
            current = next;
            roomsList.get(next).setText("Monster present!");
            battle.setText("Battle!");
        } 
    }
    
    private void moveLeft() {
        roomsList.get(current).setText(" ");
        if (current == 0 || current == 3 || current == 6) {
            roomsList.get(current).setText("Action invalid.");
        } else {
            next = current - 1;
            determineEncounter();
        }
    }
    
    private void moveRight() {
        roomsList.get(current).setText(" ");
        if (current == 2 || current == 5 || current == 8) {
            roomsList.get(current).setText("Action invalid.");
        } else {
            next = current + 1;
            determineEncounter();
        }
    }
    
    private void moveUp() {
        roomsList.get(current).setText(" ");
        if (current == 0 || current == 1 || current == 2) {
            roomsList.get(current).setText("Action invalid.");
        } else {
            next = current - 3;
            determineEncounter();
        }
    }
    
    private void moveDown() {
        roomsList.get(current).setText(" ");
        if (current == 6 || current == 7 || current == 8) {
            roomsList.get(current).setText("Action invalid.");
        } else {
            next = current + 3;
            determineEncounter();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new TitleLayout();
        } if (e.getSource() == battle) {
            this.dispose();
            Creature yansur = new Creature(4,2,5,3,38,"Yansur");
            new BattleLayout(yansur, p);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> moveRight();
            case KeyEvent.VK_LEFT -> moveLeft();
            case KeyEvent.VK_UP -> moveUp();
            case KeyEvent.VK_DOWN -> moveDown();
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
