package qiraTrainingSimulator.Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class InventoryLayout extends JFrame implements ActionListener{ 
    private ArrayList<JLabel> itemsList;
    private JLabel title, item;
    private JButton back;
    
    public InventoryLayout(){
        super("PLAYER INVENTORY");
           
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 100));
        
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel west = new JPanel();
        
        title = new JLabel("PLAYER INVENTORY");
        back = new JButton("EXIT");
        
        JPanel items = new JPanel();
        items.setLayout(new GridLayout(3, 5, 20, 20));
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        itemsList = new ArrayList();
        for(int i=0; i<25; i++){
            item = new JLabel(" ");
            item.setPreferredSize(new Dimension(75, 75));
            item.setBorder(blackline);
            item.setHorizontalAlignment(JLabel.CENTER);
            itemsList.add(item);
            items.add(item);
        }
        
        title.setFont(new Font("Monospaced",Font.BOLD,70));
        
        back = new JButton("Back");
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,15));
        back.addActionListener(this);
        
        north.add(title);
        this.add(north, BorderLayout.NORTH);
        
        center.add(items);
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
