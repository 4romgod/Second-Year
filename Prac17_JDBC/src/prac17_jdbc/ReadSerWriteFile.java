
package prac17_jdbc;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadSerWriteFile {
    
    ObjectInputStream input;
    
    BufferedWriter bw;
    
    public void open(){       
        try{
            input = new ObjectInputStream(new FileInputStream("OutOfStockSerial.ser"));
            bw = new BufferedWriter(new FileWriter("OutOfStock.txt"));
        }
        catch(FileNotFoundException fnfe){
            fnfe.getMessage();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    
    }        //end open()
    
    
    public void process(){    
        
        int outStock = 0;
        try{
            String message = String.format("%-20s %-20s %-20s %-20s %s", "Description","Purchase Price","Sell Price","Quantity Sold", "Profit/Loss");
            bw.write(message+"\r\n");
            message = String.format("%-20s %-20s %-20s %-20s %s", "-------------","----------------","-------------","-------------", "-------------");
            bw.write(message+"\r\n");
            
            while(true){
                try{
                    Product prod = (Product) input.readObject();

                    message = prod.toString();
                    bw.write(message+"\r\n");
                    outStock++;
                }
                catch(ClassNotFoundException cnfe){
                    cnfe.getMessage();
                }               
            }       //end while
            
            
        }       //end try
        catch(IOException ioe){            
            ioe.getMessage();
            try {
                bw.write("\r\nNumber of Products Out Of Stock: "+outStock);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }

                     
    }     //end process
    
    
    public void close(){
        try{
            input.close();
            bw.close();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }    
    }       //end close
    
}       //end class
