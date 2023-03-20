package qiraTrainingSimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MapLayout extends JFrame implements ActionListener{    
    private JLabel room1, room2, room3, room4, room5, room6, room7, room8, room9;
    private JButton back;
    
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
                
        room1 = new JLabel(" ");
        room1.setPreferredSize(new Dimension(125, 125));
        room1.setBorder(blackline);
        room1.setHorizontalAlignment(JLabel.CENTER);
        
        room2 = new JLabel(" ");
        room2.setBorder(blackline);     
        room2.setPreferredSize(new Dimension(125, 125));
        room2.setHorizontalAlignment(JLabel.CENTER);
        
        room3 = new JLabel(" ");
        room3.setBorder(blackline);
        room3.setPreferredSize(new Dimension(125, 125));
        room3.setHorizontalAlignment(JLabel.CENTER);
        
        room4 = new JLabel(" ");
        room4.setBorder(blackline);
        room4.setPreferredSize(new Dimension(125, 125));
        room4.setHorizontalAlignment(JLabel.CENTER);
        
        room5 = new JLabel("YOU ARE HERE");
        room5.setBorder(blackline);
        room5.setPreferredSize(new Dimension(125, 125));
        room5.setHorizontalAlignment(JLabel.CENTER);
        room5.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        room6 = new JLabel(" ");
        room6.setBorder(blackline);
        room6.setPreferredSize(new Dimension(125, 125));
        room6.setHorizontalAlignment(JLabel.CENTER);
        
        room7 = new JLabel(" ");
        room7.setBorder(blackline);
        room7.setPreferredSize(new Dimension(125, 125));
        room7.setHorizontalAlignment(JLabel.CENTER);
        
        room8 = new JLabel(" ");
        room8.setBorder(blackline);
        room8.setPreferredSize(new Dimension(125, 125));
        room8.setHorizontalAlignment(JLabel.CENTER);
        
        room9 = new JLabel(" ");
        room9.setBorder(blackline);
        room9.setPreferredSize(new Dimension(125, 125));
        room9.setHorizontalAlignment(JLabel.CENTER);
        
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);
        
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
}
