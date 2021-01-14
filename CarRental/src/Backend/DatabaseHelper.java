package Backend;

import ObjectTemplate.Rental;
import ObjectTemplate.Customer;
import ObjectTemplate.Vehicle;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseHelper {

    private static final String TAG = "DatabaseHelper: ";

    Connection con;
    String dbURL = "jdbc:ucanaccess://publisher.mdb";

    Statement stmt;
    PreparedStatement pstmt;

    //TABLE NAMES
    private String tableNameVehicle = "VEHICLE_TABLE";
    private String tableNameCustomer = "CUSTOMER_TABLE";
    private String tableNameRental = "RENTAL_TABLE";

    //COLUMNS FOR CUSTOMER TABLE
    String colCusNumber = "CUSTOMER_NUMBER";
    String colCusName = "FIRST_NAME";
    String colCusSurname = "SURNAME";
    String colCusID = "ID_NUMBER";
    String colCusPhone = "PHONE_NUMBER";
    String colCusCanRent = "CAN_RENT";

    //COLUMNS FOR VEHICLE TABLE
    String colVehNumber = "VEHICLE_NUMBER";
    String colVehMake = "MAKE";
    String colVehCat = "CATEGORY";
    String colVehRentPrice = "RENTAL_PRICE";
    String colVehAvailable = "AVAILABLE_FOR_RENT";

    //COLUMNS FOR RENTAL TABLE
    String colRentNumber = "RENTAL_NUMBER";
    String colRentDateRental = "DATE_RENTAL";
    String colRentDateReturn = "DATE_RETURNED";
    String colRentPrice = "PRICE_PER_DAY";
    String colRentTotRental = "TOTAL_RENTAL";
    String colRentCusNumber = "CUSTOMER_NUMBER";
    String colRentVehNum = "VEHICLE_NUMBER";

    //create database connection
    public void connectionDB() {
        try {
            System.out.println(TAG + "About to connect to DB...");
            con = DriverManager.getConnection(dbURL);
            con.setAutoCommit(true);
            System.out.println(TAG + "Connection to DB successful!");

            stmt = con.createStatement();
            System.out.println(TAG + "Statement initialized successfully");
        } catch (Exception ex) {
            System.out.println(TAG + "connectionDB(): " + ex.getMessage());
        }
    }        //end connectionDB()

    /**
     * Checks if a table already exists in the database
     * 
     * @param name  Takes the name of the table to be investigated
     * @return      Returns a true if table exist, and false if not
     */
    public Boolean tableAlreadyExist(String name) {
        try {
            ResultSet rs = con.getMetaData().getTables(null, null, "%", null);
            while (rs.next()) {
                if (rs.getString(3).equalsIgnoreCase(name)) {
                    return true;
                }
            }       //end while()
        } catch (Exception ex) {
            System.out.println(TAG + "checkTableExist(): " + ex.getMessage());
        }

        return false;
    }       //end checkTableExist()

    //method to create a customer table
    public void createTables() {

        String create_customer_table = "create table " + tableNameCustomer + " ("
                + colCusNumber + " AUTOINCREMENT PRIMARY KEY, " + colCusName + " TEXT, " + colCusSurname + " TEXT, "
                + colCusID + " TEXT, " + colCusPhone + " TEXT, " + colCusCanRent + " BOOLEAN)";

        String create_vehicle_table = "create table " + tableNameVehicle + " ("
                + colVehNumber + " AUTOINCREMENT PRIMARY KEY, " + colVehMake + " TEXT, " + colVehCat + " TEXT, "
                + colVehRentPrice + " FLOAT, " + colVehAvailable + " BOOLEAN)";

        String create_rental_table = "create table " + tableNameRental + " ("
                + colRentNumber + " AUTOINCREMENT PRIMARY KEY, " + colRentDateRental + " TEXT, " + colRentDateReturn + " TEXT  , "
                + colRentPrice + " FLOAT, " + colRentTotRental + " FLOAT, " + colRentCusNumber + " INTEGER, " + colRentVehNum + " INTEGER)";

        try {
            if (!tableAlreadyExist(tableNameCustomer)) {
                stmt.execute(create_customer_table);
                System.out.println(TAG + tableNameCustomer + " Created");
            } else {
                System.out.println(TAG + tableNameCustomer + " Already Exists");
            }

            if (!tableAlreadyExist(tableNameVehicle)) {
                stmt.execute(create_vehicle_table);
                System.out.println(TAG + tableNameVehicle + " Created");
            } else {
                System.out.println(TAG + tableNameVehicle + " Already Exists");
            }

            if (!tableAlreadyExist(tableNameRental)) {
                stmt.execute(create_rental_table);
                System.out.println(TAG + tableNameRental + " Created");
            } else {
                System.out.println(TAG + tableNameRental + " Already Exists");
            }
        } catch (Exception ex) {
            System.out.println("createTables(): " + ex.getMessage());
        }

    }      //end createCusTable

    //method to insert customer into the table
    public void insertCustomer(Customer cus) {
        String insert_stmt = "insert into " + tableNameCustomer + "(" + colCusNumber + ", " + colCusName + ", " + colCusSurname + ", " + colCusID + ", " + colCusPhone + ", " + colCusCanRent + ") values (?,?,?,?,?,?)";

        String search_stmt = "select " + colCusID + " from " + tableNameCustomer;

        try {
            ResultSet rs = stmt.executeQuery(search_stmt);

            //don't insert cus if ID already in DB
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(cus.getIdNum())) {
                    return;
                }
            }

            pstmt = con.prepareStatement(insert_stmt);
            pstmt.setInt(1, 1);
            pstmt.setString(2, cus.getName());
            pstmt.setString(3, cus.getSurname());
            pstmt.setString(4, cus.getIdNum());
            pstmt.setString(5, cus.getPhoneNum());
            pstmt.setBoolean(6, cus.canRent());
            pstmt.execute();
        } catch (Exception ex) {
            System.out.println(TAG + "insertCustomer(): " + ex.getMessage());
        }
    }       //end insertCustomer()

    //method to insert vehicle into the table
    public void insertVehicle(Vehicle veh) {
        String insert_stmt = "insert into " + tableNameVehicle + "(" + colVehNumber + ", " + colVehMake + ", " + colVehCat + ", " + colVehRentPrice + ", " + colVehAvailable + ") values (?,?,?,?,?)";
        String search_stmt = "select " + colVehMake + " from " + tableNameVehicle;

        try {
            ResultSet rs = stmt.executeQuery(search_stmt);

            //don't insert veh if Make already in DB
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(veh.getMake())) {
                    return;
                }
            }       //end while loop

            pstmt = con.prepareStatement(insert_stmt);
            pstmt.setInt(1, 1);
            pstmt.setString(2, veh.getMake());
            pstmt.setString(3, veh.getCategory());
            pstmt.setDouble(4, veh.getRentalPrice());
            pstmt.setBoolean(5, veh.isAvailableForRent());
            pstmt.execute();
        } catch (Exception ex) {
            System.out.println(TAG + "insertVehicle(): " + ex.getMessage());
        }

    }       //end insertVehicle()

    //method to insert rental into the table
    public void insertRental(Rental ren) {
        String insert_stmt = "insert into " + tableNameRental + "(" + colRentNumber + ", " + colRentDateRental + ", " + colRentCusNumber + ", " + colRentVehNum + ") values (?,?,?,?)";

        try {
            System.out.println(TAG + "about to insert rental");
            pstmt = con.prepareStatement(insert_stmt);
            pstmt.setInt(1, 1);
            pstmt.setString(2, ren.getDateRental());
//            pstmt.setString(3, "kdjfhnjk"); //ren.getDateReturned());
//            pstmt.setDouble(4, 10); //ren.getPricePerDay());
//            pstmt.setDouble(5, 50); //ren.getTotalRental());
            pstmt.setInt(3, ren.getCustNumber());
            pstmt.setInt(4, ren.getVehNumber());
            pstmt.execute();
            System.out.println(TAG + "rental inserted successfully!");
        } catch (Exception ex) {
            System.out.println(TAG + "insertRental(): " + ex.getMessage());
        }

    }       //end insertRental()

    //update a customer
    public void updateCustomer(Customer cus) {
        String update_stmt = "update " + tableNameCustomer + " set " + colCusCanRent + "=? where " + colCusNumber + "=?";

        Boolean canRent;
        if (cus.canRent() == true) {
            canRent = false;
        } else {
            canRent = true;
        }

        try {
            pstmt = con.prepareStatement(update_stmt);
            pstmt.setBoolean(1, canRent);
            pstmt.setInt(2, cus.getCustomerNumber());
            pstmt.executeUpdate();
            System.out.println("Customer updated!");
        } catch (Exception ex) {
            System.out.println(TAG + "updateCustomer(): " + ex.getMessage());
        }

    }       //end updateCustomer()

    /**
     * Updates a customer
     * @param veh Takes a Vehicle object in which to update
     */
    public void updateVehicle(Vehicle veh) {
        String update_stmt = "update " + tableNameVehicle + " set " + colVehAvailable + "=? where " + colVehNumber + "=?";

        Boolean available;
        if (veh.isAvailableForRent() == true) {
            available = false;
        } else {
            available = true;
        }

        try {
            pstmt = con.prepareStatement(update_stmt);
            pstmt.setBoolean(1, available);
            pstmt.setInt(2, veh.getVehicleNumber());
            pstmt.executeUpdate();
            System.out.println(TAG + "Vehicle updated!");
        } catch (Exception ex) {
            System.out.println(TAG + "updateCustomer(): " + ex.getMessage());
        }

    }       //end updateCustomer()

    /**
     * returns a List all the customers
     * 
     */
    public ArrayList getListCus() {
        ArrayList<Customer> listCus = new ArrayList();

        String all_customers = "select * from " + tableNameCustomer;

        try {
            ResultSet rs = stmt.executeQuery(all_customers);
            if (rs != null) {
                while (rs.next()) {
                    int cusNum = rs.getInt(1);
                    String fName = rs.getString(2);
                    String sName = rs.getString(3);
                    String idNum = rs.getString(4);
                    String phoneNum = rs.getString(5);
                    Boolean canRent = rs.getBoolean(6);

                    Customer cus = new Customer(cusNum, fName, sName, idNum, phoneNum, canRent);
                    listCus.add(cus);
                }
                return listCus;
            }
        } catch (Exception ex) {
            System.out.println(TAG + "allCustomers(): " + ex.getMessage());
        }
        return listCus;
    }           //end getListCus()

    //return list all Vehicle of selected category
    public ArrayList getListVeh() {
        ArrayList<Vehicle> listVeh = new ArrayList();

        String all_vehicles = "select * from " + tableNameVehicle;

        try {
            ResultSet rs = stmt.executeQuery(all_vehicles);

            if (rs != null) {
                while (rs.next()) {
                    int vehNum = rs.getInt(1);
                    String vehMake = rs.getString(2);

                    int vehCat;
                    if (rs.getString(3).equalsIgnoreCase("suv")) {
                        vehCat = 2;
                    } else {
                        vehCat = 1;
                    }

                    double rentPrice = rs.getDouble(4);
                    Boolean available = rs.getBoolean(5);

                    Vehicle veh = new Vehicle(vehNum, vehMake, vehCat, rentPrice, available);

                    listVeh.add(veh);
                }       //end while

                return listVeh;
            }       //end if

        } //end try
        catch (Exception ex) {
            System.out.println(TAG + "getListVeh(): " + ex.getMessage());
        }

        return listVeh;
    }      //end getListCat()

    //return list of all Rentals
    public ArrayList getListRen() {
        ArrayList<Rental> listRen = new ArrayList();

        String all_rentals = "select * from " + tableNameRental;

        try {
            ResultSet rs = stmt.executeQuery(all_rentals);

            if (rs != null) {
                while (rs.next()) {
                    int renNum = rs.getInt(1);

                    String renDate = rs.getString(2);
                    String renReturn = rs.getString(3);

                    double renPrice = rs.getDouble(4);
                    double totalPrice = rs.getDouble(5);

                    int renCusNum = rs.getInt(6);
                    int renVehNum = rs.getInt(7);
                    Vehicle veh = getVeh(renVehNum);

                    Rental ren = new Rental();

                    ren = new Rental(renNum, renDate, "", 0, renCusNum, renVehNum);

                    listRen.add(ren);
                }       //end while

                return listRen;
            }       //end if
        } //end try       //end try
        catch (Exception ex) {
            System.out.println(TAG + "getListVeh(): " + ex.getMessage());
        }

        return listRen;
    }      //end getListCat()

    //returns  customers for Id
    public Customer getCus(int cusNum) {
        String cus_stmt = "select * from " + tableNameCustomer;

        Customer cus = new Customer();
        try {
            ResultSet rs = stmt.executeQuery(cus_stmt);

            if (rs != null) {
                while (rs.next()) {
                    int cusNumber = rs.getInt(1);
                    String fName = rs.getString(2);
                    String sName = rs.getString(3);
                    String idNum = rs.getString(4);
                    String phoneNum = rs.getString(5);
                    Boolean canRent = rs.getBoolean(6);

                    cus = new Customer(fName, sName, idNum, phoneNum, canRent);
                    if (cusNum == cusNumber) {
                        return cus;
                    }
                }       //end while
            }
        } catch (Exception ex) {
            System.out.println(TAG + "getCus(): " + ex.getMessage());
        }

        return cus;
    }

    //returns  customers for Id
    public Vehicle getVeh(int vehNum) {
        String veh_stmt = "select * from " + tableNameVehicle;

        Vehicle veh = new Vehicle();
        try {
            ResultSet rs = stmt.executeQuery(veh_stmt);

            if (rs != null) {
                while (rs.next()) {
                    int vehNumber = rs.getInt(1);
                    String make = rs.getString(2);

                    String cat = rs.getString(3);

                    int category = 1;
                    if (cat.equalsIgnoreCase("sedan")) {
                        category = 1;
                    } else if (cat.equalsIgnoreCase("suv")) {
                        category = 2;
                    }

                    String price = rs.getString(4);
                    Boolean available = rs.getBoolean(5);

                    veh = new Vehicle(make, category, vehNum, available);

                    if (vehNum == vehNumber) {
                        return veh;
                    }
                }       //end while
            }       //end if
        } catch (Exception ex) {
            System.out.println(TAG + "getVeh(): " + ex.getMessage());
        }

        return veh;

    }       //end getVeh()

    //close connection to the database
    public void closeDB() {
        try {
            System.out.println("About to close Statement and con....");
            stmt.close();
            con.close();
            System.out.println("Statement and Con closed successfully....");
        } catch (Exception ex) {
            System.out.println(TAG + "closeDB(): " + ex.getMessage());
        }       //end catch

    }       //end closeDB

}       //END CLASS
