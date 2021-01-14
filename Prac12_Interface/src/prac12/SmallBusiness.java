/*
* Overrides the interface methods: interest
*/
package prac12;


public class SmallBusiness implements LoanInterest{

    private String name, registerNum;
    private double loanAmount;

    public SmallBusiness(String name, String registerNum, double loanAmount) {
        this.name = name;
        this.registerNum = registerNum;
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        String message = "SmallBusiness\nName: "+name +"\nRegister Number: "+registerNum +" \nLoan Amount: R" +loanAmount +"\nInterest: R" +interest();
        return message;
    }
    
    @Override
    public double interest() {
        double interest = loanAmount*0.15;
        return interest;
    }
    
}
