import javax.swing.JFrame;
import javax.swing.UIDefaults.LazyValue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CustomerPage extends JFrame implements ActionListener{
    private JPanel panel ;
    private JLabel label ;
    private JButton back_button ;
    private HomePage homepage ;
    private JLabel BackgroundImage ;
    public static String TABLE;
    JButton jButton;
    JComboBox<String> jComboBox;
    
        public CustomerPage(){
            super("Customer");
        String[] optionsToChoose = {"Table 1", "Table 2", "Table 3", "Table 5", "Table 5", "Table 6","Table 7","Table 8","Table 9","Table 10"};


        jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(420, 300, 300, 50);

        jButton = new JButton("Select");
        jButton.setBounds(500, 380, 150, 50);


        this.add(jButton);
        this.add(jComboBox);
        jButton.addActionListener(this);
    
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jButton){
                TABLE = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                this.setVisible(false);
                new Shop(TABLE);

            }
        }
    }

