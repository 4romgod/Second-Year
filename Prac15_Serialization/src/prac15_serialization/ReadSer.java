
package prac15_serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReadSer{
    
    ArrayList<Product> productList = new ArrayList();
    ObjectInputStream input;
    
    public void open(){
        try{
            input = new ObjectInputStream(new FileInputStream("prod.ser"));
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    
    }        //end open()
    
    
    public ArrayList process(){
        try{
            while(true){
                Product product = (Product) input.readObject();
                productList.add(product);
            }       //end while
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
        catch(ClassNotFoundException cnfe){
            cnfe.getMessage();
        }
        
        Comparator<Product> com = new Comparator<Product>(){
            public int compare(Product o1, Product o2) {
                return o1.prodDescription.compareToIgnoreCase(o2.prodDescription);
            }
        };
        
        Collections.sort(productList, com);
        return productList;
    }     //end process
    
    
    public void close(){
        try{
            input.close();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }       //end close
    
    
}       //end class
