/* employye.txt format 
*   username;password;name;designation;email;phone;salary;address
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EmployeeInfo{
    
    int size = getNoOfEmployeee();
    String [][]TotInfo = new String[size][8];
    private String imployeeInfo[][];
    private String column[] = {"Usernameame", "Password", "Name", "Designation","Email","Phone No","Salary","Address"};

    EmployeeInfo(){
        init();
    }

     // this will initialize the array of the employee information
    public void init() {
        size= getNoOfEmployeee();
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
    
    
    // this will authenticate the id and password
    public boolean authentication(String uName, String pass){
        init();
        boolean authenticated =false;
        for (int j = 0; j < size; j++) {
            if (TotInfo[j][0].equals(uName) && TotInfo[j][1].equals(pass)) {
                authenticated= true;
                break;
            }
        }
        return authenticated;
    }

    // Return designation for the permission
    public String getDesignation(String uName){
        init();
        String designation = "";
        for (int j = 0; j < size; j++) {
            if (TotInfo[j][0].equals(uName)) {
                designation = TotInfo[j][3];
                break;
            }
        }
        return designation;
    }

    // this will create employee
    public void adddNewEmployee(String username, String pass, String Name,String designation, String email,String phone, String salary, String address){
        /*employye.txt format 
        * username;password;name;designation;email;phone;salary;address
        */

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(".//Data//Employee.txt",true));
            bw.write(username+";"+pass+";"+Name+";"+designation+";"+email+";"+phone+";"+salary+";"+address);
            bw.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        init();
    }

    //remove employee by id
    public void rmEmployeeByID(String ID){
        init();
        for (int j = 0; j < size; j++) {
            if (TotInfo[j][2].equals(ID)) {
                // remove operation will be added
                break;
            }
        }
    }





    // this will retrive the number of employee from the file
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
            br.close();
            return i;
            
        }catch(Exception e){
            return -1;
        }
    }
}