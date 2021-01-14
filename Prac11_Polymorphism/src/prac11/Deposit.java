
package prac11;


public class Deposit extends Transaction {
    
    private double amount;
    
    public Deposit(int accNo, double amt){
        super(accNo);
        setAmount(amt);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String execute(){
        String message = "executing Deposit of amount: R"+getAmount();
        return message;
    }
    
}
