package qiraTrainingSimulator;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class MainTitleScreenLayout extends JFrame {    
    private JLabel title;
    private JButton newGame, continueGame, spellsCompendium, settings, exit;
    
    public MainTitleScreenLayout(){
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
        settings = new JButton("SETTINGS");
        exit = new JButton("EXIT");
        
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        
        title.setFont(new Font("Monospaced",Font.BOLD,70));
        title.setBorder(new EmptyBorder(175, 0, 70, 0));
        
        newGame.setHorizontalTextPosition(JButton.LEFT);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        newGame.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        continueGame.setHorizontalTextPosition(JButton.LEFT);
        continueGame.setContentAreaFilled(false);
        continueGame.setBorderPainted(false);
        continueGame.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        spellsCompendium.setHorizontalTextPosition(JButton.LEFT);
        spellsCompendium.setContentAreaFilled(false);
        spellsCompendium.setBorderPainted(false);
        spellsCompendium.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        settings.setHorizontalTextPosition(JButton.LEFT);
        settings.setContentAreaFilled(false);
        settings.setBorderPainted(false);
        settings.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        exit.setHorizontalTextPosition(JButton.LEFT);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFont(new Font("Monospaced",Font.PLAIN,15));
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        listPane.add(newGame);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(continueGame);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(spellsCompendium);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(settings);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(exit);
        center.add(listPane);        
        this.add(center, BorderLayout.CENTER);     
        
        this.setVisible(true);
    }
}
