package Resturant;
import Resturant.Items.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Management {
    String tableNo;
    private Menue myMenue = new Menue();

    public void placeOrder(String fName, int n,String x) {
        myMenue.buy(fName, n,x);
    }
    public void checkMenue(){
        myMenue.seeFoods();
    }
    public Menue getMenue(){
        return myMenue;
    }
    public void removeFromMenue(String name){
        myMenue.deleteFood(name);
    }
    public void addNewFood(String name, int quantity, double price){
        myMenue.addFood(name, quantity, price);
    }
    public void launchGui(String x){       
        JFrame frame = new JFrame();
        tableNo =x;
        frame=new JFrame();   

        Font font = new Font("Helvetica", Font.BOLD, 20);
        
        
        String column[]={"Food Name","Price"};         
        JTable jt=new JTable(myMenue.getData(),column);    
        jt.setBounds(100,40,1000,600);
        jt.setBackground(new Color(238,238,238,255));
        jt.setShowGrid(false);         
        jt.setShowHorizontalLines(true);
        jt.setFont(font);
        jt.setRowHeight(30);
        frame.setFont(font);


        // JScrollPane sp = new JScrollPane(jt);  
        // sp.setLayout(null);
        // sp.setBounds(0,0,1200,800); 
; 
        
        JPanel myPanel = new JPanel();

        myPanel.setBounds(0, 0, 1200, 800);
        myPanel.setLayout(null);
        //myPanel.add(sp);


        JTextField foodName = new JTextField();
        JTextField foodAmmount = new JTextField();
        
        JScrollPane sp = new JScrollPane();
        sp.setBounds(80,50,1000,400);
        sp.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
        sp.setViewportView(jt);
        
        
        foodName.setBounds(500, 600, 200, 32);
        foodAmmount.setBounds(500, 650, 200, 32);

        JLabel foodNameLabel =new JLabel("Food Name: ");
        JLabel quantLabel = new JLabel("Quantity: ");

        foodNameLabel.setBounds(350,600,200,32);
        quantLabel.setBounds(350,650,200,32);
        
        // myPanel.add(foodName, BorderLayout.CENTER);
        // myPanel.add(foodAmmount, BorderLayout.CENTER);
        
        JButton button = new JButton("Order");
        button.setBounds(565, 700, 70, 40);
        button.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                String name = foodName.getText();
                String amount = foodAmmount.getText();
                int amount1 = Integer.parseInt(amount);
                placeOrder(name, amount1,tableNo);
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Enter a Number");
                }
            }
        });
        myPanel.add(foodName);
        myPanel.add(foodAmmount);
        myPanel.add(sp);
        myPanel.add(button);
        myPanel.add(quantLabel);
        myPanel.add(foodNameLabel);
        //sp.add(button, BorderLayout.CENTER);

        //sp.add(foodName);
        //sp.add(foodAmmount);
        //sp.add(button);
        //sp.add(myPanel);
        myPanel.add(sp);
        frame.add(myPanel);         
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(1200,800);    
        frame.setLayout(null);
        frame.setVisible(true); 
    }

}
