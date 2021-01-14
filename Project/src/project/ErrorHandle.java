
package project;

import javax.swing.JOptionPane;

public class ErrorHandle {
    
    public static boolean inputNotNull(String input){
        if(input.equalsIgnoreCase("")){
            return false;
        }
        else{
            return true;
        }
    }       //end inputNull()
    
    
    //method checks if input value is int or double, else return exception
    public static boolean inputValid(String input){
        try{
            int intNumber = Integer.parseInt(input);
            double doubleNumber = Double.parseDouble(input);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }       //end inputValid()
    
    
    
}
