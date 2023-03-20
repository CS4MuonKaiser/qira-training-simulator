package qiraTrainingSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class SpellsLayout extends JFrame implements ActionListener{    
    private JLabel title, spell;
    private JButton exit;
    
    public SpellsLayout(){
        super("Spells Compendium");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 100));
        
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        
        title = new JLabel("SPELLS COMPENDIUM");
        exit = new JButton("EXIT");
        
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        
        title.setFont(new Font("Monospaced",Font.BOLD,70));
        title.setBorder(new EmptyBorder(175, 0, 70, 0));
        
        exit.setHorizontalTextPosition(JButton.LEFT);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFont(new Font("Monospaced",Font.PLAIN,15));
        exit.addActionListener(this);
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        listPane.add(exit);
        center.add(listPane);        
        this.add(center, BorderLayout.CENTER);     
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            this.dispose();
            new TitleLayout();
        }
    }
}
