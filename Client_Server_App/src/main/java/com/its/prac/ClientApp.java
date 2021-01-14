package com.its.prac;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    private Socket server;

    /**
     * Creates a new instance of ClientApp
     */
    public ClientApp() {
        // Attempt to establish connection to server
        try {
            // Create socket
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }
    }

    public void communicate() {
        // The connection has been established - now send/receive.

        Scanner input = new Scanner(System.in);

        try {
            // Step 1: create channels
            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            System.out.println("Enter message: ");
            String msg = input.next();

            while(!msg.equals("exit")){
                // Step 2: communicate
                out.writeObject(msg);
                out.flush();
                String response = (String) in.readObject();
                System.out.println("From SERVER>> " + response);

                System.out.println("Enter another message: ");
                msg = input.next();
            }

            // Step 3: close down
            out.close();
            in.close();
            server.close();
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
    }

    public static void main(String[] args) {
        ClientApp client = new ClientApp();
        client.communicate();
    }
}
