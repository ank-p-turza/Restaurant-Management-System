import javax.swing.*;
import javax.swing.JTable;
import javax.swing.text.TabExpander;

import FoodManage.RemoveFood;

import java.util.ArrayList;
import java.io.*;
// import FoodManage.AddFood;
// import FoodManage.RemoveFood;

//import Employee.RemoveEmployee;

import java.awt.event.*;
import java.awt.*;


class EmployeePage extends JFrame implements ActionListener{
    //ArrayList<String> orderInfo = new ArrayList<String>();
    private String imployeeInfo[][];
    private String column[] = {"Usernameame", "Password", "Name", "Designation","Email","Phone No","Salary","Address"};
    private String FoodInfo[][];
    private String FoodColumn[]={"Name","Quantity","Price"};
    private String ordercolumn[]={"Orders","worth","Table"};
    private String orderInfo[][];
    private JLabel label;
    private JLabel labelbgm;
    private JLabel BackgroundImage ;

    private JTable foodtable ;
    private JTable employeeTable ;
    private JTable orderTable;
    
    private JScrollPane ManagefoodPane_food,manageOrderPane ;
    private JScrollPane ManageEmployeePane;

    private JButton login ;
    private JButton Back ;
    private JButton Financial_report ;
    private JButton ManageOrder ;
    private JButton ManageFood , addFood,removeFood;
    private JButton ManageEmployee ;
    private JButton about ;
    private JButton addEmployee , removeEmoployee,empRefresh,foodRefresh,orderRefresh;

    private JPanel ManagerPanel;
    private JPanel manageOrderPanel;
    private JPanel FinancialReport ;
    private JPanel loginPanel;
    private JPanel ManageFoodPanel ;

    private JTextField username;
    private JPasswordField password;
    private HomePage homePage ;
    private boolean check ;
    private EmployeeInfo emp = new EmployeeInfo();

    private String userName ,pass;
    public void initOrder(){
        try{
        ArrayList<String> list = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(".//Data//finances.txt"));

            String temp;
            while ((temp = reader.readLine()) != null){
                //System.out.println(temp);
                list.add(temp);
            }
            reader.close();

            orderInfo = new String[list.size()][3];
            for(int i = 0; i < list.size(); i++){
                String parts[] = list.get(i).split("'s");
                orderInfo[i] = parts;
            }
            

            
            orderTable = new JTable(orderInfo, ordercolumn);
            // tempTable = new JTable(imployeeInfo,column);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void initFood(){
        try{
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(".//Data//menueItems.txt"));

            String temp;
            while ((temp = reader.readLine()) != null){
                //System.out.println(temp);
                list.add(temp);
            }
            reader.close();
            
            FoodInfo = new String[list.size()][3];
            for(int i = 0; i < list.size(); i++){
                String parts[] = list.get(i).split(",");
                FoodInfo[i] = parts;
            }

            
            foodtable = new JTable(FoodInfo, FoodColumn);
            // tempTable = new JTable(imployeeInfo,column);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void initx(){
        try{
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(".//Data//Employee.txt"));

            String temp;
            while ((temp = reader.readLine()) != null){
                //System.out.println(temp);
                list.add(temp);
            }
            reader.close();
            
            imployeeInfo = new String[list.size()][8];
            for(int i = 0; i < list.size(); i++){
                String parts[] = list.get(i).split(";");
                imployeeInfo[i] = parts;
            }

            
            employeeTable = new JTable(imployeeInfo, column);
            // tempTable = new JTable(imployeeInfo,column);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    EmployeePage(HomePage homePage){
        this.homePage = homePage;
        initx();
        initFood();
        initOrder();

        foodtable.setBounds(0,50 , 500,500);

    //employeeTable = new JTable(EmployeeList , Employee_list_header);
    employeeTable.setBounds(0,50 , 500,500);
    orderTable.setBounds(0,50 , 500,500);
    // tempTable.setBounds(0,50 , 500,500);


    // Panes :
    ManagefoodPane_food = new JScrollPane();
    ManagefoodPane_food.setBounds(80,50,1000,400);
    ManagefoodPane_food.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    ManagefoodPane_food.setViewportView(foodtable);
    
    manageOrderPane = new JScrollPane();
    manageOrderPane.setBounds(80,50,1000,400);
    manageOrderPane.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    manageOrderPane.setViewportView(orderTable);

    ManageEmployeePane = new JScrollPane();
    ManageEmployeePane.setBounds(80 ,50,1000,400);
    ManageEmployeePane.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
    ManageEmployeePane.setViewportView(employeeTable);
    
        



// Buutons : 
    empRefresh = new JButton("Refresh");
    empRefresh.setBounds(550, 450, 150,50);
    empRefresh.setVisible(true);
    empRefresh.addActionListener(this);

    orderRefresh = new JButton("Refresh");
    orderRefresh.setBounds(550, 450, 150,50);
    orderRefresh.setVisible(true);
    orderRefresh.addActionListener(this);
    
    foodRefresh = new JButton("Refresh");
    foodRefresh.setBounds(550, 450, 150,50);
    foodRefresh.setVisible(true);
    foodRefresh.addActionListener(this);
    
    addEmployee = new JButton("Add Employee");
    addEmployee.setBounds(750, 450, 150,50);
    addEmployee.setVisible(true);
    addEmployee.addActionListener(this);

    removeEmoployee = new JButton("Remove Employee ");
    removeEmoployee.setBounds(950, 450, 150,50);
    removeEmoployee.setVisible(true);
    removeEmoployee.addActionListener(this);
    

    addFood = new JButton("Add Food");
    addFood.setBounds(850, 450, 100,50);
    addFood.setVisible(true);
    addFood.addActionListener(this);

    removeFood = new JButton("Remove Food ");
    removeFood.setBounds(950, 450, 100,50);
    removeFood.setVisible(true);
    removeFood.addActionListener(this);


    Financial_report = new JButton("Manage Order");
    Financial_report.setBounds(80,0,180,50);
    Financial_report.setVisible(false);
    Financial_report.addActionListener(this);


    ManageFood = new JButton("Manage Food");
    ManageFood.setBounds(440, 0, 180, 50);
    ManageFood.setVisible(false);
    ManageFood.addActionListener(this);
    
    ManageEmployee = new JButton("Manage Employee ");
    ManageEmployee.setBounds(260, 0, 180, 50);
    ManageEmployee.setVisible(false);
    ManageEmployee.addActionListener(this);

    ManageOrder = new JButton("Manage Order");
    ManageOrder.setBounds(80, 0, 180, 50);
    ManageOrder.setVisible(false);
    ManageOrder.addActionListener(this);

    about= new JButton("About");
    about.setBounds(980, 0, 180, 50);
    about.setVisible(false);
    about.addActionListener(this);

/* Button End */
/* Panels for buttons  */
    ManagerPanel = new JPanel();
    manageOrderPanel = new JPanel();
    FinancialReport = new JPanel();
    ManageFoodPanel = new JPanel();

    //Manage Food Panels :
    ManageFoodPanel.setLayout(null);
    ManageFoodPanel.add(ManagefoodPane_food);
    ManageFoodPanel.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    ManageFoodPanel.setBounds(30,50,1150,700);
    ManageFoodPanel.add(foodRefresh);
    ManageFoodPanel.add(addFood);
    ManageFoodPanel.add(removeFood);
    ManageFoodPanel.setVisible(false);

    FinancialReport.setLayout(null);
    FinancialReport.add(manageOrderPane);
    FinancialReport.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    FinancialReport.setBounds(30,50,1150,700);
    FinancialReport.add(manageOrderPane);
    FinancialReport.add(orderRefresh);
    FinancialReport.setVisible(false);
    
    //Receptionist Panel :
    // FinancialReport.setLayout(null);
    // FinancialReport.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    // FinancialReport.setBounds(30,50,1150,700);
    // FinancialReport.setVisible(false);
    //************ End of Receptionist Panels */


    // Manager Panel :
    ManagerPanel.setLayout(null);
    ManagerPanel.setBackground(new Color(1.0f , 1.0f ,1.0f , 0.6f));
    ManagerPanel.setBounds(30,50,1150,7000);
    ManagerPanel.add(empRefresh);
    ManagerPanel.add(addEmployee);
    ManagerPanel.add(ManageEmployeePane);
    ManagerPanel.add(removeEmoployee);
    ManagerPanel.setVisible(false);
    //*********************** End of Manager Buttons */

/* ************* End of Panels of Buttons */

// LOG IN Panel
    login = new JButton("Log In");
    login.setBounds(160, 240,70, 30);
    login.addActionListener(this);;
    Back = new JButton("Back");
    ImageIcon backimg = new ImageIcon(".//Data//Images//rsz_back_button.png");
    Back.setBounds(0,0,50,40);
    Back.addActionListener(this);
    Back.setIcon(backimg);
       

    username = new JTextField("User Name");
    username.setLayout(null);
    username.setBounds(120,180, 150 , 30);
    password = new JPasswordField("Password");
    password.setBounds(120 ,210, 150 , 30);

    label= new JLabel();
    label.setLayout(null);
    label.setText("Enter Your User name And Password");
    label.setBounds(80, 0, 600, 50);

    labelbgm = new JLabel();
    labelbgm.setLayout(null);
    labelbgm.setBounds(140,-140, 500,500);
    ImageIcon img = new ImageIcon(".//Data//Images//login.png");
    labelbgm.setIcon(img);


    loginPanel = new JPanel();
    loginPanel.setLayout(null);
    loginPanel.setBackground(new Color(255,255,255,190));
    loginPanel.setBounds(400, 200, 400, 300);
    loginPanel.add(username);
    loginPanel.add(password);
    loginPanel.add(label);
    loginPanel.add(labelbgm);
    loginPanel.add(login);
    loginPanel.setVisible(true);
//********************************  */
ImageIcon Background_image = new ImageIcon(".//Data//Images//Background_image.jpg");
    BackgroundImage = new JLabel(Background_image);
    BackgroundImage.setLayout(null);
    BackgroundImage.setBounds(0, 0, 1200, 800);
    this.setVisible(false);
    this.setLayout(null);
    this.setSize(1200,800);
    this.add(loginPanel);
    this.add(Back);
    this.add(ManagerPanel);
    this.add(ManageFoodPanel);
    this.add(FinancialReport);
    this.add(Financial_report);
    this.add(ManageFood);
    this.add(ManageOrder);
    this.add(ManageEmployee);
    this.add(about);
    this.add(BackgroundImage);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            homePage.setVisible(true);
            this.setVisible(false);
            loginPanel.setVisible(true);
            Financial_report.setVisible(false);
            ManageFood.setVisible(false);
            ManageOrder.setVisible(false);
            ManageEmployee.setVisible(false);
            about.setVisible(false);
            ManagerPanel.setVisible(false);
            ManageFoodPanel.setVisible(false);
            FinancialReport.setVisible(false);
        }else if(e.getSource()==login ){
            if(emp.authentication(username.getText(),new String(password.getPassword()))){
            if(emp.getDesignation(username.getText()).equals("Manager")){
                loginPanel.setVisible(false);
                Financial_report.setVisible(true);
                ManageFood.setVisible(true);
                //ManageOrder.setVisible(true);
                ManageEmployee.setVisible(true);
                about.setVisible(true);
                about.setBounds(980, 0, 180, 50);
            }else if(emp.getDesignation(username.getText()).equals("Receptionist")){
                loginPanel.setVisible(false);
                Financial_report.setVisible(false);
                ManageFood.setVisible(false);
                ManageOrder.setVisible(true);
                ManageEmployee.setVisible(false);
                about.setVisible(true);
                about.setBounds(980, 0, 180, 50);
            }else if(emp.getDesignation(username.getText()).equals("Waiter")){
                loginPanel.setVisible(false);
                Financial_report.setVisible(false);
                ManageFood.setVisible(false);
                ManageOrder.setVisible(false);
                ManageEmployee.setVisible(false);
                about.setVisible(true); 
                about.setBounds(80,0,180,50);
            }
           
        }else{
            JOptionPane.showMessageDialog(null,"Wrong Credentials");
        }
        }
        else if(e.getSource()==Financial_report){
            FinancialReport.setVisible(true);
            ManageFoodPanel.setVisible(false);
            ManagerPanel.setVisible(false);
            manageOrderPanel.setVisible(false);
        }else if (e.getSource()==ManageEmployee){
            ManagerPanel.setVisible(true);
            ManageFoodPanel.setVisible(false);
            FinancialReport.setVisible(false);
            manageOrderPanel.setVisible(false);
        }else if(e.getSource()==empRefresh){
            ManageEmployeePane.setVisible(false);
            employeeTable.setVisible(false);
            
            initx();
            JTable tempTable = new JTable(imployeeInfo,column);
            tempTable.setBounds(0,50 , 500,500);
            JScrollPane tempScrollPane = new JScrollPane();
            tempScrollPane.setBounds(80 ,50,1000,400);
            tempScrollPane.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
            tempScrollPane.setViewportView(tempTable);

            ManagerPanel.add(tempScrollPane);
            tempScrollPane.setVisible(true);
            
        }
        else if(e.getSource()==ManageFood){
            ManageFoodPanel.setVisible(true);
            ManagerPanel.setVisible(false);
            FinancialReport.setVisible(false);
        }else if(e.getSource()==addFood){
            new AddFood().setVisible(true);
        }
        else if(e.getSource()==removeFood){
            new RemoveFood().setVisible(true);
            
            
        }
        else if(e.getSource()==addEmployee){
            new AddEmployee().setVisible(true);
            
        }else if(e.getSource()==foodRefresh){
            ManagefoodPane_food.setVisible(false);
            foodtable.setVisible(false);
            
            initFood();
            JTable tempTable = new JTable(FoodInfo,FoodColumn);
            tempTable.setBounds(0,50 , 500,500);
            JScrollPane tempScrollPane = new JScrollPane();
            tempScrollPane.setBounds(80 ,50,1000,400);
            tempScrollPane.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
            tempScrollPane.setViewportView(tempTable);

            ManageFoodPanel.add(tempScrollPane);
            tempScrollPane.setVisible(true);

        }
        else if(e.getSource() == ManageOrder){
            ManagerPanel.setVisible(false);
            ManageFoodPanel.setVisible(false);
            FinancialReport.setVisible(false);
            manageOrderPanel.setVisible(true);
        }
        else if(e.getSource()==orderRefresh){
            manageOrderPane.setVisible(false);
            orderTable.setVisible(false);
            
            initOrder();
            JTable tempTable = new JTable(orderInfo,ordercolumn);
            tempTable.setBounds(0,50 , 500,500);
            JScrollPane tempScrollPane = new JScrollPane();
            tempScrollPane.setBounds(80 ,50,1000,400);
            tempScrollPane.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
            tempScrollPane.setViewportView(tempTable);

            FinancialReport.add(tempScrollPane);
            tempScrollPane.setVisible(true);

        }
         
        
        else if(e.getSource()==removeEmoployee){
            new RemoveEmployee().setVisible(true);
            
        }
    }
    /*public static void main(String[] args){
       
        EmployeePage obj = new EmployeePage(new HomePage());
    }*/

}
