package com.its.prac;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    // Server socket
    private ServerSocket serverSocket;

    // Client connection
    private Socket client;

    /**
     * Creates a new instance of ServerApp
     */
    public ServerApp() {
        // Create server socket
        try {
            serverSocket = new ServerSocket(12345, 10);
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
    }

    public void listen() {
        // Start listening for client connections
        try {
            System.out.println("Server listening for Client...");
            client = serverSocket.accept();
            System.out.println("Client connected successfully!");

            processClient();
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
    }

    public void processClient() {
        // Communicate with the client

        // First step: initiate channels
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            // Step 2: communicate
            String msg = (String) in.readObject();

            while(!msg.equals("exit")){
                System.out.println("From CLIENT>> " + msg);
                out.writeObject("Hello " + msg);
                out.flush();

                msg = (String) in.readObject();
            }

            // Step 3:close down
            out.close();
            in.close();
            client.close();

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create application
        ServerApp server = new ServerApp();

        // Start waiting for connections
        server.listen();
    }       //end main()


}       //end class