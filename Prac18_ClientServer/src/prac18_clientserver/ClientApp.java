package prac18_clientserver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientApp extends JFrame implements ActionListener{
    //----------------------Create GUI components ----------------
    private JPanel topPnl = new JPanel();
    private JPanel centerPnl = new JPanel();
    private JPanel bottomPnl = new JPanel();
    
    private JLabel inputLbl = new JLabel("Input: ");
    private JTextField inputTxt = new JTextField(10);
    
    private JLabel textLbl = new JLabel("From Server: ");
    private JTextArea textArea = new JTextArea(10, 30); 
    
    //----------------------------variables-------------------------
    private Socket server;    
    ObjectOutputStream out;
    ObjectInputStream in;
    
    String toServer="";
    
    /** Creates a new instance of ClientApp */
    public ClientApp(){
        super("CLIENT APP");        
        openConnection();       //open connection to the server

        setLayout(new BorderLayout());
        topPnl.setLayout(new FlowLayout());
        bottomPnl.setLayout(new FlowLayout());
        
        topPnl.add(inputLbl);
        topPnl.add(inputTxt);
        bottomPnl.add(textLbl);
        bottomPnl.add(textArea);
        
        add(topPnl, BorderLayout.NORTH);
        add(bottomPnl, BorderLayout.CENTER);
        
        inputTxt.addActionListener(this);
    }       //end ClientApp() constructor
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==inputTxt){
            toServer = inputTxt.getText();
            communicate();
        }
    }       //end actionPerformed()
    
    
    public void openConnection(){
        // Attempt to establish connection to server
        try{
            // Create socket
            server = new Socket("127.0.0.1", 12345);
        }
        catch (IOException ioe){
            System.out.println("IOException: " + ioe.getMessage());
        }
    }      //end openConnection()
    
    
    public void communicate(){
        // The connection has been established - now send/receive. 
        try{        
            // Step 1: create channels
            out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            in = new ObjectInputStream(server.getInputStream());
            
            // Step 2: communicate
            out.writeObject(toServer);
            out.flush();
            inputTxt.setText("");
            
            String response = (String)in.readObject();
            textArea.append("From SERVER>> "+ response+"\n");
            
            if(response.equalsIgnoreCase("terminate")){
                close();
                System.exit(0);
            }
        }
        catch (IOException ioe){
            System.out.println("IO Exception: " + ioe.getMessage());
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Class not found: " + cnfe.getMessage());
        }
    }       //end communicate
    
    
    public void close(){
        // Step 3: close down
        try{
            System.out.println("TERMINATE THE COMMUNICATION STREAMS");
            out.close();
            in.close();
            System.out.println("TERMINATE THE SERVER CONNECTION");
            server.close();   
        }
        catch(IOException ioe){
            System.out.println("IO Exception: " + ioe.getMessage());
        }
    }     //end closeConnection()
    
      
    public static void main(String[] args){
        ClientApp client = new ClientApp();  
        client.setLocationRelativeTo(null);
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setSize(350,300);
        client.setVisible(true);
    }       //end main


}       //end class
