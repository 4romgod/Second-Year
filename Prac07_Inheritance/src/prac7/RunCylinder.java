
package prac7;

import javax.swing.JOptionPane;

 
public class RunCylinder {
    
    public static void main(String[] args){
    
        //Take circle properties and print
        Circle circle;
        int radius = Integer.parseInt(JOptionPane.showInputDialog("Enter radius: "));
        circle = new Circle(radius);
        JOptionPane.showMessageDialog(null, circle.toString());

        //Take cylinder properties and print
        Cylinder cylinder;
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter height: "));
        cylinder = new Cylinder(circle.getRadius(), height);
        JOptionPane.showMessageDialog(null, cylinder.toString());

    }     //close the main method
    
    
}       //close the class
