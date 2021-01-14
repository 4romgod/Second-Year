/**
 * 1. using polymorphism to declare same objects that behave differently
 * 2. storing object in array and referencing them
 * 3. working with interface to get common property of different classes
 */

package prac12;


public class RunLoanInterest {

    public static void main(String[] args) {

        int index = 0;
        LoanInterest[] loanInt = new LoanInterest[3];
        loanInt[index++] = new UnderGrad("Spence", "spn001", 100000);
        loanInt[index++] = new PostGrad("Pacman", "pcm001", 100000);
        loanInt[index++] = new SmallBusiness("SOFTDEV", "1011Dev", 100000);
        
        for (LoanInterest loanInt1 : loanInt) {
            System.out.println(loanInt1.toString());
            System.out.println();
        } //end for loop

    
    }       //end main method
    
    
}       //end the class
