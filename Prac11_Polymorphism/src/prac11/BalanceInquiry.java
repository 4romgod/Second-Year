
package prac11;

public class BalanceInquiry extends Transaction{

    public BalanceInquiry(int accNo){
        super(accNo);
    }
    
    public String execute(){
        String message = "executing BalanceInquiry. Balance: R" +super.balance;
        return message;
    }       //close the execute method
    
}       //end class
