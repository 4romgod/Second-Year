package prac18_clientserver;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ServerApp{
    private ServerSocket listener;  // Server socket
    private Socket client;      // Client connection
    
    ObjectOutputStream out;
    ObjectInputStream in;
    
    public void open(){
        // Create server socket
        try {
            listener = new ServerSocket(12345, 10); //Specify port number and number of clients
        }
        catch (IOException ioe){
          System.out.println("open: IO Exception: " + ioe.getMessage());
        }
    }        //end open()
    
    
    public void listen(){
        // Start listening for client connections
        
        try {
            System.out.println("Server is listening");
            client = listener.accept();  
            System.out.println("Now moving onto processClient");

            processClient();
        }
        catch(IOException ioe){
            System.out.println("listen: IO Exception: " + ioe.getMessage());
        }
    }       //end listen()
    
    
    public void processClient(){        // Communicate with the client
        // First step: initiate channels
        try {
            String msg;
            
            do{
                out = new ObjectOutputStream(client.getOutputStream());      //outputs objects to client input
                out.flush();
                in = new ObjectInputStream(client.getInputStream());      //inputs objects from client output

                // Step 2: communicate
                msg = (String)in.readObject();
                msg = msg.toUpperCase();
                System.out.println("From CLIENT>> " + msg);
                out.writeObject(msg);
                out.flush(); 
            }while(!msg.equalsIgnoreCase("terminate"));
            
        }
        catch (IOException ioe){
            System.out.println("processClient: IO Exception: " + ioe.getMessage());
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("processClient: Class not found: " + cnfe.getMessage());
        }
    }       //end processClient()
    
    public void close(){
        // Step 3:close down
        try{
            System.out.println("TERMINATE COMMUNICATION STREAMS");
            out.close();
            in.close();
            System.out.println("TERMINATE THE CLIENT CONNECTION");
            client.close();    
        }
        catch(IOException ioe){
            System.out.println("close: IO Exception: " + ioe.getMessage());
        }
    }       //end close
  
    
    public static void main(String[] args){
        ServerApp server = new ServerApp();     // Create application
        server.open();
        server.listen();    // Start waiting for connections
        server.close();
    }       //end main()  
    
}       //end class 
