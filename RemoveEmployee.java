// package Employee;
import java.io.*;

import javax.swing.JOptionPane;
public class RemoveEmployee extends javax.swing.JFrame {
    
    String [][]TotInfo = new String[getNoOfEmployeee()][8];                  
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
   
    public RemoveEmployee() {
        initComponents();
    }

     // this will initialize the array of the employee information
     public void init() {
        int size= getNoOfEmployeee();
        /*employye.txt format 
        * username;password;name;designation;email;phone;salary;address
        */
        try{
            BufferedReader br = new BufferedReader(new FileReader(".//Data//Employee.txt"));
            String []info;
            String line[] = new String[size];

            for(int i=0;i<size;i++){
                line[i] = br.readLine();
                info = line[i].split(";");
                TotInfo[i] = info;
            }
            br.close();                
        }catch(Exception e){
            //System.out.println(e);
        }
    }


    // it will retrive the number of total employee
    public int getNoOfEmployeee(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(".//Data//Employee.txt"));
            String line;
            int i = 0;
            line = br.readLine();
            while(line != null){
                line = br.readLine();
                i++;
            }
            return i;
        }catch(Exception e){
            return -1;
        }
    }
                   
    private void initComponents() {
        setResizable(false);

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jTextField1.setBorder(new javax.swing.border.MatteBorder(null));

        jButton1.setText("Remove");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Employee ID or Uusername: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        arraySetNullByID(jTextField1.getText());
        wrtOnFile();       
    }
    
    
    public void arraySetNullByID(String ID){
        //boolean matched = false;
        init();
        for (int j = 0; j < TotInfo.length; j++) {
            if (TotInfo[j][0].equals(ID)) {
                //matched =true;
                TotInfo[j] = null;
                
                JOptionPane.showMessageDialog(null, "User Deleted");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No such user exist");
        
    }
    public void wrtOnFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(".//Data//Employee.txt"));
            for (int j = 0; j < TotInfo.length; j++) {
                if (TotInfo[j] != null) {
                    bw.write(TotInfo[j][0]+";"+TotInfo[j][1]+";"+TotInfo[j][2]+";"+TotInfo[j][3]+";"+TotInfo[j][4]+";"+TotInfo[j][5]+";"+TotInfo[j][6]+";"+TotInfo[j][7]+"\r\n");
                    //bw.newLine();
                }
            }
            bw.close();
        }catch(IOException e){
            
        }
        init();
    }  
                  
}
