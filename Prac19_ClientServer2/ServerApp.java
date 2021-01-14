
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp { 
    
    private ServerSocket listener;
    private Socket client;
    
    //Server parameters
    int portNum = 10111;
    int numCon = 5;
    
    //communication streams
    ObjectOutputStream output;
    ObjectInputStream input;

    //CD object 
    Cd cd;
    
    
    //instance of our database
    DatabaseHelper myDB = new DatabaseHelper();
    
    //method creates/opens up a server
    public void openServer(){
        try{
            listener = new ServerSocket(portNum, numCon);
        }
        catch(IOException ioe){
            System.out.println("openServer(): "+ioe.getMessage());
        }
    }       //end open()
    
    public void listen(){
        //listen for a client connection request
        int connections = 0;
        while(connections++<numCon){
            try{
                System.out.println("Server is listening");
                client = listener.accept();
                System.out.println("Moving to process the client");

                processClient();
            }
            catch(Exception ioe){
                System.out.println("listen(): "+ioe.getMessage());
            }
        }       //end while
        
    }      //end listen
    
    public void processClient(){
        try{
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());
            
            cd = (Cd)input.readObject();
            System.out.println("\nTHE OBJECT INFORMATION");
            System.out.println("Title: "+cd.getTitle());
            System.out.println("Artist: "+cd.getArtist());
            System.out.println("Price: "+cd.getPrice());
            System.out.println("Year: "+cd.getYearReleased());
            myDB.createTable();
            myDB.insertCd(cd);
        }
        catch(IOException ioe){
            System.out.println("processClient(): "+ioe.getMessage());
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("processClient(): "+cnfe.getMessage());
        }
    }       //end processClient
    
    
    public void closeConnection(){
        try{
            System.out.println("closing communication streams");
            output.close();
            input.close();
            System.out.println("closing client connection");
            client.close();
        }
        catch(IOException ioe){
            System.out.println("closeServer(): "+ioe.getMessage());
        }
    }
    
    
    public static void main(String[] args){
        ServerApp server = new ServerApp();
        server.openServer();
        server.listen();
    }        //end main
    
}       //end ServerApp class



