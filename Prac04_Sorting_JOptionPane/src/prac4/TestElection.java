/**
 * LESSONS
 * 1. Creating array of Objects
 * 2. Calculating percentages
 * 3. Using the "toString" method
 * 4. Using comparator to sort objects
 */

package prac4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class TestElection {
    
    public static void main(String[] args){
        
        Election[] elecArray=new Election[0];       //declare array of objects of type Election
                
        //-------------------------PROMPT USER TO ENTER THE LENGTH OF THE ARRAY--------------------------
        int elecArrayLen=0;
        try{
            elecArrayLen = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of candidates: "));
            elecArray = new Election[elecArrayLen];
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "There were no candidates!");
            return;
        }
        
        
        //--------------------POPULATE THE ARRAY WITH OBJECTS OF TYPE ELECTION------------------------
        for(int i=0; i<elecArrayLen; i++){           
            String candidate = JOptionPane.showInputDialog("Candidate: ");
            int numVotes = Integer.parseInt(JOptionPane.showInputDialog("Number of Votes: "));
            
            elecArray[i] = new Election(candidate, numVotes);            
        }     //close the for loop
    
        
        //-------------------------CALCULATE THE TOTAL NUMBER OF VOTES------------------------------
        int totVotes = 0;
        for(int t=0; t<elecArrayLen; t++){
            totVotes += elecArray[t].numVotes;
        }       //close the for loop
        
        
        //--------------------------PRINT OUT THE INFORMATION---------------------------------------
        double percent;
 
        System.out.printf("%-20s %-20s %s \n","Candidate", "Votes", "% of Total Votes");        //header names

        for(int p=0; p<elecArrayLen; p++){
            percent = ((double) (elecArray[p].numVotes)/totVotes)*100;
            
            System.out.printf(elecArray[p].toString() + " %.2f\n", percent);
        }     //close the for loop
        
        
        //--------------------------DETERMINE THE HIGHEST NUMBER OF VOTES------------------------------
        int index = 0;
        int highVotes = elecArray[index].numVotes;
        
        for(int h=0; h<elecArrayLen; h++){
            if(elecArray[h].numVotes>highVotes){
                highVotes = elecArray[h].numVotes;
                index = h;
            }    //close the if statement
        }     //close the for loop
        
        System.out.println("Total Votes: " + totVotes);
        System.out.println("Winner of election is: " + elecArray[index].candidate);
        
   
        //-----------------------CREATE ARRAY FOR VOTES >4000--------------------------------------------
        ArrayList elecArrayList = new ArrayList();
        
        for(int z=0; z<elecArrayLen; z++){      
            if(elecArray[z].numVotes>4000){
                elecArrayList.add(elecArray[z]);
            }       //close the if statement
        }       //close the for loop
        
        
        //-----------------------------SORT THE ARRAYLIST-------------------------------------------
        System.out.println("\nSorted ArrayList of Candidates");
        
        Comparator<Election> comNames = new Comparator<Election>(){
            
            public int compare(Election e1, Election e2){
                return e1.candidate.compareToIgnoreCase(e2.candidate);
            }
        
        };
        
        Collections.sort(elecArrayList, comNames);        
        
        for(int i=0; i<elecArrayList.size(); i++){
            System.out.println(elecArrayList.get(i).toString());
        }
        
        
        System.out.println("\nSorted ArrayList of VOTES");

        Comparator<Election> comVotes = new Comparator<Election>(){
            
            public int compare(Election e1, Election e2){
                return e1.numVotes-e2.numVotes;
            }
        };
        
        Collections.sort(elecArrayList, comVotes);
        
        for(int i=0; i<elecArrayList.size(); i++){
            System.out.println(elecArrayList.get(i).toString());
        }
    
    }       //close the main method
    
    
}       //close the class
