
package prac8;

import javax.swing.JFrame;

public class RunGui {
    
    public static void main(String[] args){
        
        Gui myGui = new Gui();
        myGui.setLocationRelativeTo(null);
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setSize(350,200);
        myGui.setVisible(true);
    
    }       //close the main method
    
    
}       //close the class
