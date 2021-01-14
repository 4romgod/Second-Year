
package prac4;

public class Election {
    
    String candidate;
    int numVotes;
    
    public Election(){
        candidate = "";
        numVotes = 0;
    }
    
    public Election(String nm, int nVotes){
        candidate = nm;
        numVotes = nVotes;
    }
    
    public void setCandidate(String nm){
        candidate = nm;
    }
    
    public void setNumVotes(int nVotes){
        numVotes = numVotes;
    }
      
    public String toString(){
        String message = String.format("%-20s %-20d",candidate,numVotes);
        return message;
    }
    
    
    
}       //close the class
