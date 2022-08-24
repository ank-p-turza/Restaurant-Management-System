import Resturant.*;
// import java.util.Scanner;
// import java.awt.*;
// import java.awt.event.*;




public class Shop {
    public Shop(String x ){

        Management management = new Management();
        management.launchGui(x);        
    }
    //  public static void main(String[] arrstring) {
        // new Shop();
        // Scanner scan = new Scanner(System.in);
        // String name;
        // int quantity;
        //management.removeFromMenue("burger");
       // management.addNewFood("egg-sandwich", 300, 80);

        // System.out.println("Welcome to the shop heres the menue:");
        // management.checkMenue();
        // System.out.println("What would you like to order?");
        // name = scan.nextLine();
        // System.out.println("enter the quantity");
        // quantity = scan.nextInt();
        // management.placeOrder(name, quantity);
    //  }
}