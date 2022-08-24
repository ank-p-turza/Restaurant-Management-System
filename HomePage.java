import java.awt.event.*;
import java.awt.*;
//import Customer.CustomerPage;

import javax.print.FlavorException;
import javax.swing.*;
import javax.swing.text.LabelView;
public class HomePage extends JFrame implements ActionListener{
    private JButton button_customer;
    private JButton button_Admin;
    //private CustomerPage customer;
    private EmployeePage employeePage ;
    HomePage(){
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        
        
        ImageIcon bgImage = new ImageIcon(".//Data//Images//bg_image.png");
        label.setIcon(bgImage);
        label.setOpaque(false);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLayout(null);
        label.setBounds(0,0 ,1200, 800);

        button_customer = new JButton("Customer");
        button_Admin = new JButton("Admin");
        button_Admin.addActionListener(this);

        button_customer.setBounds(400,690, 100, 50);
        button_Admin.setBounds(800, 690, 100, 50);
        button_customer.addActionListener(this);
        button_Admin.addActionListener(this);

        this.setTitle("IchiraKu Raman Shop");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setLayout(null);
        this.add(label);
        this.add(label2);
        this.add(button_customer);
        this.add(button_Admin);
        this.setLocationRelativeTo(null);

        //customer = new CustomerPage(this);
        employeePage = new EmployeePage(this);

    }
      public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==button_customer){
                new CustomerPage().setVisible(true);
                this.setVisible(false);
               
            }
            else if(ae.getSource()==button_Admin){
                employeePage.setVisible(true);
                this.setVisible(false);
            }
        }
        public static void main(String[] args) {
            new HomePage();
        } 
}
