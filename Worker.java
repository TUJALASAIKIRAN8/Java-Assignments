import java.util.*;
import javax.swing.JOptionPane;

public class Worker implements Comparable <Worker>{
        protected ArrayList < Table > tables;
        public String name;
        public int servedTables;
        
        public Worker(){
                tables = new ArrayList < Table >();
                servedTables = 0;
                int nameParts = 0;
                
                do{
                        nameParts = 0;
                        name = JOptionPane.showInputDialog("enter worker name must consists 2-4 parts");                   
                        StringTokenizer st = new StringTokenizer(name, " ");
                        
                        while (st.hasMoreTokens()) 
                        {
                                st.nextToken();nameParts += 1;   
                        }                        
                               
                }while( nameParts < 2 || nameParts > 4);                
        }
        public ArrayList < Table > getTables(){
                return tables;
        }
        
        public int compareTo(Worker aWorker){  
                int current = servedTables;
                int other = aWorker.servedTables;
                return current - other;
        }
        
        public String toString() { return name + ", " + servedTables; }
        
        public void serveTable(){
        }
        public static void main(String[] args){
                Worker aWorker = new Worker();               
        }
 }
