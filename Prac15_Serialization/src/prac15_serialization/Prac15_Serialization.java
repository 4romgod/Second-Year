/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac15_serialization;

/**
 *
 * @author Gauntlet
 */
public class Prac15_Serialization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ReadFileWriteSer writeSer = new ReadFileWriteSer();       
        writeSer.open();
        writeSer.process();
        writeSer.close();
        
        FileWrite write = new FileWrite();
        write.open();
        write.process();
        write.close();
    }
    
}
