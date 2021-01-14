package Client;

import ObjectTemplate.Vehicle;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

//@author Kratos
public class ChooseVehiclePanel extends javax.swing.JPanel {
    
    DefaultTableModel modelTable = new DefaultTableModel();

    public ChooseVehiclePanel() {
        initComponents();
       
        modelTable  = (DefaultTableModel) tableVehicles.getModel();     //set model for customers table 

    }       //end constructor()

    
    //method to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPnl = new javax.swing.JPanel();
        comboCat = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVehicles = new javax.swing.JTable();
        btnPbl1 = new javax.swing.JPanel();
        lineSplit1 = new javax.swing.JLabel();
        cancelBtn1 = new javax.swing.JButton();
        saveBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 235, 99));

        contentPnl.setBackground(new java.awt.Color(255, 204, 51));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Category", "Sedan", "SUV" }));
        comboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCatActionPerformed(evt);
            }
        });

        tableVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Make", "Category", "Rental Price", "Available"
            }
        ));
        tableVehicles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tableVehicles);

        javax.swing.GroupLayout contentPnlLayout = new javax.swing.GroupLayout(contentPnl);
        contentPnl.setLayout(contentPnlLayout);
        contentPnlLayout.setHorizontalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPnlLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentPnlLayout.createSequentialGroup()
                        .addComponent(comboCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        contentPnlLayout.setVerticalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPbl1.setBackground(new java.awt.Color(255, 235, 99));

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
                .addGap(28, 28, 28)
                .addComponent(lineSplit1)
                .addGap(36, 36, 36)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //---------------------------------- ACTION PERFORMED ---------------------------------------
    private void comboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatActionPerformed
 
        //removes all the rows in the table
        while(modelTable.getRowCount()>0){
            modelTable.removeRow(0);
        }       //end while
         
        String categoryName = comboCat.getSelectedItem().toString();       //gets name of the category
        
        if(categoryName.equalsIgnoreCase("sedan")){      
            //array of customers
            ArrayList<Vehicle> vehArray = new ArrayList<>();        
            vehArray.add(new Vehicle("Audi A8", 1, 450, true));
            vehArray.add(new Vehicle("BMW 750iL", 1, 450, true));

            populateTable(vehArray);
        }
        else if(categoryName.equalsIgnoreCase("suv")){
            //array of customers
            ArrayList<Vehicle> vehArray = new ArrayList<>();        
            vehArray.add(new Vehicle("Audi A8", 1, 450, true));
            vehArray.add(new Vehicle("750iL", 2, 450, true));
            vehArray.add(new Vehicle("Cooper A8", 2, 450, true));
            vehArray.add(new Vehicle("Porshe 750iL", 1, 450, true));
             vehArray.add(new Vehicle("BMW A8", 2, 450, true));
            vehArray.add(new Vehicle("Benz 750iL", 1, 450, true));

            populateTable(filterCategory(categoryName, vehArray));
            
        }       //end else if()
       
    }//GEN-LAST:event_comboCatActionPerformed

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtn1ActionPerformed

    private void saveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn1ActionPerformed
  
    }//GEN-LAST:event_saveBtn1ActionPerformed

 //================================== ACTION PERFORMED ========================================
    
    
    //method to put vehicles in the table
    public void populateTable(ArrayList array){
        //go through the array
        for(int i=0; i<array.size(); i++){        
            Vehicle veh = (Vehicle) array.get(i);

            modelTable.insertRow(i, new Object[]{veh.getMake(), veh.getCategory(), veh.getRentalPrice(), veh.isAvailableForRent()});
        }
    
    }       //end populateTable();

    
    //filter array according to category
    public ArrayList<Vehicle> filterCategory(String cat, ArrayList<Vehicle> array){
        ArrayList<Vehicle> vehList = new ArrayList<>();
        
        for(int i=0; i<array.size(); i++){
            if(array.get(i).getCategory().equalsIgnoreCase(cat)){
                vehList.add(array.get(i));
            }       //end if
        }       //end for
        
        return vehList;
    }       //end filterCategory
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPbl1;
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JPanel contentPnl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lineSplit1;
    private javax.swing.JButton saveBtn1;
    private javax.swing.JTable tableVehicles;
    // End of variables declaration//GEN-END:variables
}
