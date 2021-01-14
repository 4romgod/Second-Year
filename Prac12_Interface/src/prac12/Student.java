/**
 * 1. class implements interface
 * 2. since it implements interface, must either override abstract method, or be abstract itself.
 */
package prac12;

public abstract class Student implements LoanInterest{
   
    private String name, studNum;
    private double loanAmount;

    public Student(String name, String studNum, double loanAmount) {
        this.name = name;
        this.studNum = studNum;
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    @Override
    public String toString() {
        String message = "Student\nName: "+name +"\nStudent Number: "+studNum +"\nLoan Amount: R" +loanAmount;
        return message;
    }
    
     
}       //end class
