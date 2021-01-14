package Client.Insert;

import Client.ClientApp;
import Client.Lists.ListOutstandingRentals;
import ObjectTemplate.Rental;
import ObjectTemplate.Customer;
import ObjectTemplate.Vehicle;
import Utils.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//@author Kratos
public class FrameRent extends javax.swing.JFrame {
              
    DefaultTableModel modelTableCus = new DefaultTableModel();
    DefaultTableModel modelTableVeh = new DefaultTableModel();

    ArrayList<Customer> cusArray = new ArrayList<Customer>();//array of customers
    ArrayList<Vehicle> vehArray = new ArrayList<>();//array of vehicles
    
    //objects affected by rental
    Customer cusRen;
    Vehicle vehRen;
    Rental ren;
    
    static ClientApp client;
    
    
    public FrameRent() {
        super("Rent Vehicle");
        initComponents();
    }       //end RentFrame()
    
    
    public FrameRent(ClientApp cli) {
        super("Rent Vehicle");
        initComponents();
        
        this.client = cli;

        modelTableCus  = (DefaultTableModel) tableCustomers.getModel();         //set model for customers table 
        modelTableVeh  = (DefaultTableModel) tableVehicles.getModel();          //set model for vehicles table
        
        cusArray = (ArrayList<Customer>) client.communicate(Constants.GET+Constants.CUSTOMERS);   //we get the list of customers from the server through a req
        Collections.sort(cusArray, new Comparator<Customer>(){
            @Override
            public int compare(Customer t, Customer t1) {
                return t.getName().compareToIgnoreCase(t1.getName());
            };
            
        });
        
        
        //code to initialize the customers panel
        contentPnlTpd.setSelectedIndex(0);
        while(modelTableCus.getRowCount()>0){//removes all the rows in the table
            modelTableCus.removeRow(0);
        }       //end while
        populateCustomerTable(cusArray);

    }       //end RentFrame()

    
    
    //method to initialize the form. WARNING: Do NOT modify this code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPnl = new javax.swing.JPanel();
        contentPnlTpd = new javax.swing.JTabbedPane();
        chooseCusPnl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        btnPbl = new javax.swing.JPanel();
        lineSplit = new javax.swing.JLabel();
        cancelBtnCus = new javax.swing.JButton();
        saveBtnCus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        contentPnl1 = new javax.swing.JPanel();
        comboCat = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVehicles = new javax.swing.JTable();
        btnPbl1 = new javax.swing.JPanel();
        lineSplit1 = new javax.swing.JLabel();
        cancelBtnVeh = new javax.swing.JButton();
        saveBtnVeh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnPbl3 = new javax.swing.JPanel();
        lineSplit3 = new javax.swing.JLabel();
        cancelBtnRen = new javax.swing.JButton();
        saveBtnRen = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        surnameLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        phoneLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        canRentLbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        makeLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        catLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        availableLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        spinnerDays = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        spinnerDays1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        navPnl = new javax.swing.JPanel();
        navBtns = new javax.swing.JPanel();
        chooseVehBtn = new javax.swing.JButton();
        chooseCusBtn = new javax.swing.JButton();
        rentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 51));

        contentPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        contentPnlTpd.setBackground(new java.awt.Color(255, 235, 99));

        chooseCusPnl.setBackground(new java.awt.Color(255, 204, 51));
        chooseCusPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Customers"));

        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "ID Number", "Phone", "Can Rent"
            }
        ));
        tableCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tableCustomers);

        btnPbl.setBackground(new java.awt.Color(255, 204, 51));

        lineSplit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lineSplit.setText("|");

        cancelBtnCus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtnCus.setForeground(new java.awt.Color(51, 0, 255));
        cancelBtnCus.setText("CANCEL");
        cancelBtnCus.setContentAreaFilled(false);
        cancelBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnCusActionPerformed(evt);
            }
        });

        saveBtnCus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtnCus.setForeground(new java.awt.Color(51, 0, 255));
        saveBtnCus.setText("CONTINUE");
        saveBtnCus.setBorderPainted(false);
        saveBtnCus.setContentAreaFilled(false);
        saveBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnCusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPblLayout = new javax.swing.GroupLayout(btnPbl);
        btnPbl.setLayout(btnPblLayout);
        btnPblLayout.setHorizontalGroup(
            btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPblLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtnCus)
                .addGap(32, 32, 32)
                .addComponent(lineSplit)
                .addGap(32, 32, 32)
                .addComponent(saveBtnCus)
                .addContainerGap())
        );
        btnPblLayout.setVerticalGroup(
            btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineSplit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtnCus)
                    .addComponent(saveBtnCus))
                .addContainerGap())
        );

        javax.swing.GroupLayout chooseCusPnlLayout = new javax.swing.GroupLayout(chooseCusPnl);
        chooseCusPnl.setLayout(chooseCusPnlLayout);
        chooseCusPnlLayout.setHorizontalGroup(
            chooseCusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseCusPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseCusPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        chooseCusPnlLayout.setVerticalGroup(
            chooseCusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseCusPnlLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
        );

        contentPnlTpd.addTab("", chooseCusPnl);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        contentPnl1.setBackground(new java.awt.Color(255, 204, 51));

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
        jScrollPane3.setViewportView(tableVehicles);

        javax.swing.GroupLayout contentPnl1Layout = new javax.swing.GroupLayout(contentPnl1);
        contentPnl1.setLayout(contentPnl1Layout);
        contentPnl1Layout.setHorizontalGroup(
            contentPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPnl1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3))
                    .addComponent(comboCat, 0, 668, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        contentPnl1Layout.setVerticalGroup(
            contentPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnPbl1.setBackground(new java.awt.Color(255, 204, 51));

        lineSplit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lineSplit1.setText("|");

        cancelBtnVeh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtnVeh.setForeground(new java.awt.Color(51, 0, 255));
        cancelBtnVeh.setText("CANCEL");
        cancelBtnVeh.setContentAreaFilled(false);
        cancelBtnVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnVehActionPerformed(evt);
            }
        });

        saveBtnVeh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtnVeh.setForeground(new java.awt.Color(51, 0, 255));
        saveBtnVeh.setText("CONTINUE");
        saveBtnVeh.setBorderPainted(false);
        saveBtnVeh.setContentAreaFilled(false);
        saveBtnVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnVehActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPbl1Layout = new javax.swing.GroupLayout(btnPbl1);
        btnPbl1.setLayout(btnPbl1Layout);
        btnPbl1Layout.setHorizontalGroup(
            btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtnVeh)
                .addGap(28, 28, 28)
                .addComponent(lineSplit1)
                .addGap(36, 36, 36)
                .addComponent(saveBtnVeh)
                .addContainerGap())
        );
        btnPbl1Layout.setVerticalGroup(
            btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtnVeh)
                    .addComponent(saveBtnVeh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
            .addComponent(contentPnl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(contentPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPnlTpd.addTab("", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));

        btnPbl3.setBackground(new java.awt.Color(255, 204, 51));

        lineSplit3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lineSplit3.setText("|");

        cancelBtnRen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtnRen.setForeground(new java.awt.Color(51, 0, 255));
        cancelBtnRen.setText("CANCEL");
        cancelBtnRen.setContentAreaFilled(false);
        cancelBtnRen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnRenActionPerformed(evt);
            }
        });

        saveBtnRen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtnRen.setForeground(new java.awt.Color(51, 0, 255));
        saveBtnRen.setText("CONTINUE");
        saveBtnRen.setBorderPainted(false);
        saveBtnRen.setContentAreaFilled(false);
        saveBtnRen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnRenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPbl3Layout = new javax.swing.GroupLayout(btnPbl3);
        btnPbl3.setLayout(btnPbl3Layout);
        btnPbl3Layout.setHorizontalGroup(
            btnPbl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtnRen)
                .addGap(32, 32, 32)
                .addComponent(lineSplit3)
                .addGap(32, 32, 32)
                .addComponent(saveBtnRen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPbl3Layout.setVerticalGroup(
            btnPbl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPbl3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPbl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineSplit3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtnRen)
                    .addComponent(saveBtnRen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Surname");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("ID Number");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Phone");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("can rent");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLbl)
                    .addComponent(nameLbl)
                    .addComponent(idLbl)
                    .addComponent(canRentLbl)
                    .addComponent(phoneLbl))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(surnameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(canRentLbl))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehicle"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Make");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Category");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Rental Price");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Available");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(catLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(priceLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(availableLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(makeLbl))
                .addGap(153, 153, 153))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeLbl)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(catLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(priceLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableLbl)
                    .addComponent(jLabel10))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("From"));

        jLabel4.setText("Day:");

        jLabel12.setText("Month");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(spinnerDays, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSpinner1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Cost"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("R0.00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("From"));

        jLabel13.setText("Day:");

        jLabel14.setText("Month");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(spinnerDays1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSpinner2))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDays1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnPbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(btnPbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        contentPnlTpd.addTab("", jPanel3);

        javax.swing.GroupLayout contentPnlLayout = new javax.swing.GroupLayout(contentPnl);
        contentPnl.setLayout(contentPnlLayout);
        contentPnlLayout.setHorizontalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPnlTpd, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        contentPnlLayout.setVerticalGroup(
            contentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPnlTpd)
        );

        navPnl.setBackground(new java.awt.Color(255, 255, 255));
        navPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        navBtns.setBackground(new java.awt.Color(255, 255, 255));

        chooseVehBtn.setBackground(new java.awt.Color(255, 204, 51));
        chooseVehBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chooseVehBtn.setForeground(new java.awt.Color(255, 255, 255));
        chooseVehBtn.setText("Choose Vehicle");
        chooseVehBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseVehBtnActionPerformed(evt);
            }
        });

        chooseCusBtn.setBackground(new java.awt.Color(255, 204, 51));
        chooseCusBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chooseCusBtn.setForeground(new java.awt.Color(255, 255, 255));
        chooseCusBtn.setText("Choose Customer");
        chooseCusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCusBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navBtnsLayout = new javax.swing.GroupLayout(navBtns);
        navBtns.setLayout(navBtnsLayout);
        navBtnsLayout.setHorizontalGroup(
            navBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBtnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseCusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooseVehBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );
        navBtnsLayout.setVerticalGroup(
            navBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBtnsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(chooseCusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseVehBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        rentBtn.setBackground(new java.awt.Color(255, 204, 51));
        rentBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rentBtn.setForeground(new java.awt.Color(255, 255, 255));
        rentBtn.setText("Rent Vehicle");
        rentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPnlLayout = new javax.swing.GroupLayout(navPnl);
        navPnl.setLayout(navPnlLayout);
        navPnlLayout.setHorizontalGroup(
            navPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBtns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        navPnlLayout.setVerticalGroup(
            navPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPnlLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(navBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(rentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(navPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//-------------------------------------- ACTION PERFORMED -----------------------------------
    private void chooseCusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCusBtnActionPerformed
        contentPnlTpd.setSelectedIndex(0);

        //removes all the rows in the table
        while(modelTableCus.getRowCount()>0){
            modelTableCus.removeRow(0);
        }       //end while

        populateCustomerTable(cusArray);                   
    }//GEN-LAST:event_chooseCusBtnActionPerformed

    
    private void chooseVehBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseVehBtnActionPerformed
        contentPnlTpd.setSelectedIndex(1);
    }//GEN-LAST:event_chooseVehBtnActionPerformed

    
    private void cancelBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnCusActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtnCusActionPerformed

    
    private void saveBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnCusActionPerformed

        int selectedRow = tableCustomers.getSelectedRow();
        
        if(selectedRow >=0){
            String cusId = (modelTableCus.getValueAt(selectedRow, 2)).toString();
            
            for(int i=0; i<cusArray.size(); i++){
                if(cusId.equalsIgnoreCase(cusArray.get(i).getIdNum())){
                    cusRen = cusArray.get(i);
                    nameLbl.setText(cusRen.getName());
                    surnameLbl.setText(cusRen.getSurname());
                    idLbl.setText(cusRen.getIdNum());
                    phoneLbl.setText(cusRen.getPhoneNum());
                    canRentLbl.setText(cusRen.canRent()+"");
                }
            }

        }
        contentPnlTpd.setSelectedIndex(1);
       
    }//GEN-LAST:event_saveBtnCusActionPerformed

    
    private void comboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatActionPerformed

        //removes all the rows in the table
        while(modelTableVeh.getRowCount()>0){
            modelTableVeh.removeRow(0);
        }       //end while

        String categoryName = comboCat.getSelectedItem().toString();       //gets name of the category

        if(categoryName.equalsIgnoreCase(Constants.SEDAN)){
            //array of Vehicles
            vehArray = (ArrayList<Vehicle>) client.communicate(Constants.GET+Constants.VEHICLES+Constants.SEDAN);   //get all vehicles from the server 
            ArrayList<Vehicle> listFilter = filterVeh(Constants.SEDAN, vehArray);              //filter the vehicles by category
             
            Collections.sort(listFilter, new Comparator<Vehicle>(){
                @Override
                public int compare(Vehicle t, Vehicle t1) {
                    return t.getMake().compareToIgnoreCase(t1.getMake());
                };
            
            });

            populateVehicleTable(listFilter);
        }
        else if(categoryName.equalsIgnoreCase(Constants.SUV)){
            //array of customers
            
            vehArray = (ArrayList<Vehicle>) client.communicate(Constants.GET+Constants.VEHICLES+Constants.SUV);     //get all vehicles from the server 
            ArrayList<Vehicle> listFilter = filterVeh(Constants.SUV, vehArray);                 //filter the vehicles by category
            
            Collections.sort(listFilter, new Comparator<Vehicle>(){
                @Override
                public int compare(Vehicle t, Vehicle t1) {
                    return t.getMake().compareToIgnoreCase(t1.getMake());
                };
            
            });

            populateVehicleTable(listFilter);

        }       //end else if()

    }//GEN-LAST:event_comboCatActionPerformed

    
    private void cancelBtnVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnVehActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtnVehActionPerformed

     
    private void rentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentBtnActionPerformed
        contentPnlTpd.setSelectedIndex(2);
    }//GEN-LAST:event_rentBtnActionPerformed

    
    
    private void cancelBtnRenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnRenActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_cancelBtnRenActionPerformed

    
    //when client makes the rental by clicking continue on rental panel
    private void saveBtnRenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnRenActionPerformed
        Date date = new Date();                                 //date of the rental

        if(cusRen==null||vehRen==null){
            JOptionPane.showMessageDialog(null, "Choose vehicle and customer!");
        }
        else{
            ren = new Rental(date.toString(), cusRen.getCustomerNumber(), vehRen.getVehicleNumber());                               //send the rental object to the server
            dispose();
            
            //JOptionPane.showMessageDialog(null, "Date: "+date.toString()+"\nCustomer number: "+cusRen.getCustomerNumber()+"\nVehicle number: "+vehRen.getVehicleNumber());
            
            client.communicate(ren);

            ListOutstandingRentals rentalsOutPage = new ListOutstandingRentals(client);
            rentalsOutPage.setVisible(true);
            rentalsOutPage.setSize(800, 500);
            rentalsOutPage.setLocationRelativeTo(null);
            rentalsOutPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }//GEN-LAST:event_saveBtnRenActionPerformed

    private void saveBtnVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnVehActionPerformed
        
        int selectedRow = tableVehicles.getSelectedRow();
        
        if(selectedRow >=0){
            String make = (modelTableVeh.getValueAt(selectedRow, 0)).toString();
                        
            for(int i=0; i<vehArray.size(); i++){
                if(make.equalsIgnoreCase(vehArray.get(i).getMake())){
                    vehRen = vehArray.get(i);
                    
                    makeLbl.setText(vehRen.getMake());
                    catLbl.setText(vehRen.getCategory());
                    priceLbl.setText("R"+vehRen.getRentalPrice());
                    availableLbl.setText(vehRen.isAvailableForRent()+"");
                    
                }       //end if
            }       //end for

        }       //end if(selectedRow)
        
        contentPnlTpd.setSelectedIndex(2);
    }//GEN-LAST:event_saveBtnVehActionPerformed

//======================================== ACTION PERFORMED ==================================
    
    
    //method to put customers in the table
    public void populateCustomerTable(ArrayList array){
        //go through the array
        for(int i=0; i<array.size(); i++){        
            Customer cus = (Customer) array.get(i);

            modelTableCus.insertRow(i, new Object[]{cus.getName(), cus.getSurname(), cus.getIdNum(), cus.getPhoneNum(), cus.canRent()});
        }
    
    }       //end populateTable();
    
    
    //method to put vehicles in the table
    public void populateVehicleTable(ArrayList array){
        //go through the array
        for(int i=0; i<array.size(); i++){        
            Vehicle veh = (Vehicle) array.get(i);

            modelTableVeh.insertRow(i, new Object[]{veh.getMake(), veh.getCategory(), veh.getRentalPrice(), veh.isAvailableForRent()});
        }
    
    }       //end populateTable();
   
    
    //method to filter vehicle list
    public ArrayList<Vehicle> filterVeh(String cat, ArrayList<Vehicle> listVeh){
        ArrayList<Vehicle> list = new ArrayList<>();
        
        for(int i=0; i<listVeh.size(); i++){
            if(cat.equalsIgnoreCase(listVeh.get(i).getCategory())){
                list.add(listVeh.get(i));
            }
        }
        
        return list;
    }       ///end filterVeh()
    
    
    
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
            java.util.logging.Logger.getLogger(FrameRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameRent rentPage = new FrameRent();
                rentPage.setVisible(true);
            }
        });
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableLbl;
    private javax.swing.JPanel btnPbl;
    private javax.swing.JPanel btnPbl1;
    private javax.swing.JPanel btnPbl3;
    private javax.swing.JLabel canRentLbl;
    private javax.swing.JButton cancelBtnCus;
    private javax.swing.JButton cancelBtnRen;
    private javax.swing.JButton cancelBtnVeh;
    private javax.swing.JLabel catLbl;
    private javax.swing.JButton chooseCusBtn;
    private javax.swing.JPanel chooseCusPnl;
    private javax.swing.JButton chooseVehBtn;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JPanel contentPnl;
    private javax.swing.JPanel contentPnl1;
    private javax.swing.JTabbedPane contentPnlTpd;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lineSplit;
    private javax.swing.JLabel lineSplit1;
    private javax.swing.JLabel lineSplit3;
    private javax.swing.JLabel makeLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JPanel navBtns;
    private javax.swing.JPanel navPnl;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JButton rentBtn;
    private javax.swing.JButton saveBtnCus;
    private javax.swing.JButton saveBtnRen;
    private javax.swing.JButton saveBtnVeh;
    private javax.swing.JSpinner spinnerDays;
    private javax.swing.JSpinner spinnerDays1;
    private javax.swing.JLabel surnameLbl;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTable tableVehicles;
    // End of variables declaration//GEN-END:variables
}
