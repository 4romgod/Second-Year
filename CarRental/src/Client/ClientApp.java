package Client;

import Client.Insert.FrameRent;
import Client.Insert.FrameAddVehicle;
import Client.Insert.FrameAddCustomer;
import Client.Lists.ListCustomersFrame;
import Client.Lists.ListOutstandingRentals;
import Client.Lists.ListRentals;
import ObjectTemplate.Customer;
import ObjectTemplate.Vehicle;
import Utils.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ClientApp extends javax.swing.JFrame {
    
    private static final String TAG = "ClientApp: ";

    Socket SERVER;
    String IP_ADDRESS;
    int PORT_NUMBER;

    //communication streams
    ObjectOutputStream output;
    ObjectInputStream input;

    static ClientApp client;

    //list of customers and vehicles from server
    ArrayList<Customer> arrayAllCus;
    ArrayList<Vehicle> arrayAllVeh;
    
    String[] images = {"car1.jpg", "car2.jpg", "car3.jpg"};

    int pos = 0;
    
    public ClientApp() {
        super("Car Pilots");
        super.setUndecorated(true);

        initComponents();

        //set the images on home page 
        Util.setIconImage(picLbl, images[1]);
        
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Util.setIconImage(picLbl, images[pos]);
                pos +=1;
                if(pos>= images.length){
                    pos=0;
                }
            }
        });
        timer.start();
        
    }       //end constructor()
    

    //-------------------------------------------- SERVER COMMUNICATION ----------------------------------------------
    //connect to the server
    public void connectServer() {
        IP_ADDRESS = "127.0.0.1";
        PORT_NUMBER = 12345;

        try {
            System.out.println(TAG+"openning a connection to the server...");
            SERVER = new Socket(IP_ADDRESS, PORT_NUMBER);
            System.out.println(TAG+"Connected to server!");
            System.out.println(TAG+"Creating communication streams...");
            output = new ObjectOutputStream(SERVER.getOutputStream());
            output.flush();
            input = new ObjectInputStream(SERVER.getInputStream());
            System.out.println(TAG+"Communication streams created successfully!");
        } catch (IOException ioe) {
            System.out.println(TAG+"openConnection(): " + ioe.getMessage());
        }

    }       //end connectServer()

    /**
     * Takes an object and writes it to the server
     * It then receives input from the server, then returns it
     * 
     * @param obj   Object to write to the server
     * @return      Returns an object response from the server
     * @see         Object
     */
    public Object communicate(Object obj) {

        try {
            //send object to the server
            System.out.println(TAG+"Sending an object to the server...");
            output.writeObject(obj);
            output.flush();
            System.out.println(TAG+"Object sent successfully");

            //get the response to the server
            System.out.println(TAG+"Waiting for server response...");
            Object objReceived = input.readObject();
            System.out.println(TAG+"Server responded successfully!");

            return objReceived;
        } catch (Exception e) {
            System.out.println(TAG+"communicate(): " + e.getMessage());
        }

        return "nothing received from server!";
    }     //end communicate

    //method to close the connection()
    public void closeConnection() {
        if (SERVER != null) {
            try {
                System.out.println(TAG+"closing communication streams");
                output.close();
                input.close();
                System.out.println(TAG+"closing connection to server");
                SERVER.close();
            } catch (IOException ioe) {
                System.out.println(TAG+"closeConnection(): " + ioe.getMessage());
            }
        }
    }       //end closeConnection

    //method  to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        screenPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlSlideshow = new javax.swing.JPanel();
        pnlVehicle = new javax.swing.JPanel();
        titleVehicle = new javax.swing.JLabel();
        titleMake = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        picLbl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAddCustomer = new javax.swing.JMenuItem();
        addVehicleItm = new javax.swing.JMenuItem();
        rentVehicleItm = new javax.swing.JMenuItem();
        itemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemCustomers = new javax.swing.JMenuItem();
        itemRentals = new javax.swing.JMenuItem();
        itemOutRental = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem5.setText("jMenuItem5");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPnl.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("CarPilots");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Rent a Vehicle for the Lowest Prizes!");

        pnlSlideshow.setBackground(new java.awt.Color(255, 204, 51));

        pnlVehicle.setBackground(new java.awt.Color(255, 255, 255));
        pnlVehicle.setPreferredSize(new java.awt.Dimension(70, 100));

        titleVehicle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleVehicle.setText("Audi S6");

        titleMake.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleMake.setText("Sedan");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setPreferredSize(new java.awt.Dimension(132, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("From R450");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(picLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlVehicleLayout = new javax.swing.GroupLayout(pnlVehicle);
        pnlVehicle.setLayout(pnlVehicleLayout);
        pnlVehicleLayout.setHorizontalGroup(
            pnlVehicleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVehicleLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(pnlVehicleLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addGroup(pnlVehicleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleVehicle)
                    .addComponent(titleMake, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        pnlVehicleLayout.setVerticalGroup(
            pnlVehicleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVehicleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleMake)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleVehicle)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSlideshowLayout = new javax.swing.GroupLayout(pnlSlideshow);
        pnlSlideshow.setLayout(pnlSlideshowLayout);
        pnlSlideshowLayout.setHorizontalGroup(
            pnlSlideshowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlideshowLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(pnlVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        pnlSlideshowLayout.setVerticalGroup(
            pnlSlideshowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlideshowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout screenPnlLayout = new javax.swing.GroupLayout(screenPnl);
        screenPnl.setLayout(screenPnlLayout);
        screenPnlLayout.setHorizontalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPnlLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSlideshow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(screenPnlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2)))
                .addGap(72, 72, 72))
        );
        screenPnlLayout.setVerticalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(pnlSlideshow, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Tasks");

        itemAddCustomer.setText("Add Customer");
        itemAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddCustomerActionPerformed(evt);
            }
        });
        jMenu1.add(itemAddCustomer);

        addVehicleItm.setText("Add Vehicle");
        addVehicleItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicleItmActionPerformed(evt);
            }
        });
        jMenu1.add(addVehicleItm);

        rentVehicleItm.setText("Rent Vehicle");
        rentVehicleItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentalItmActionPerformed(evt);
            }
        });
        jMenu1.add(rentVehicleItm);

        itemExit.setText("EXIT");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        jMenu1.add(itemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        itemCustomers.setText("Customers");
        itemCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCustomersActionPerformed(evt);
            }
        });
        jMenu2.add(itemCustomers);

        itemRentals.setText("Rentals");
        itemRentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRentalsActionPerformed(evt);
            }
        });
        jMenu2.add(itemRentals);

        itemOutRental.setText("Outstanding Rentals");
        itemOutRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOutRentalActionPerformed(evt);
            }
        });
        jMenu2.add(itemOutRental);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screenPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//=========================================== SERVER COMMUNICATION ====================================

    
    
    //-------------------------------------------- SERVER COMMUNICATION ----------------------------------------------
    private void addVehicleItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicleItmActionPerformed
        System.out.println(TAG + "add vehicle frame");
        FrameAddVehicle addVehPage = new FrameAddVehicle(client);
        addVehPage.setVisible(true);
        addVehPage.setSize(455, 320);
        addVehPage.setLocationRelativeTo(null);
        addVehPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_addVehicleItmActionPerformed


    private void addRentalItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRentalItmActionPerformed
        System.out.println(TAG + "add rental frame");
        FrameRent rentPage;
        
        if(SERVER != null){
            rentPage = new FrameRent(client);
        }
        else{
            rentPage = new FrameRent();
        }
        rentPage.setVisible(true);
        rentPage.setSize(965, 580);
        rentPage.setLocationRelativeTo(null);
        rentPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_addRentalItmActionPerformed


    private void itemCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCustomersActionPerformed
        System.out.println(TAG + "list customers frame");
        ListCustomersFrame custOutPage;
        
        if(SERVER != null){
            custOutPage = new ListCustomersFrame(client);
        }
        else{
            custOutPage = new ListCustomersFrame();
        }
        custOutPage.setVisible(true);
        custOutPage.setSize(620, 500);
        custOutPage.setLocationRelativeTo(null);
        custOutPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemCustomersActionPerformed

    private void itemOutRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOutRentalActionPerformed
        System.out.println(TAG + "list outstanding rentals frame");
        ListOutstandingRentals rentalsOutPage;
        
        if(SERVER != null){
            rentalsOutPage = new ListOutstandingRentals(client);
        }
        else{
            rentalsOutPage = new ListOutstandingRentals();
        }
        rentalsOutPage.setVisible(true);
        rentalsOutPage.setSize(800, 500);
        rentalsOutPage.setLocationRelativeTo(null);
        rentalsOutPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_itemOutRentalActionPerformed

    private void itemRentalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRentalsActionPerformed
        System.out.println(TAG + "list rentals frame");
        ListRentals rentalsPage;
        
        if(SERVER != null){
            rentalsPage = new ListRentals(client);
        }
        else{
            rentalsPage = new ListRentals();
        }
        rentalsPage.setVisible(true);
        rentalsPage.setSize(820, 500);
        rentalsPage.setLocationRelativeTo(null);
        rentalsPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_itemRentalsActionPerformed

    private void itemAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddCustomerActionPerformed
        System.out.println(TAG + "add customer frame");
        FrameAddCustomer addCustPage = new FrameAddCustomer(client);
        addCustPage.setVisible(true);
        addCustPage.setSize(420, 380);
        addCustPage.setLocationRelativeTo(null);
        addCustPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_itemAddCustomerActionPerformed

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        //client.communicate("exit");
        client.closeConnection();
        System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed

//=========================================== ACTION PERFORMED ====================================
    //MAIN METHOD
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                client = new ClientApp();
                client.setSize(965, 600);
                client.setLocationRelativeTo(null);
                client.setVisible(true);

                client.connectServer();
            }
        });
    }       //end main()


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addVehicleItm;
    private javax.swing.JMenuItem itemAddCustomer;
    private javax.swing.JMenuItem itemCustomers;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemOutRental;
    private javax.swing.JMenuItem itemRentals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel picLbl;
    private javax.swing.JPanel pnlSlideshow;
    private javax.swing.JPanel pnlVehicle;
    private javax.swing.JMenuItem rentVehicleItm;
    private javax.swing.JPanel screenPnl;
    private javax.swing.JLabel titleMake;
    private javax.swing.JLabel titleVehicle;
    // End of variables declaration//GEN-END:variables
}       //end class
