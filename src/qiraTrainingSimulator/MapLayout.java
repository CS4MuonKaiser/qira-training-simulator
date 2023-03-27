package qiraTrainingSimulator;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class MapLayout extends JFrame implements ActionListener, KeyListener{   
    private ArrayList<JLabel> roomsList;
    private JButton back;
    private int current;
    
    public MapLayout(){
        super("Qira's Training Simulator");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        JPanel center = new JPanel();
        JPanel west = new JPanel();
        
        back = new JButton("Back");
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,15));
        back.addActionListener(this);
        
        west.add(Box.createRigidArea(new Dimension(320, 280)));
        west.add(back);
        
        center.setBorder(new EmptyBorder(125, -420, 0, 0));
        
        JPanel rooms = new JPanel();
        rooms.setLayout(new GridLayout(3, 3, 25, 25));
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        roomsList = new ArrayList();
        for(int i=0; i<9; i++){
            JLabel room = new JLabel(" ");
            room.setPreferredSize(new Dimension(125, 125));
            room.setBorder(blackline);
            room.setHorizontalAlignment(JLabel.CENTER);
            roomsList.add(room);
            rooms.add(room);
        }
        
        center.add(rooms);     
        this.add(center, BorderLayout.CENTER);
        this.add(west, BorderLayout.WEST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new TitleLayout();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        current = roomsList.indexOf((JLabel) e.getSource());
        roomsList.get(current).setText("YOU ARE HERE");
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}