
package project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HomePage extends javax.swing.JFrame {
    
    Calendar now = new GregorianCalendar();

    public static DefaultTableModel modelTableItem;
    DefaultListModel modelListCart = new DefaultListModel();
    
    public ArrayList<FoodMenuItem> listCart = new ArrayList();        //items in the cart
    public static ArrayList<ArrayList> listSales = new ArrayList();        //stores array of cartItems
    
    public static ArrayList<Sale> saleArray = new ArrayList<>();        //contains objects of sale
        
    //constructor
    public HomePage() {
        initComponents();     
        modelTableItem  = (DefaultTableModel) menuTable.getModel();     //set model for menu table        
        cartList.setModel(modelListCart);       //set model for cartList   
        
        dateLbl.setText(now.get(Calendar.DATE)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR));
    }       //end constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        newItemBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        Sort = new javax.swing.JButton();
        addToCartBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboCategory = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        checkoutBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        reportItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));

        menuTable.setBackground(new java.awt.Color(204, 255, 204));
        menuTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Category", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(menuTable);

        jLabel1.setFont(new java.awt.Font("Informal Roman", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME TO KRISTERN FOOD BAZAR");

        newItemBtn.setText("New Item");
        newItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        Sort.setText("Sort");
        Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortActionPerformed(evt);
            }
        });

        addToCartBtn.setText("Add To Cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Category");

        jLabel2.setFont(new java.awt.Font("Informal Roman", 1, 18)); // NOI18N
        jLabel2.setText("MAIN MENU");

        comboCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select category", "starter", "drink", "main meal" }));
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        cartList.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane2.setViewportView(cartList);

        jLabel3.setFont(new java.awt.Font("Informal Roman", 1, 18)); // NOI18N
        jLabel3.setText("CART");

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        checkoutBtn.setText("Checkout");
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(newItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLbl)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(163, 163, 163))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newItemBtn)
                            .addComponent(deleteBtn)
                            .addComponent(Sort)
                            .addComponent(addToCartBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeBtn)
                            .addComponent(checkoutBtn))))
                .addContainerGap())
        );

        optionsMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        optionsMenu.setText("Options");
        optionsMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        reportItem.setText("Sales Report");
        reportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportItemActionPerformed(evt);
            }
        });
        optionsMenu.add(reportItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Removes an item from the cart
     * @param evt 
     */
    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
            int index = cartList.getSelectedIndex();
            
            if((listCart.size()>0)&&(cartList.getSelectedValue()!=null)){
                listCart.remove(index);
                modelListCart.remove(index);
            }
            else if((listCart.size()>0)&&(cartList.getSelectedValue() == null)){
                JOptionPane.showMessageDialog(null, "Select an Item to delete");
            }
            else if(listCart.size()<=0){
                JOptionPane.showMessageDialog(null, "No Items in the cart");
            }
    }//GEN-LAST:event_removeBtnActionPerformed

    //checkout button
    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        
        if(listCart.size()<=0){
            JOptionPane.showMessageDialog(null, "No items to checkout");
        }
        else if(listCart.size()>0){
            
            //saleList.add(cartItems);
            
            //to print and store each item sold
            String message = "";
            for(int i=0; i<listCart.size(); i++){
                FoodMenuItem item = listCart.get(i);       //item sold
                saleArray.add(new Sale(item, 1, item.getPrice()));      //add sales to saleArray
                message += listCart.get(i).toString()+"\n";
            }       //end for
            JOptionPane.showMessageDialog(null, message);

            listCart.clear();
            modelListCart.clear();                       
        }       //end else if(cartItems>0)
        
    }//GEN-LAST:event_checkoutBtnActionPerformed

    //combo box for categories
    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        
        //removes all the rows in the table
        while(modelTableItem.getRowCount()>0){
            modelTableItem.removeRow(0);
        }       //end while
        
        String categoryName = comboCategory.getSelectedItem().toString();       //gets name of the category
        for(int i=0; i<Project.foodItemList.size(); i++){
                
            FoodMenuItem item = Project.foodItemList.get(i);       //gets item from the list
            if(categoryName.equalsIgnoreCase(item.getCategory())){
                modelTableItem.insertRow(modelTableItem.getRowCount(), new Object[]{item.getFoodItem(), item.getCategory(), item.getPrice()});
            }
        }       //end for loop

    }//GEN-LAST:event_comboCategoryActionPerformed

    /**
     * Add new item to the menu of items
     * @param evt 
     */
    private void newItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemBtnActionPerformed
        AddItem addItem = new AddItem();
        addItem.setSize(460, 350);
        addItem.setLocationRelativeTo(null);
        addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addItem.setVisible(true);           
    }//GEN-LAST:event_newItemBtnActionPerformed

    /**
     * Delete item from the menu of items
     * @param evt 
     */
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = menuTable.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Select item to delete");
        }
        else{           
            String itemName = (modelTableItem.getValueAt(selectedRow, 0)).toString();

            modelTableItem.removeRow(selectedRow);      //first remove the row from the table

            //remove the item from the list of items
            for(int i=0; i<Project.foodItemList.size(); i++){
                FoodMenuItem item = Project.foodItemList.get(i);

                if(item.getFoodItem().equalsIgnoreCase(itemName)){
                    Project.foodItemList.remove(i);
                }       //end if

            }       //end for loop
        }       //end else
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    
    /**
     * Sort items in the menu according to the name of the item
     * @param evt 
     */
    private void SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortActionPerformed
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelTableItem);
        menuTable.setRowSorter(sorter);
        
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 0;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        //sorter.sort();
    }//GEN-LAST:event_SortActionPerformed

    /**
     * Add an item to the cart
     * @param evt 
     */
    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
    
        if(menuTable.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null, "No item selected");
        }
        else{
            int selectedRow = menuTable.getSelectedRow();
            
            String itemName = (modelTableItem.getValueAt(selectedRow, 0)).toString();
                        
            for(int i=0; i<Project.foodItemList.size(); i++){
                FoodMenuItem item = Project.foodItemList.get(i);

                if(item.getFoodItem().equalsIgnoreCase(itemName)){
                    listCart.add(item);        //add item to cart List of objects
                    modelListCart.addElement(item.toString());
                }       //end if
            
            }       //end for loop
        }       //end else
        
    }//GEN-LAST:event_addToCartBtnActionPerformed

    private void reportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportItemActionPerformed
        SaleReport report = new SaleReport();
        report.setSize(500, 400);
        report.setLocationRelativeTo(null);
        report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        report.setVisible(true);
    }//GEN-LAST:event_reportItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sort;
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JList cartList;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JComboBox comboCategory;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JTable menuTable;
    private javax.swing.JButton newItemBtn;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JButton removeBtn;
    private javax.swing.JMenuItem reportItem;
    // End of variables declaration//GEN-END:variables
}
