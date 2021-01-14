/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac15_serialization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {
    
    BufferedWriter bw;
    ReadSer read = new ReadSer();

    public void open(){
        try{
            read.open();
            bw = new BufferedWriter(new FileWriter("OutputFile.txt", true));        //the true parameter appends text to an existing file
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }
    
    
    public void process(){
                
        ArrayList<Product> productList = read.process();
        
        try{
            for(int i=0; i<productList.size(); i++){
                bw.write(productList.get(i).toString()+"\r\n");
            }       //end while
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }       //end process
    
    
    public void close(){
        try{
            read.close();
            bw.close();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }
    
}
