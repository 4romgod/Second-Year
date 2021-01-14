
package prac6;

import javax.swing.JOptionPane;

public class RunComputer {
    
    public static void main(String[] args){
    
        Computer computer ;
        MultimediaComputer mComputer;
           
        //Take Computer Properties from user, then print
        String cpuType = JOptionPane.showInputDialog("CPU type: ");        
        double cpuSpeed = Double.parseDouble(JOptionPane.showInputDialog("CPU speed: "));    
        computer = new Computer(cpuType, cpuSpeed);
        JOptionPane.showMessageDialog(null, "COMPUTER PROPERTIES\n" + computer.toString());
 
        System.out.println("");

        //Take multimedia computer properties and print
        double romSpeed = Integer.parseInt(JOptionPane.showInputDialog("CD-Rom speed: "));
        mComputer = new MultimediaComputer(computer.getCpuType(), computer.getCpuSpeed(), romSpeed);        //inherits values from computer
        JOptionPane.showMessageDialog(null, "MULTIMEDIA COMPUTER PROPERTIES\n" + mComputer.toString());

        
    }     //close the main method
    
    
}       //close the class
