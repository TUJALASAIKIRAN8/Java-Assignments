import java.util.*;
import javax.swing.JOptionPane;

public class Chef extends Worker{
        public int mealsDone;
        
        public Chef(){
                mealsDone = 0;
        }
        
        public void serveTable(){           
                Iterator< Table > it = tables.iterator();
                while (it.hasNext()) {
                        Table aTable = it.next();
                        String[] options = new String[] {"Yes", "No", "Cancel"};
                        int response = JOptionPane.showOptionDialog(null, "Done serving table number:"+aTable.number, 
                                     "Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                     null, options, options[0]);      
                                     
                        switch (response){
                                case 0:
                                        aTable.chefDone = true;
                                        servedTables += 1;
                                        for(Meal aMeal: aTable.order)
                                                mealsDone += aMeal.orderDates.size();
                                        it.remove();
                                break;
                                
                                case 1:                               
                                case 2:
                                break;
                        } // switch case end
                }// while case end                  
        }// serveTable() end
        
        public int comapreTo(Worker aWorker){
                if (aWorker instanceof Chef ==  false ) 
                        return super.compareTo(aWorker);
                Chef aChef = (Chef) aWorker;
                int other  = aChef.mealsDone;
                if(mealsDone < other) return 1;
                else if(mealsDone > other) return -1;
                return 0;
        }
        public String toString(){
                return super.toString() + ", " + mealsDone;                
        }
        public static void main(String args[]){
                System.out.println("start");
                String[] options = new String[] {"Yes", "No", "Cancel"};
                int response = JOptionPane.showOptionDialog(null, "Done serving table number:"+14, 
                             "Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                             null, options, options[0]); 
                System.out.println(response);
        }

}
