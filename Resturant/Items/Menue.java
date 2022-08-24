package Resturant.Items;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;
import java.awt.Desktop;





public class Menue {
    private ArrayList<Food> menue = new ArrayList<Food>();
    private double totalSold = 0;
    private String tableNo;

    public Menue(){
        initMenue();
    }
    private void initMenue(){
        try{
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(".//Data//menueItems.txt"));
            while((line = reader.readLine()) != null){
                String[] res = line.split("[,]", 0);
                menue.add(new Food(res[0],Integer.parseInt(res[1]),Double.parseDouble(res[2])));                
            }
            reader.close();
        }catch(Exception e){e.printStackTrace();}
    }
    private void saveMenue(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(".//Data//menueItems.txt"));
            for(int i = 0; i < menue.size(); i++){
                menue.get(i).writeFood(writer);
            }
            writer.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public void deleteFood(String name){
        for(int i = 0; i < menue.size(); i++){
            if(menue.get(i).getFName().equals(name)){
                menue.remove(i);
                System.out.println("Successfully removed");
                saveMenue();
                return;
            }
        }
        System.out.println("No such food found");
    }
    public void addFood(String name, int quantity, double price){
        for(int i = 0; i < menue.size(); i++){
            if(menue.get(i).getFName().equals(name)){
                System.out.println("Food already exist ammount increased");
                menue.get(i).increaseAmmount(quantity);
                return;
            }
        }
        menue.add(new Food(name,quantity,price));
        System.out.println("Food added successfully");        
        saveMenue();
    }
    private void financesWrite(Food f, int ammount){
        Desktop d = Desktop.getDesktop();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(".//Data//finances.txt", true));
            File od = new File(".//Data//Order.txt");
            BufferedWriter odwr = new BufferedWriter(new FileWriter(".//Data//Order.txt", true));
            odwr.write("\t\tOrder Summary\r\nFood Name: "+f.getFName()+"\r\nAmmount: "+ammount+"\r\nTotal Cost: "+ammount*f.getPrice()+"\r\nTable Number: "+tableNo);
            odwr.close();
            d.open(od);
            
            
            writer.write((ammount + " " + f.getFName() + "'s" + " sold worth " + ammount*f.getPrice() +" 'sfrom "+tableNo+ "\r\n"));
            totalSold += (ammount*f.getPrice());
            writer.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public int getListLength() {
        return menue.size();
    }
    public void buy(String fName, int n,String x) {
        tableNo =x;
        if(n<0){
            JOptionPane.showMessageDialog(null, "Invailid amount");
            return;
        }else{        
        for (int i = 0; i < menue.size(); ++i) {
            if (fName.equals(menue.get(i).getFName()) && menue.get(i).getQuan() > n){
                menue.get(i).order(n);
                financesWrite(menue.get(i), n);
                saveMenue();
                JOptionPane.showMessageDialog(null,"\tOrder placed\n It will be ready within few minutes.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Order not available");
    }
    }
    public double getSales(){return totalSold;}

    public String[][] getData(){
        String data[][] = new String[menue.size()][2];
        for(int i=0; i<menue.size(); i++){
            data[i] = menue.get(i).getData();
        }
        return data;
    }

    public Food getFood(int i){return menue.get(i);}


    public void seeFoods(){
        for(int i = 0; i < menue.size(); i++){
            menue.get(i).foodINFO();
        }
    }  
}