package Backend;

import ObjectTemplate.Customer;
import ObjectTemplate.Vehicle;
import Utils.Services;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerApp {

    private static final String TAG = "ServerApp: ";

    private ServerSocket SERVER;
    Socket CLIENT;

    int PORT_NUMBER = 12345;
    int NUM_CON = 10;

    //communication streams for the client and server
    ObjectOutputStream output;
    ObjectInputStream input;

    //database instance
    DatabaseHelper myDB = new DatabaseHelper();

    ArrayList<Customer> listCus = new ArrayList<>();
    ArrayList<Vehicle> listVeh = new ArrayList<>();

    /**
     * Opens the server through ServerSocket.
     * The server has a port number and number of allowed connections
     * 
     */
    public void openServer() {
        try {
            System.out.println(TAG + "About to open the server...");
            SERVER = new ServerSocket(PORT_NUMBER, NUM_CON);
            System.out.println(TAG + "Server is opened successfully.");

            myDB.connectionDB();
            myDB.createTables();

            System.out.println(TAG + "Done initializing the tables");
        } catch (IOException ioe) {
            System.out.println(TAG + "openServer(): " + ioe.getMessage());
        }
    }      //end openServer

    /*
    * Listenw for a client connection
    */
    public void listen() {

        int connections = 0;
        while (connections++ < NUM_CON) {
            try {
                System.out.println(TAG + "Listening for client to connect...");
                CLIENT = SERVER.accept();
                System.out.println(TAG + "Client is connected. Moving on to process Client...");
                System.out.println("----------------------------------------------------------");

            } catch (IOException ioe) {
                System.out.println(TAG + "listen(): " + ioe.getMessage());
            }

            //process a client in a seperate thread
            System.out.println(TAG + "Creating a seperate thread for client");
            ClientProcessing clientThread = new ClientProcessing(CLIENT, myDB);
            clientThread.start();

        }       //end while()

    }      //end listen

    //method to close server
    public void closeConnection() {
        try {
            System.out.println(TAG + "Closing Communication Streams...");
            output.close();
            input.close();
            System.out.println(TAG + "Streams Closed. Closing client connection...");
            CLIENT.close();
            myDB.closeDB();
        } catch (IOException ioe) {
            System.out.println(TAG + "closeConnection(): " + ioe.getMessage());
        }

    }     //end closeServer

    //MAIN METHOD
    public static void main(String[] args) {
        ServerApp server = new ServerApp();
        server.openServer();       //1.opens server: 2.connect to DB: 3.create Tables: 4.init Tables
        server.listen();
        System.exit(0);
    }       //end main()

}       //end class


//thread for proccessing a client
class ClientProcessing extends Thread {
    private static final String TAG = "ClientProcessing: ";

    protected Socket client = null;

    DatabaseHelper database = null;

    //communication streams
    ObjectOutputStream output;      //from server to client
    ObjectInputStream input;        //from client to server

    Object obj;

    ClientProcessing(Socket sock, DatabaseHelper myBD) {
        this.client = sock;
        this.database = myBD;

        try {
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());
        } catch (Exception ex) {
            System.out.println(TAG + "constructor(): "+ex.getMessage());
        }
        
    }       //end ClientProcessing()
    

    public void run() {

        try {
            //process as many cliens as possible
            do {
                System.out.println(TAG + "Staring to process the client");

                obj = input.readObject();

                if (obj instanceof String) {              //client made a get request
                    String request = obj.toString();

                    if (request.equalsIgnoreCase("exit")) {
                        System.out.println(TAG+"run(): client clicked on exit");
                        break;
                    } else {
                        Services.dataResponse(request, database, output);
                    }

                } else if (obj == null) {                    //unkonwn client request
                    //deal with null object
                } else {                                    //client made a post request
                    Services.insertToDB(obj, database, output);
                }

            } while (true);

        } 
        catch (IOException ioe) {
            System.out.println(TAG + "processClient() IOException: " + ioe.getMessage());
        } 
        catch (ClassNotFoundException cnfe) {
            System.out.println(TAG + "processClient() ClassNotFoundException: " + cnfe.getMessage());
        }

    }       //end run()

}       //end clientThread class

