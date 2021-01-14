package Client.Insert;


import Client.ClientApp;
import ObjectTemplate.Vehicle;
import Utils.Constants;
import javax.swing.JOptionPane;

public class FrameAddVehicle extends javax.swing.JFrame {

    String make="";
    int cat=0;
    double price=0;
    
    Vehicle veh = new Vehicle();
    
    ClientApp client;
    
    public FrameAddVehicle() {
        super("Add Vehicle");
        initComponents();
    }

    public FrameAddVehicle(ClientApp cli) {
        super("Add Vehicle");
        initComponents();
        
        this.client=cli;
    }
    
    
    //method to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screenPnl = new javax.swing.JPanel();
        contentPnl = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        makeTxt = new javax.swing.JTextField();
        makeLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboCat = new javax.swing.JComboBox();
        btnPbl1 = new javax.swing.JPanel();
        lineSplit1 = new javax.swing.JLabel();
        cancelBtn1 = new javax.swing.JButton();
        saveBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPnl.setBackground(new java.awt.Color(255, 204, 51));

        contentPnl.setBackground(new java.awt.Color(255, 204, 51));

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Make", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        makeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeTxtActionPerformed(evt);
            }
        });

        makeLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        makeLbl.setForeground(new java.awt.Color(255, 255, 255));
        makeLbl.setText("Make");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(makeTxt)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeLbl)
                    .addComponent(makeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        comboCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Category", "Sedan", "SUV" }));
        comboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPbl1.setBackground(new java.awt.Color(255, 204, 51));

        lineSplit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lineSplit1.setText("|");

        cancelBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn1.setForeground(new java.awt.Color(51, 0, 255));
        cancelBtn1.setText("CANCEL");
        cancelBtn1.setContentAreaFilled(false);
        cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn1ActionPerformed(evt);
            }
        });

        saveBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtn1.setForeground(new java.awt.Color(51, 0, 255));
        saveBtn1.setText("SAVE");
        saveBtn1.setBorderPainted(false);
        saveBtn1.setContentAreaFilled(false);
        saveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPbl1Layout = new javax.swing.GroupLayout(btnPbl1);
        btnPbl1.setLayout(btnPbl1Layout);
        btnPbl1Layout.setHorizontalGroup(
            btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtn1)
                .addGap(32, 32, 32)
                .addComponent(lineSplit1)
                .addGap(32, 32, 32)
                .addComponent(saveBtn1)
                .addContainerGap())
        );
        btnPbl1Layout.setVerticalGroup(
            btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn1)
                    .addComponent(saveBtn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPnlLayout = new javax.swing.GroupLayout(contentPnl);
        contentPnl.setLayout(contentPnlLayout);
        contentPnlLayout.setHorizontalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPnlLayout.createSequentialGroup()
                .addGroup(contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPnlLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        contentPnlLayout.setVerticalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout screenPnlLayout = new javax.swing.GroupLayout(screenPnl);
        screenPnl.setLayout(screenPnlLayout);
        screenPnlLayout.setHorizontalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(contentPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        screenPnlLayout.setVerticalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(contentPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
            .addComponent(screenPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//--------------------------------------- ACTION PERFORMED -----------------------------------------
    private void makeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeTxtActionPerformed

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtn1ActionPerformed

    private void saveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn1ActionPerformed

        make = makeTxt.getText().toString();
        
        String category = comboCat.getSelectedItem().toString();

        if(category.equalsIgnoreCase(Constants.SEDAN)){
            cat = 1;
        }
        else if(category.equalsIgnoreCase(Constants.SUV)){
            cat = 2;
        }
        else{
            JOptionPane.showMessageDialog(null, "Select a category!");
        }

                             
        if(cat==1 || cat==2){
            veh = new Vehicle(make, cat);
            client.communicate(veh);
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter valid details!");
        }

    }//GEN-LAST:event_saveBtn1ActionPerformed

    private void comboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatActionPerformed
        String category = comboCat.getSelectedItem().toString();
    }//GEN-LAST:event_comboCatActionPerformed

    //======================================== ACTION PERFORMED ===================================
    
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
            java.util.logging.Logger.getLogger(FrameAddVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAddVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAddVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAddVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPbl1;
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JPanel contentPnl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lineSplit1;
    private javax.swing.JLabel makeLbl;
    private javax.swing.JTextField makeTxt;
    private javax.swing.JButton saveBtn1;
    private javax.swing.JPanel screenPnl;
    // End of variables declaration//GEN-END:variables
}
