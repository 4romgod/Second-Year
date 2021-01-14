package Client.Insert;

import Client.ClientApp;
import ObjectTemplate.Customer;
import Utils.Util;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;


public class FrameAddCustomer extends javax.swing.JFrame {

    String name="";
    String surname="";
    String id="";
    String phone="";
    Boolean canRent = false;
    
    Customer cus = new Customer();
        
    ClientApp client;
    
    
    public FrameAddCustomer() {
        super("Add Customer");
        initComponents();
    }       //end default Constructor()
    
    
    //client opens Frame, and gives it ClientApp object
    public FrameAddCustomer(ClientApp cli) {
        super("Add Customer");
        this.client=cli;
        
        initComponents();
    }       //end Constructor()
    

    //method  to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screenPnl = new javax.swing.JPanel();
        btnPbl = new javax.swing.JPanel();
        lineSplit = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        surnameTxt = new javax.swing.JTextField();
        idNumTxt = new javax.swing.JTextField();
        idNumLbl = new javax.swing.JLabel();
        fNameLbl = new javax.swing.JLabel();
        fNameTxt = new javax.swing.JTextField();
        phoneLbl = new javax.swing.JLabel();
        surnameLbl = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPnl.setBackground(new java.awt.Color(255, 204, 51));
        screenPnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPbl.setBackground(new java.awt.Color(255, 204, 51));

        lineSplit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lineSplit.setText("|");

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(51, 0, 255));
        cancelBtn.setText("CANCEL");
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(51, 0, 255));
        saveBtn.setText("SAVE");
        saveBtn.setBorderPainted(false);
        saveBtn.setContentAreaFilled(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPblLayout = new javax.swing.GroupLayout(btnPbl);
        btnPbl.setLayout(btnPblLayout);
        btnPblLayout.setHorizontalGroup(
            btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPblLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtn)
                .addGap(32, 32, 32)
                .addComponent(lineSplit)
                .addGap(32, 32, 32)
                .addComponent(saveBtn)
                .addContainerGap())
        );
        btnPblLayout.setVerticalGroup(
            btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineSplit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Details"));

        surnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTxtActionPerformed(evt);
            }
        });

        idNumTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumTxtActionPerformed(evt);
            }
        });
        idNumTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idNumTxtKeyTyped(evt);
            }
        });

        idNumLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        idNumLbl.setForeground(new java.awt.Color(255, 255, 255));
        idNumLbl.setText("ID Number");

        fNameLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        fNameLbl.setText("First Name");

        fNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTxtActionPerformed(evt);
            }
        });

        phoneLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phoneLbl.setForeground(new java.awt.Color(255, 255, 255));
        phoneLbl.setText("Phone");

        surnameLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        surnameLbl.setForeground(new java.awt.Color(255, 255, 255));
        surnameLbl.setText("Surname");

        phoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTxtActionPerformed(evt);
            }
        });
        phoneTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idNumTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(surnameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(surnameTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(phoneLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLbl)
                    .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLbl)
                    .addComponent(surnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumLbl)
                    .addComponent(idNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout screenPnlLayout = new javax.swing.GroupLayout(screenPnl);
        screenPnl.setLayout(screenPnlLayout);
        screenPnlLayout.setHorizontalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPnlLayout.createSequentialGroup()
                        .addComponent(btnPbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGap(20, 33, Short.MAX_VALUE))
        );
        screenPnlLayout.setVerticalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screenPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//--------------------------------------- ACTION PERFORMED -----------------------------------------
    //deacivates non-numeric 
    private void phoneTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTxtKeyTyped
        char key = evt.getKeyChar();
        
        if(!(Character.isDigit(key))||(key == KeyEvent.VK_BACKSPACE)||(key == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_phoneTxtKeyTyped

    
    private void phoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTxtActionPerformed
        
    }//GEN-LAST:event_phoneTxtActionPerformed

    
    //deacivates non-numeric 
    private void idNumTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idNumTxtKeyTyped
        char key = evt.getKeyChar();
        if(!(Character.isDigit(key))||(key == KeyEvent.VK_BACKSPACE)||(key == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_idNumTxtKeyTyped

    private void idNumTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumTxtActionPerformed
        try{
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Enter a valid ID number");
        }
    }//GEN-LAST:event_idNumTxtActionPerformed

    private void surnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTxtActionPerformed
        
    }//GEN-LAST:event_surnameTxtActionPerformed

    private void fNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameTxtActionPerformed
        
    }//GEN-LAST:event_fNameTxtActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed
        
    
    //validate, then send data to server
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        name = fNameTxt.getText().toString();
        surname = surnameTxt.getText().toString();
        id = idNumTxt.getText().toString();
        phone = phoneTxt.getText().toString();
        canRent = true;
        
        if(Util.isNull(name)||Util.isNull(surname)||Util.isNull(id)||Util.isNull(phone)){
            JOptionPane.showMessageDialog(null, "Enter valid details!");
        }
        else{
            cus = new Customer(name, surname, id, phone, canRent);
            client.communicate(cus);
            
            dispose();
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

//========================================== ACTION PERFORMED =====================================
    
    
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
            java.util.logging.Logger.getLogger(FrameAddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JLabel idNumLbl;
    private javax.swing.JTextField idNumTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lineSplit;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel screenPnl;
    private javax.swing.JLabel surnameLbl;
    private javax.swing.JTextField surnameTxt;
    // End of variables declaration//GEN-END:variables
}
