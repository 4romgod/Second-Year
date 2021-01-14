
package prac9;

import javax.swing.JFrame;

public class RunPrac9Gui {
    
    public static void main(String[] args){
        
        Prac9Gui myGui = new Prac9Gui();
        myGui.setLocationRelativeTo(null);
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setSize(500,300);
        myGui.setVisible(true);
        myGui.setResizable(false);
    
    }       //close the main method
    
    
}       //close the class
