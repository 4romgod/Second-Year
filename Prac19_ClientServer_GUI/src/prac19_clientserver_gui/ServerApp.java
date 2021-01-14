package prac19_clientserver_gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static prac19_clientserver_gui.ServerApp.TAG;

public class ServerApp extends Thread {

    public static final String TAG = "ServerApp: ";

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket client = null;

        int portNum = 10111;        //the port number   
        int numCon = 2;             //maximum connections allowed

        //instance of our database
        DatabaseHelper myDB = new DatabaseHelper();

        //create the server and open the database
        try {
            System.out.println(TAG + "Openning the server application...");
            server = new ServerSocket(portNum, numCon);
            System.out.println(TAG + "Server created! Initiating a Database connection...");
            myDB.connectionDb();
        } catch (IOException ioe) {
            System.out.println(TAG + ioe.getMessage());
        }

        //listen for mulitple client connections
        int connections = 0;
        while (connections++ < numCon) {
            try {
                System.out.println(TAG + "Server is listening for connection...");
                client = server.accept();
                System.out.println(TAG + "Client " + connections + " connected. Process client");
                System.out.println("----------------------------------------------------------");
            } catch (IOException ioe) {
                System.out.println(TAG + ioe.getMessage());
            }
            
            //process a client in a seperate thread
            System.out.println(TAG+"Creating a seperate thread for client");
            ClientProcessing clientThread = new ClientProcessing(client, myDB);
            clientThread.start();
        }       //end while()

    }        //end main

}       //end ServerApp class


class ClientProcessing extends Thread {

    protected Socket client = null;
    
    DatabaseHelper myDB = null;
    
    //communication streams
    ObjectOutputStream output;      //from server to client
    ObjectInputStream input;        //from client to server
 
    Cd cd;

    ClientProcessing(Socket sock, DatabaseHelper myBD) {
        this.client = sock;
        this.myDB = myDB;
    }

    public void run() {
        
        try {
            
            //process as many cliens as possible
            do {
                System.out.println(TAG + "Staring to process the client");
                output = new ObjectOutputStream(client.getOutputStream());
                output.flush();
                input = new ObjectInputStream(client.getInputStream());

                cd = (Cd) input.readObject();

                if (cd.getYearReleased() >= 2019) {
                    String message = "Recent CD";
                    output.writeObject(message);
                } else {
                    String message = "Old CD";
                    output.writeObject(message);
                }

//                System.out.println("CD found in database: "+myDB.searchFound(cd));
//                
//                System.out.println("\nTHE OBJECT INFORMATION");
//                System.out.println("Title: "+cd.getTitle());
//                System.out.println("Artist: "+cd.getArtist());
//                System.out.println("Price: "+cd.getPrice());
//                System.out.println("Year: "+cd.getYearReleased());
                //myDB.createTable();
                
                myDB.insertCd(cd);
            } while(true);
            
        } 
        catch (IOException ioe) {
            System.out.println("processClient() IOException: " + ioe.getMessage());
        } 
        catch (ClassNotFoundException cnfe) {
            System.out.println("processClient() ClassNotFoundException: " + cnfe.getMessage());
        }
                
    }       //end run()
    
    
    public void closeConnection() {
        try {
            System.out.println("closing communication streams...");
            output.close();
            input.close();

            System.out.println("Closing database connection...");
            myDB.closeDb();
            System.out.println("DB connection closed");

            System.out.println("closing client connection...");
            client.close();
            System.out.println("client connection closed");
        } 
        catch (IOException ioe) {
            System.out.println("closeServer(): " + ioe.getMessage());
        }
        
    }       //end closeConnection()

    
}       //end clientThread class


