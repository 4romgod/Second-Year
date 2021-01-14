/**
 * LESSONS
 * 1. Creating array of Objects
 * 2. Using Random class to create values of type double 
 * 3. Calculating highest and lowest values in an array of objects
 * 4. Using the "contains" method
 * 5. Using comparator to sort objects
 */
package prac3b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JOptionPane;


public class RunMonthlyCarSales {
    
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    private static MonthlyCarSales carSales;       //just declare the MonthlyCarSales object
        
    private static MonthlyCarSales[] carSalesArray = new MonthlyCarSales[12];       //create an array of carSales objects
    
    public static void main(String[] args){

        Random rand = new Random();
   
        for(int i=0; i<carSalesArray.length; i++){
            carSales = new MonthlyCarSales(months[i], (2+rand.nextDouble()*498));       //creates a random value from (2 to 500)
            carSalesArray[i] = carSales;        //fill the array with carSales objects
            
            System.out.println(carSalesArray[i].toString());
        }       //close the for loop
        
        highestSales();
        lowestSales();
        
        monthsWithAR();
        
        sortArray();
        
    }       //close the main method
    
    
    public static void highestSales(){
        
        int index = 0;
        double highest = carSalesArray[index].getSaleValue();
        
        for(int i=0; i<carSalesArray.length; i++){
            if(carSalesArray[i].getSaleValue() >= highest){
                highest = carSalesArray[i].getSaleValue();
                index = i;
            }      //close the if statement
        }       //close the for loop
        
        JOptionPane.showMessageDialog(null, "HIGHEST SALE\n" + carSalesArray[index].toString());
        
    }       //close the extremeSales method
    
    
    public static void lowestSales(){
        
        int index = 0;
        double lowest = carSalesArray[index].getSaleValue();
        
        for(int i=0; i<carSalesArray.length; i++){
            if(carSalesArray[i].getSaleValue()<lowest){
                lowest = carSalesArray[i].getSaleValue();
                index = i;
            }      //close the if statement
        }       //close the for loop
        
        JOptionPane.showMessageDialog(null, "LOWEST SALE\n" + carSalesArray[index].toString());
        
    }       //close the extremeSales method
    
    
    public static void monthsWithAR(){
        ArrayList arMonthObjects = new ArrayList();       //arraylist to store objects with months AR
        
        for(int i=0; i<months.length; i++){
            String month = carSalesArray[i].saleMonth;
                
            if(month.contains("ar")){           //contains method checks if string contains the substring
                arMonthObjects.add(carSalesArray[i]);
            }      //close the if statement         
        }       //close the big for loop
        
        String message = "MONTHS WITH AR\n";
        for(int z=0; z<arMonthObjects.size(); z++){           
            message += arMonthObjects.get(z).toString()+"\n";           
        }
            
        JOptionPane.showMessageDialog(null, message);

    }       //close the monthsWithAR method
    
    
    public static void sortArray(){
        
        ArrayList arrayList = new ArrayList();
        
        for(int i=0; i<carSalesArray.length; i++){
            arrayList.add(carSalesArray[i]);
        }   
        
        System.out.println("\nSort Sales through Month Name");      
        Comparator<MonthlyCarSales> comName = new Comparator<MonthlyCarSales>(){         
            public int compare(MonthlyCarSales sales1, MonthlyCarSales sales2){
                return sales1.saleMonth.compareToIgnoreCase(sales2.saleMonth);
            }      
        };
        Collections.sort(arrayList, comName);
        
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).toString());
        }     
               
        System.out.println("\nSort Sales through Month Sales");   
        Comparator<MonthlyCarSales> comSales = new Comparator<MonthlyCarSales>(){     
            public int compare(MonthlyCarSales sales1, MonthlyCarSales sales2){
                return (int) ((sales1.saleValue) - (sales2.saleValue));
            }   
        };        
        Collections.sort(arrayList, comSales);
        
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).toString());
        }
    
    }       //close the sortArray method
    
            
    
    
}       //close the class
