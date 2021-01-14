package Client.Lists;


import Client.ClientApp;
import ObjectTemplate.Rental;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;


//@author Kratos
public class ListRentals extends javax.swing.JFrame {

    DefaultTableModel modelTableRen = new DefaultTableModel();

    static ClientApp client;
    
    public ListRentals() {
        super("Rentals");
        initComponents();
    }
    
    public ListRentals(ClientApp cli) {
        super("Rentals");
        initComponents();
        client = cli;
        
        modelTableRen  = (DefaultTableModel) tableRen.getModel();         //set model for customers table 
        
        ArrayList<Rental> renArray = new ArrayList<>();   //we get the list of customers from the server through a req
        
        Collections.sort(renArray, new Comparator<Rental>(){
            @Override
            public int compare(Rental t, Rental t1) {
                return t.getDateRental().compareToIgnoreCase(t1.getDateRental());
            };    
        });
        
        
        while(modelTableRen.getRowCount()>0){//removes all the rows in the table
            modelTableRen.removeRow(0);
        }       //end while
        populateCustomerTable(renArray);
        
    }
    
    
    //method to put customers in the table
    public void populateCustomerTable(ArrayList array){
        //go through the array
        for(int i=0; i<array.size(); i++){        
            Rental ren = (Rental) array.get(i);

            modelTableRen.insertRow(i, new Object[]{ren.getRentalNumber(), ren.getDateRental(), ren.getDateReturned(), ren.getTotalRental(), ren.getCustNumber(), ren.getVehNumber()});
        }
    
    }       //end populateTable();


    //This method to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screenPnl = new javax.swing.JPanel();
        renPnl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPnl.setBackground(new java.awt.Color(255, 204, 51));

        renPnl.setBackground(new java.awt.Color(255, 204, 51));
        renPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rentals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        tableRen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental Number", "Rental Date", "Date Returnedr", "Price Per Daty", "Total Price", "Customer Number", "Vehicle Number"
            }
        ));
        tableRen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tableRen);

        javax.swing.GroupLayout renPnlLayout = new javax.swing.GroupLayout(renPnl);
        renPnl.setLayout(renPnlLayout);
        renPnlLayout.setHorizontalGroup(
            renPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renPnlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        renPnlLayout.setVerticalGroup(
            renPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renPnlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout screenPnlLayout = new javax.swing.GroupLayout(screenPnl);
        screenPnl.setLayout(screenPnlLayout);
        screenPnlLayout.setHorizontalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(renPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        screenPnlLayout.setVerticalGroup(
            screenPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(renPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(ListRentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListRentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListRentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListRentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListRentals rentalPage = new ListRentals(client);
                rentalPage.setVisible(true);
            }
        });
    }

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel renPnl;
    private javax.swing.JPanel screenPnl;
    private javax.swing.JTable tableRen;
    // End of variables declaration//GEN-END:variables
}
