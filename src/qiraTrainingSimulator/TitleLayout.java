package qiraTrainingSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TitleLayout extends JFrame implements ActionListener{    
    private JLabel title, blank;
    private JButton newGame, continueGame, spellsCompendium, exit;
    
    public TitleLayout(){
        super("Qira's Training Simulator");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 100));
        
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        
        title = new JLabel("QIRA'S TRAINING SIMULATOR");
        newGame = new JButton("NEW GAME");
        continueGame = new JButton("CONTINUE");
        spellsCompendium = new JButton("SPELLS COMPENDIUM");
        exit = new JButton("EXIT");
        
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        
        title.setFont(new Font("Monospaced",Font.BOLD,70));
        title.setBorder(new EmptyBorder(175, 0, 70, 0));
        
        newGame.setHorizontalTextPosition(JButton.LEFT);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        newGame.setFont(new Font("Monospaced",Font.PLAIN,15));
        newGame.addActionListener(this);
        
        continueGame.setHorizontalTextPosition(JButton.LEFT);
        continueGame.setContentAreaFilled(false);
        continueGame.setBorderPainted(false);
        continueGame.setFont(new Font("Monospaced",Font.PLAIN,15));
        continueGame.addActionListener(this);
        
        spellsCompendium.setHorizontalTextPosition(JButton.LEFT);
        spellsCompendium.setContentAreaFilled(false);
        spellsCompendium.setBorderPainted(false);
        spellsCompendium.setFont(new Font("Monospaced",Font.PLAIN,15));
        spellsCompendium.addActionListener(this);
        
        exit.setHorizontalTextPosition(JButton.LEFT);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFont(new Font("Monospaced",Font.PLAIN,15));
        exit.addActionListener(this);
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        listPane.add(newGame);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(continueGame);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(spellsCompendium);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(exit);
        center.add(listPane);        
        this.add(center, BorderLayout.CENTER);     
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame || e.getSource() == continueGame) {
            this.dispose();
            new MapLayout();
        }
        if (e.getSource() == spellsCompendium) {
            this.dispose();
            new SpellsLayout();
        } if (e.getSource() == exit) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION);
            if(choice == 0) {
                System.exit(0);
            }
        }
    }
}
