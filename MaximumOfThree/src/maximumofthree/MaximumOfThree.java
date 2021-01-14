
package maximumofthree;

import java.util.*;

public class MaximumOfThree {

    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int num1, num2, num3;
        
        System.out.print("Enter the first number: ");
        num1=input.nextInt();
        System.out.print("Enter the second number: ");
        num2=input.nextInt();
        System.out.print("Enter the third number: ");
        num3=input.nextInt();
        
        System.out.println();
        
        System.out.printf("The maximum number is: %d", returnMax(num1, num2, num3));
        System.out.println();
    }   //close main methood
    
    public static int returnMax(int x, int y, int z){
    
        int max=x;
        
        if(y>max){
            max=y;
        }   //close if statement
        
        if(z>max){
            max=z;
        }   //close if statement
        
        return max;
    }   //close returnMax method
    
}
