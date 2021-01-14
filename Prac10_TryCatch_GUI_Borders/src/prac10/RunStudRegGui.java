
package prac10;

import javax.swing.JFrame;

public class RunStudRegGui {
    
    public static void main(String[] args){
    
        StudRegGui myGui = new StudRegGui();
        myGui.setLocationRelativeTo(null);
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setSize(400,180);
        myGui.setVisible(true);
        myGui.setResizable(false);
    
    }       //end main method   
    
}       //end class
