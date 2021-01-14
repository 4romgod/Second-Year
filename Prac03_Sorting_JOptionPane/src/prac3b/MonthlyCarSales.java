/**
 * LESSONS
 * 1. Default Constructor 
 * 2. Constructor
 * 3. toString method
 */
package prac3b;

public class MonthlyCarSales {

    String saleMonth;
    double  saleValue;
    
    public MonthlyCarSales(){
        saleMonth = "";
        saleValue = 0;
    }
    
    public MonthlyCarSales(String nm, double val){
        saleMonth = nm;
        saleValue = val;
    }
    
    public void setSaleMonth(String nm){
        saleMonth = nm;
    }
    
    public String getSaleMonth(){
        return saleMonth;
    }
    
    public void setSaleValue(double val){
        saleValue = val;
    }
    
    public double getSaleValue(){
        return saleValue;
    }
    
    public String toString(){
        
        String message = getSaleMonth() + ": " + String.format("%.02f",getSaleValue());
                
        return message;
    }
    
}       //close the class
