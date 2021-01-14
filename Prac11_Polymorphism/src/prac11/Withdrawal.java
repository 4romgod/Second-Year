
package prac11;

public class Withdrawal extends Transaction {
    
   private double amount;       //amount to withdraw
   
   public Withdrawal(int accNo, double amount){
       super(accNo);
       setAmount(amount);
   }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public double newBalance(){
        return (super.balance-amount);
    }
   
   @Override
   public String execute(){
       String message = "execute Withdrawal of amount: R" +getAmount();
       return message;
   }
    
}       //end the class
