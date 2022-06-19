//package Restaurant;
import java.util.*;
import javax.swing.JOptionPane;


public class Meal implements Comparable <Meal> {

    public String name;
    public double price;
    public ArrayList < Date > orderDates = new ArrayList < Date > ();
    
    public Meal() {        
        name = JOptionPane.showInputDialog("enter the meal name ");
        price = Double.parseDouble(JOptionPane.showInputDialog("enter the price of meal "));
        while (price < 0)
            price = Double.parseDouble(JOptionPane.showInputDialog("enter a positive number for the price"));          
    }
    
    public Meal(String name, double price) {
        this.name = name;this.price = price;
    }
    
    public void addDate() {
        orderDates.add(new java.util.Date());

    }
    
    public int compareTo(Meal aMeal) {
        int other = aMeal.orderDates.size();
        int current = this.orderDates.size();
        if (current > other) return 1;
        else if (current < other) return -1;
        else return 0;

    }
    
    public String toString() { //overriding the toString() method  
        return "Meal Name:" + name + "price: " + price + "Ordered" + orderDates.size() + "times";
    }

}


