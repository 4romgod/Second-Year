
package prac17_jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;


public class ReadFileWriteSer {
    
    MyDB myDB;
    
    BufferedReader br;
    ObjectOutputStream output;      //we use OUTPUT to WRITE... to serialized file
    
    int catNum, quantSold;
    double purchPr, sellPr;
    Boolean inStock;
    String itemDesc;
    
    public void open(){   
        //Create a database instnance
        myDB = new MyDB();
        myDB.connect();
        myDB.createProductTable();
        
        try{
            br = new BufferedReader(new FileReader("SalesDelim2.txt"));
            output = new ObjectOutputStream(new FileOutputStream("OutOfStockSerial.ser"));
        }
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
                
                catNum = Integer.parseInt(token.nextToken());
                itemDesc = token.nextToken();
                purchPr = Double.parseDouble(token.nextToken());
                sellPr = Double.parseDouble(token.nextToken());
                quantSold = Integer.parseInt(token.nextToken());
                inStock = Boolean.parseBoolean(token.nextToken());
                                   
                myDB.insertValues(catNum, itemDesc, purchPr, sellPr, quantSold, inStock);
                               
                if(inStock==false){                
                    Product product = new Product(catNum, itemDesc, purchPr, sellPr, quantSold, inStock);
                    output.writeObject(product);
                }      //end if
                
                //System.out.println(catNum+"**"+itemDesc+"**"+purchPr+"**"+sellPr+"**"+quantSold+"**"+inStock);
                
                ln = br.readLine();
            }       //end while
                        
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    
    }     //end process()
    
    public void close(){
        try{
            myDB.close();
            br.close();
            output.close();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }       //end close()

    
}       //end class
