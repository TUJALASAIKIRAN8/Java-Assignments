import java.util.*;
import javax.swing.JOptionPane;

public class Restaurant {
    public ArrayList < Worker > workers;
    public ArrayList < Meal > menu;

    public Restaurant() {
        int choice = -1, response = -1;
        workers = new ArrayList < Worker > ();
        menu = new ArrayList < Meal >();
        String metaData = "Enter the number of your choice: \n";

        metaData += "1.Add waiter\n";
        metaData += "2.Add Chef\n";
        metaData += "3.Exit adding workers\n";
        
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(metaData));
            switch (choice) {
            case 1:
                workers.add(new Waiter());

                break;
            case 2:
                workers.add(new Chef());

                break;
            case 3:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Wrong input, try again");
                choice = 1;
                break;
            }
        } while (choice == 1 || choice == 2);

        String[] options = new String[] {"Yes","No"};
        do {
            response = JOptionPane.showOptionDialog(null, "Add meal",
                "Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
            switch (response) {
            case 0:
                Meal aMeal = new Meal();
                menu.add(aMeal);
                break;
            default:
                break;
            } // switch case end  
        } while (response == 0);

    }

    public void newTable() {
        int tableNumber = 1;
        int leastMealsDone = -1, leastTableServed = -1;
        Chef sChef = null;
        Waiter sWaiter = null;
        Table aTable = new Table(menu, tableNumber);
        // waiter
        for(Worker aWorker: workers){
                if(aWorker instanceof Chef){
                        Chef aChef = (Chef) aWorker;
                        if(leastMealsDone == -1){
                                leastMealsDone = aChef.mealsDone;
                                sChef = aChef;
                                continue;
                        }
                        if(leastMealsDone > aChef.mealsDone){
                                leastMealsDone = aChef.mealsDone;
                                sChef = aChef;
                                continue;
                        }                       
                }
                else{
                        Waiter aWaiter = (Waiter) aWorker;
                        if(leastTableServed == -1){
                                leastTableServed = aWaiter.servedTables;
                                sWaiter = aWaiter;
                                continue;
                        }
                        if(leastTableServed > aWaiter.servedTables){
                                leastTableServed = aWaiter.servedTables;
                                sWaiter = aWaiter;
                                continue;
                        }
                }
        }
        ArrayList<Table> chefTables= sChef.getTables();       
        ArrayList<Table> waiterTables= sWaiter.getTables();
        
        chefTables.add(aTable);
        waiterTables.add(aTable);
        }

    public void displayMostOrderedMeal() {
        int nOrders = -1;
        Meal mMeal = null;
        for(Meal aMeal : menu){
                if(nOrders == -1) {mMeal = aMeal;  nOrders = aMeal.orderDates.size();  }  
               else if(nOrders < aMeal.orderDates.size())  mMeal = aMeal;
        }
        JOptionPane.showMessageDialog(null,"Most Ordered Meal:" + mMeal.name); 
        
    }

    public static void  main(String args[]){         
        Restaurant r = new Restaurant();
        r.newTable();
        r.displayMostOrderedMeal();
    }

}
