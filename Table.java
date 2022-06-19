import java.util.*;
import javax.swing.JOptionPane;


public class Table{

        public int number;
        public ArrayList<Meal> order;
        public boolean chefDone;
        private double orderBill;
        
        public Table(ArrayList <Meal> aMenu, int number){
                order = new ArrayList<Meal>();chefDone = false;
                
                // showing menu start
                String menuList = "Meal Name" + "    " + "Meal Price\n";                
                for (Meal aMeal: aMenu) {
                        menuList += aMeal.name + "    " + aMeal.price + "\n";
                }                
                menuList +="enter name and quantity of means comma separated.";    
                String orderStr = JOptionPane.showInputDialog(menuList);                
                System.out.println(orderStr);        
                //showing menu end
                
                StringTokenizer st1 = new StringTokenizer(orderStr, ","), st2;             
                String subMeal = " ", mealName = " ";               
                int mealCount = 0;
                
                while (st1.hasMoreTokens()){    
                    // sub meal           
                    subMeal = st1.nextToken();
                    st2 = new StringTokenizer(subMeal, " ");
                    mealName = st2.nextToken();
                    mealCount = Integer.parseInt(st2.nextToken());
                    boolean mealFound = false;
                    
                    for(Meal aMeal: aMenu){
                        if(aMeal.name.equals(mealName)){
                                mealFound = true;                     
                                
                                for(int index = 0; index < mealCount; index++){
                                        aMeal.addDate();
                                        orderBill += aMeal.price;
                                }                               
                        }
                    }
                    
                    if(!mealFound) JOptionPane.showMessageDialog(null, "Meal: "+ mealName +
                                                                " not found.");                               
               }
               JOptionPane.showMessageDialog(null,"Order has been placed"); 
               //bill();               
        }
        
        double bill(){ 
                JOptionPane.showMessageDialog(null,"Order bill: "+orderBill);
                return orderBill;
        }
        
        public static void main(String[] args){
                ArrayList<Meal> aMenu = new ArrayList<Meal>();
                Meal one = new Meal();
                Meal two = new Meal();
                aMenu.add(one); aMenu.add(two);
                Table aTable = new Table(aMenu, 1);            
                
        }
}


