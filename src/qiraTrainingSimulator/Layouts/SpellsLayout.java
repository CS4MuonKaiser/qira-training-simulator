package qiraTrainingSimulator.Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class SpellsLayout extends JFrame implements ActionListener{ 
    private ArrayList<JLabel> spellsList;
    private JLabel title, spell;
    private JButton back;
    
    public SpellsLayout(){
        super("Spells Compendium");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 100));
        
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel west = new JPanel();
        
        title = new JLabel("SPELLS COMPENDIUM");
        back = new JButton("EXIT");
        
        JPanel spells = new JPanel();
        spells.setLayout(new GridLayout(3, 5, 20, 20));
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        spellsList = new ArrayList();
        for(int i=0; i<25; i++){
            spell = new JLabel(" ");
            spell.setPreferredSize(new Dimension(75, 75));
            spell.setBorder(blackline);
            spell.setHorizontalAlignment(JLabel.CENTER);
            spellsList.add(spell);
            spells.add(spell);
        }
        
        title.setFont(new Font("Monospaced",Font.BOLD,70));
        
        back = new JButton("Back");
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,15));
        back.addActionListener(this);
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        center.add(spells);
        this.add(center, BorderLayout.CENTER);  
        
        west.add(back);
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
