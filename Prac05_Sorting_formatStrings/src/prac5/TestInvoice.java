
package prac5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class TestInvoice {
    
    public static void main(String[] args){
        
        //------------------------------------CREATE AND INITIAALIZE 3 INVOICE OBJECTS---------------------------------------
        ArrayList InvoiceArrayList = new ArrayList();
        
        Invoice inv1, inv2, inv3;
        inv1 = new Invoice("1234", "widget", 25.50, 212);
        inv2 = new Invoice("5678", "sprocket", 27.75, 156);
        inv3 = new Invoice("9012", "gadget", 22.00, 189);       
        InvoiceArrayList.add(inv1);
        InvoiceArrayList.add(inv2);
        InvoiceArrayList.add(inv3);
        
        
//        Invoice inv;
//        
//        String partNum, Desc;
//        double unitPrice;
//        int quantity;
//              
//
//        for(int i=1; i<=3; i++){
//            partNum = JOptionPane.showInputDialog("Enter Part Number: ");
//            Desc = JOptionPane.showInputDialog("Enter Description: ");
//            unitPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter Unit Price: "));
//            quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity: "));
//            
//            inv = new Invoice(partNum, Desc, unitPrice, quantity);
//            
//            InvoiceArrayList.add(inv);
//
//        }



        //---------------------------------SORT OBJECTS IN ARRAYLIST ON PRICE (ASCENDING ORDER)---------------------------------
        Comparator<Invoice> comPrice = new Comparator<Invoice>(){
            
            public int compare(Invoice inv1, Invoice inv2){
                return (int)(inv1.getUnitPrice()-inv2.getUnitPrice());
            }
        }; 
        Collections.sort(InvoiceArrayList, comPrice);
        
        
        //---------------------------------------------DISPLAY VARIBLES OF INVOICE OBJECTS------------------------------------------
        //print out the header
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Object", "part-number", "description", "unit-price", "quantity", "total-payment");
            
        //print out the values
        for(int i=0; i<InvoiceArrayList.size(); i++){
            System.out.printf("%-15s %s \n", "inv"+(1+i), InvoiceArrayList.get(i).toString());            
        }       //close the for loop  
        
        
        //---------------------------------SORT OBJECTS IN ARRAYLIST IN ALPHABETICAL ORDER OF DESCRIPTION---------------------------------
        Comparator<Invoice> comDesc = new Comparator<Invoice>(){
            public int compare(Invoice inv1, Invoice inv2){
                return (inv1.getDescription()).compareToIgnoreCase(inv2.getDescription());
            }       //close the compare method 
        };        
        Collections.sort(InvoiceArrayList, comDesc);


        //---------------------------------------------DISPLAY VARIBLES OF INVOICE OBJECTS------------------------------------------
        //print out the values
        System.out.printf("\n%-15s %-15s %-15s %-15s %-15s %-15s\n", "Object", "part-number", "description", "unit-price", "quantity", "total-payment");
        
        //print out the values
        for(int i=0; i<InvoiceArrayList.size(); i++){
            System.out.printf("%-15s %s \n", "inv"+(1+i), InvoiceArrayList.get(i).toString());
        }       //close the for loop
        
        
    
    }        //close the main method
    
    
}       //close the class
