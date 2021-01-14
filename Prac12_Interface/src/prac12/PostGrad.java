
package prac12;


public class PostGrad extends Student{
    
    public PostGrad(String name, String studNum, double loanAmount){
        super(name, studNum, loanAmount);
    }

    @Override
    public double interest() {
        double interest=super.getLoanAmount()*0.10;
        return interest;
    }

    @Override
    public String toString() {
        String message = "PostGrad " + super.toString() + "\nInterest: R" +interest();
        return message;
    }
    
    
    
}
