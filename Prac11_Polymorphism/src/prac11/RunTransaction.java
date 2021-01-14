
package prac11;

import java.util.*;

public class RunTransaction {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //creating polymorphic objects then add them to the array
        Transaction[] transaction = new Transaction[3];
        transaction[0] = new BalanceInquiry(12345);
        transaction[1] = new Withdrawal(12345, 100);
        transaction[2] = new Deposit(12345, 200);
        
        int transNo;
        do{
            System.out.println("0. Balance Inquiry \n1. Withdrawal \n2. Deposit");
            System.out.print("Choose a Transaction: ");

            transNo = input.nextInt();
            
            if(transNo==0){
                System.out.println(transaction[transNo].execute());
                System.out.println();
            }
            else if(transNo==1){
                System.out.println(transaction[transNo].execute());
                System.out.println();
            }
            else if(transNo==2){
                System.out.println(transaction[transNo].execute());
                System.out.println();
            }
            
//            if((transNo>=0)&&(transNo<3)){
//                System.out.println(transaction[transNo].execute());
//                System.out.println();
//            }
        
        }while((transNo>=0)&&(transNo<3));
        
        
    }       //end main method
    
}       //end class
