package qiraTrainingSimulator.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TitleLayout extends JFrame implements ActionListener{    
    private JLabel title, blank;
    private JButton newGame, inventory, exit;
    
    public TitleLayout(){
        super("Qira's Training Simulator");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 100));
        
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        
        title = new JLabel("QIRA'S TRAINING SIMULATOR");
        newGame = new JButton("NEW GAME");
        inventory = new JButton("PLAYER INVENTORY");
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
        
        inventory.setHorizontalTextPosition(JButton.LEFT);
        inventory.setContentAreaFilled(false);
        inventory.setBorderPainted(false);
        inventory.setFont(new Font("Monospaced",Font.PLAIN,15));
        inventory.addActionListener(this);
        
        exit.setHorizontalTextPosition(JButton.LEFT);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFont(new Font("Monospaced",Font.PLAIN,15));
        exit.addActionListener(this);
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        listPane.add(newGame);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(inventory);
        listPane.add(Box.createRigidArea(new Dimension(0, -14)));
        listPane.add(exit);
        center.add(listPane);        
        this.add(center, BorderLayout.CENTER);     
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            this.dispose();
            new MapLayout();
        } if (e.getSource() == inventory) {
            this.dispose();
            new InventoryLayout();
        } if (e.getSource() == exit) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION);
            if(choice == 0) {
                System.exit(0);
            }
        }
    }
}
