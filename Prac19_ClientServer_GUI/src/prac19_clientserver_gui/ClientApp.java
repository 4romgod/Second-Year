package prac19_clientserver_gui;


import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ClientApp extends javax.swing.JFrame implements ActionListener{
    
    public static final String TAG = "ClientApp: ";
    
    Socket server;
    String ip;
    int portNum;
    
    //communication streams
    ObjectOutputStream output;
    ObjectInputStream input;

    //object of CD
    Cd cdInit = new Cd("Police Story", "Jackie Chan", 150, 2005);
    Cd cd = new Cd();
    
    String title = "";
    String artist = "";
    double price = 0;
    String priceString="";
    int year = 2019;
    
    static ClientApp clientApp;
    
    public ClientApp() {
        initComponents();
        addBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            
            if(!((verify(titleTxtF, title).equals(""))||(verify(artistTxtF, artist).equals(""))||(verify(priceTxtF, priceString).equals("")))){

                title = verify(titleTxtF,title);
                artist = verify(artistTxtF, artist);
                price = Double.parseDouble(verify(priceTxtF, priceString)); 
                year = 2019; 
      
                cd = new Cd(title, artist, price, year);
                clientApp.communicate(cd);
                
                System.out.println("Title: "+title);
                System.out.println("Artist: "+artist);
                System.out.println("Price: "+price);
                
                System.out.println("----------------------------------------------------------");
                
                clientApp.setVisible(false);        //dispose the GUI
                
                //asks client to continue or not
                int input = JOptionPane.showConfirmDialog(null, "Enter Another Movie?","Continue?", JOptionPane.YES_NO_OPTION);     
                
                if(input == 0){
                    System.out.println(TAG+"Continuing...");
                    clientApp.setVisible(true);
                }
                else if(input == 1){
                    System.out.println(TAG+"Finish the Client App");
                    clientApp.closeConnection();
                    System.exit(0);
                }       //end else if

            }       //end if
        }       //end if(getSource == addBtn)
        else if(e.getSource() == cancelBtn){        //function for cancelBtn
            System.out.println(TAG+"Finish the Client App");
            clientApp.closeConnection();
            System.exit(0);     
        }       //end if(getSource == cancelBtn
        
    }       //end actionPerformed
    
    
    public String verify(JTextField txtF, String txt){
        if(txtF.getText().equals(null)||txtF.getText().equals("")){
            txtF.setBackground(Color.red);
            txt = "";
            return "";
        }
        else{
            txtF.setBackground(Color.white);
            txt = txtF.getText();
            return txt;
        }
    }      //end verify
    
    
    //opent a connection to server
    public void openConnection(){
        ip="127.0.0.1";
        portNum=10111;
        
        try{
            System.out.println(TAG+"Openning a connection to the server...");
            server = new Socket(ip, portNum);
            System.out.println(TAG+"Connected to the server!");
        }
        catch(IOException ioe){
            System.out.println(TAG+"openConnection(): "+ioe.getMessage());
        }
        
        System.out.println("----------------------------------------------------------");
        
    }       //end openConnection()
    
    
    public void communicate(Cd cd){
        try{
            output = new ObjectOutputStream(server.getOutputStream());
            output.flush();
            input = new ObjectInputStream(server.getInputStream());
            
            //send cd object to the server
            System.out.println(TAG+"Sending an object to the server...");
            output.writeObject(cd);
            output.flush();
            System.out.println(TAG+"Object sent successfully");
            
            String message = (String)input.readObject();
            JOptionPane.showMessageDialog(null, message);
        }
        catch(Exception e){
            System.out.println(TAG+"communicate(): "+e.getMessage());
        }
    }     //end communicate
    
    
    public void closeConnection(){
        try{
            System.out.println(TAG+"Closing communication streams");
            output.close();
            input.close();
            System.out.println(TAG+"Closing connection to server...");
            server.close();
            System.out.println(TAG+"Connection to server is closed!");
            System.out.println("----------------------------------------------------------");
        }
        catch(IOException ioe){
            System.out.println(TAG+"closeConnection(): "+ioe.getMessage());
        }
    }       //end closeConnection

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        titleTxtF = new javax.swing.JTextField();
        artistLbl = new javax.swing.JLabel();
        artistTxtF = new javax.swing.JTextField();
        priceLbl = new javax.swing.JLabel();
        priceTxtF = new javax.swing.JTextField();
        yearLbl = new javax.swing.JLabel();
        yearComboB = new javax.swing.JComboBox<String>();
        cancelBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLbl.setText("Title");

        artistLbl.setText("Artist");

        artistTxtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistTxtFActionPerformed(evt);
            }
        });

        priceLbl.setText("Price");

        priceTxtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTxtFActionPerformed(evt);
            }
        });
        priceTxtF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceTxtFKeyTyped(evt);
            }
        });

        yearLbl.setText("Year");

        yearComboB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cancelBtn.setText("cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addBtn.setText("ADD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addGap(28, 28, 28)
                                .addComponent(addBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(artistLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(artistTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLbl)
                            .addComponent(yearLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearComboB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(290, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLbl)
                    .addComponent(titleTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLbl)
                    .addComponent(artistTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLbl)
                    .addComponent(priceTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLbl)
                    .addComponent(yearComboB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addBtn))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artistTxtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistTxtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_artistTxtFActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void priceTxtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTxtFActionPerformed

    }//GEN-LAST:event_priceTxtFActionPerformed

    private void priceTxtFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTxtFKeyTyped
        char key = evt.getKeyChar();
        if(!(Character.isDigit(key))||(key == KeyEvent.VK_BACKSPACE)||(key == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_priceTxtFKeyTyped

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
                clientApp = new ClientApp();
                clientApp.setVisible(true);
                clientApp.openConnection();
            }
        });
        
        //client.openConnection();

    }       //end main
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel artistLbl;
    private javax.swing.JTextField artistTxtF;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxtF;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextField titleTxtF;
    private javax.swing.JComboBox<String> yearComboB;
    private javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables


    
}       //end class
