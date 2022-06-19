import java.util.*;
import javax.swing.JOptionPane;

public class Waiter extends Worker{
        
        
        public Waiter(){
        }
        
        public void serveTable(){
                Iterator< Table > it = tables.iterator();
                while (it.hasNext()) {
                        Table aTable = it.next();
                        if(!aTable.chefDone) continue;
                        String[] options = new String[] {"Yes", "No",};
                        int response = JOptionPane.showOptionDialog(null, "Close table number:"+aTable.number, 
                                     "Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                     null, options, options[0]);
                        switch (response){
                                case 0:
                                        JOptionPane.showMessageDialog(null,"Order bill: " + aTable.bill());
                                        servedTables += 1;                                        
                                        it.remove();
                                break;                                
                                case 1:
                                break;
                        } // switch case end                        
                }
        }
        
        public int comapreTo(Worker aWorker){
                return 1;
        }
}
