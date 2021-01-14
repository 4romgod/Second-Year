
package prac12;

public class UnderGrad extends Student {
    
    public UnderGrad(String name, String studNum, double loanAmount){
        super(name, studNum, loanAmount);
    }

    @Override
    public double interest() {
        double interest=super.getLoanAmount()*0.12;
        return interest;
    }

    @Override
    public String toString() {
        String message = "UnderGrad " + super.toString() + "\nInterest: R" +interest();
        return message;
    }
    
    
    
}
