
package prac11;

public abstract class Transaction{
    
    private int accountNumber;
    public double balance;
        
    public Transaction(int accNo){
        setAccountNumber(accNo);
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }
    
    public void setAccountNumber(int accNo){
        this.accountNumber = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
     
    public abstract String execute();
    
}       //close the class
