
package prac5;

public class Invoice {
    
    String partNumber;
    String description;
    double unitPrice;
    int quantity;
    
    public Invoice(){
        partNumber = "";
        description = "";
        unitPrice = 0;
        quantity = 0;
    }
    
    public Invoice(String num, String desc, double price, int quant){
        partNumber = num;
        description = desc;
        unitPrice = price;
        quantity = quant;
    }
    
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
    
    public String getPartNumber() {
        return partNumber;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   
    public String getDescription() {
        return description;
    }

     public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

   public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calcPaymentAmount(){
        return getQuantity()*getUnitPrice();
    }
    
    public String toString(){
        String message = String.format("%-15s %-15s %-15.2f %-15d %.2f", getPartNumber(), getDescription(), getUnitPrice(), getQuantity(), calcPaymentAmount());
        
        return message;
    }       
    
    
    
   
}       //close the class
