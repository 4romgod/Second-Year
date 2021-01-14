
package prac15_serialization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class ReadFileWriteSer {
    
    BufferedReader br;
    ObjectOutputStream output;
    
    public void open(){
        try{
            br = new BufferedReader(new FileReader("SalesDelim.txt"));
            output = new ObjectOutputStream(new FileOutputStream("prod.ser"));
        }       //end try
        catch(FileNotFoundException fnfe){
            fnfe.getMessage();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }

    }        //end open()
    
    
    public void process(){
    
        try{
            String ln = br.readLine();
            
            while(ln != null){
                StringTokenizer token = new StringTokenizer(ln, "**");

                int prodType = Integer.parseInt(token.nextToken());
                int catNum = Integer.parseInt(token.nextToken());
                String prodDescription = token.nextToken();
                int prodPurchasePrice = Integer.parseInt(token.nextToken());
                int prodSellPrice = Integer.parseInt(token.nextToken());
                int prodQuantity = Integer.parseInt(token.nextToken());
                
                Product prod = new Product(prodType, prodDescription, prodSellPrice, prodQuantity);             
                output.writeObject(prod);
               
                ln = br.readLine();
            }
        }       //end try
        catch(IOException ioe){
            ioe.getMessage();
        }
    
    }     //end process
    
    
    public void close(){
        try{
            br.close();
            output.close();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }       //end close
    
}       //end class
