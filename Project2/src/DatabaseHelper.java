
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DatabaseHelper{
    
    Connection con;
    String dbURL = "jdbc:ucanaccess://publisher.mdb";
    
    Statement stmt;
    PreparedStatement pstmt;
    
    
    private String tableNameVehicle = "VEHICLE_TABLE";
    private String tableNameCustomer = "CUSTOMER_TABLE";
    private String tableNameRental = "RENTAL_TABLE";
    
    //COLUMNS FOR CUSTOMER TABLE
    String customerCol1 = "CUSTOMER_NUMBER";
    String customerCol2 = "FIRST_NAME";
    String customerCol3 = "SURNAME";
    String customerCol4 = "ID_NUMBER";
    String customerCol5 = "PHONE_NUMBER";
    String customerCol6 = "CAN_RENT";
    
    //COLUMNS FOR VEHICLE TABLE
    String vehicleCol1 = "VEHICLE_NUMBER";
    String vehicleCol2 = "MAKE";
    String vehicleCol3 = "CATEGORY";
    String vehicleCol4 = "RENTAL_PRICE";
    String vehicleCol5 = "AVAILABLE_FOR_RENT";
    
    //COLUMNS FOR RENTAL TABLE
    String rentalCol1 = "RENTAL_NUMBER";
    String rentalCol2 = "DATE_RENTAL";
    String rentalCol3 = "DATE_RETURNED";
    String rentalCol4 = "PRICE_PER_DAY";
    String rentalCol5 = "TOTAL_RENTAL";
    String rentalCol6 = "CUSTOMER_NUMBER";
    String rentalCol7 = "VEHICLE_NUMBER";
    
    
    //checks if a table already exists in the database
    public Boolean checkTableExist(String name){
        try{
            ResultSet rs = con.getMetaData().getTables(null, null, "%", null);    
            while(rs.next()){
                if(rs.getString(3).equalsIgnoreCase(name)){
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println("checkTableExist(): "+ex.getMessage());
        }
        
        return false;
    }       //end checkTableExist()
    
    
    //create database connection
    public void connectionDB(){   
        try{
            System.out.println("About to connect to DB...");
            con = DriverManager.getConnection(dbURL);
            con.setAutoCommit(true);
            System.out.println("Connection to DB successful");
            
            stmt = con.createStatement();
            System.out.println("Statement initialized successfully");
        }
        catch(Exception ex){
            System.out.println("connectionDB(): "+ex.getMessage());
        }
    }        //end connectionDB()
    
    
    //method to create a customer table
    public void createTables(){
//        
//        String dropCustomerTable = "drop table "+tableNameCustomer;
//        String dropVehicleTable = "drop table "+tableNameVehicle;
//        String dropRentalTable = "drop table "+tableNameRental;

        String create_customer_table = "create table "+tableNameCustomer+ " ("+
                customerCol1+" AUTOINCREMENT PRIMARY KEY, "+customerCol2+" TEXT, "+customerCol3+" TEXT, "+
                customerCol4+" TEXT, "+customerCol5+" TEXT, "+customerCol6+" BOOLEAN)";
        
        String create_vehicle_table = "create table "+tableNameVehicle+ " ("+
                vehicleCol1+" AUTOINCREMENT PRIMARY KEY, "+vehicleCol2+" TEXT, "+vehicleCol3+" TEXT, "+
                vehicleCol4+" FLOAT, "+vehicleCol5+" BOOLEAN)";
        
        String create_rental_table = "create table "+tableNameRental+ " ("+
                rentalCol1+" AUTOINCREMENT PRIMARY KEY, "+rentalCol2+" TEXT, "+rentalCol3+" TEXT  , "+
                rentalCol4+" FLOAT, "+rentalCol5+" FLOAT, "+rentalCol6+" INTEGER, "+rentalCol7+" INTEGER)";
        
        try{
            if(!checkTableExist(tableNameCustomer)){
                stmt.execute(create_customer_table);
                System.out.println(tableNameCustomer+" Created");
            }
            else{
                System.out.println(tableNameCustomer + " Already Exists");
            }
            
            if(!checkTableExist(tableNameVehicle)){
                stmt.execute(create_vehicle_table);
                System.out.println(tableNameVehicle+" Created");

            }            
            else{
                System.out.println(tableNameVehicle + " Already Exists");
            }
            
            if(!checkTableExist(tableNameRental)){
                stmt.execute(create_rental_table);
                System.out.println(tableNameRental+" Created");
            }            
            else{
                System.out.println(tableNameRental + " Already Exists");
            }
        }
        catch(Exception ex){
            System.out.println("createTables(): "+ex.getMessage());
        }
        
    }      //end createCusTable
    
    
    //method to insert customer into the table
    public void insertCustomer(Customer cus){
        String insert_stmt = "insert into "+tableNameCustomer+ "("+customerCol1+", "+customerCol2+", "+customerCol3+", "+customerCol4+", "+customerCol5+", "+customerCol6+") values (?,?,?,?,?,?)";
        
        String search_stmt = "select "+customerCol4+" from "+tableNameCustomer;
        
        try{
            ResultSet rs = stmt.executeQuery(search_stmt);
            
            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(cus.getIdNum())){
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
        }
        catch(Exception ex){
            System.out.println("insertCustomer(): "+ex.getMessage());
        }
    
    }
    
    //method to insert vehicle into the table
    public void insertVehicle(Vehicle veh){
        String insert_stmt = "insert into "+tableNameVehicle+ "("+vehicleCol1+", "+vehicleCol2+", "+vehicleCol3+", "+vehicleCol4+", "+vehicleCol5+") values (?,?,?,?,?)";               
        String search_stmt = "select "+vehicleCol2+" from "+tableNameVehicle;    
        
        try{        
            ResultSet rs = stmt.executeQuery(search_stmt);

            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(veh.getMake())){
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
        }
        catch(Exception ex){
            System.out.println("insertVehicle(): "+ex.getMessage());
        }
    
    }
    
        //method to insert rental into the table
    public void insertRental(Rental ren){
        String insert_stmt = "insert into "+tableNameRental+ "("+rentalCol1+", "+rentalCol2+", "+rentalCol6+", "+rentalCol7+") values (?,?,?,?)";               
        
        try{            
            System.out.println("about to insert rental");
            pstmt = con.prepareStatement(insert_stmt);
            pstmt.setInt(1, 1);
            pstmt.setString(2, ren.getDateRental());
//            pstmt.setString(3, "kdjfhnjk"); //ren.getDateReturned());
//            pstmt.setDouble(4, 10); //ren.getPricePerDay());
//            pstmt.setDouble(5, 50); //ren.getTotalRental());
            pstmt.setInt(3, ren.getCustNumber());
            pstmt.setInt(4, ren.getVehNumber());
            pstmt.execute();
            System.out.println("rental inserted successfully!");
        }
        catch(Exception ex){
            System.out.println("insertRental(): "+ex.getMessage());
        }
    
    }
    
    
    //update a customer
    public void updateCustomer(Customer cus){
        String update_stmt = "update "+tableNameCustomer+" set "+customerCol6+"=? where "+customerCol1+"=?";
        
        Boolean canRent;
        if(cus.canRent()==true){
            canRent=false;
        }
        else{
            canRent=true;
        }
        
        try{
            pstmt = con.prepareStatement(update_stmt);
            pstmt.setBoolean(1, canRent);
            pstmt.setInt(2, cus.getCustomerNumber());
            pstmt.executeUpdate();
            System.out.println("Customer updated!");
        }
        catch(Exception ex){
            System.out.println("updateCustomer(): "+ex.getMessage());
        }
    
    }       //end updateCustomer()
    
        //update a customer
    public void updateVehicle(Vehicle veh){
        String update_stmt = "update "+tableNameVehicle+" set "+vehicleCol5+"=? where "+vehicleCol1+"=?";
        
        Boolean available;
        if(veh.isAvailableForRent()==true){available=false;}
        else{available=true;}
        
        try{
            pstmt = con.prepareStatement(update_stmt);
            pstmt.setBoolean(1, available);
            pstmt.setInt(2, veh.getVehicleNumber());
            pstmt.executeUpdate();
            System.out.println("Vehicle updated!");
        }
        catch(Exception ex){
            System.out.println("updateCustomer(): "+ex.getMessage());
        }
    
    }       //end updateCustomer()
    
    
    
    //returns List all customers
    public ArrayList getListCus(){
        ArrayList<Customer> listCus = new ArrayList();
        String all_customers = "select * from "+tableNameCustomer;
        try{
            ResultSet rs = stmt.executeQuery(all_customers);
            if(rs != null){
                while(rs.next()){
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
        }
        catch(Exception ex){
            System.out.println("allCustomers(): "+ex.getMessage());
        }
        return listCus;
    }
    
    //return list all Vehicle of selected category
    public ArrayList getListVeh(){
        ArrayList<Vehicle> listVeh = new ArrayList();
        String all_vehicles = "select * from "+tableNameVehicle;
        
        try{
            ResultSet rs = stmt.executeQuery(all_vehicles);
//            pstmt.setString(1, cat);
//            pstmt.execute();
            if(rs != null){
                while(rs.next()){
                    int vehNum = rs.getInt(1);
                    
                    String vehMake = rs.getString(2);
                    
                    int vehCat;
                    if(rs.getString(3).equalsIgnoreCase("suv")){
                         vehCat=2;
                    }
                    else{vehCat = 1;}
                    
                    double rentPrice = rs.getDouble(4);
                    Boolean available = rs.getBoolean(5);

                    Vehicle veh = new Vehicle(vehNum, vehMake, vehCat, rentPrice, available);
                    
                    listVeh.add(veh);
                }       //end while
                
                return listVeh;
            }       //end if
        }       //end try
        catch(Exception ex){
            System.out.println("getListVeh(): "+ex.getMessage());
        }
        
        return listVeh;
    }      //end getListCat()
    
    
        //return list all Vehicle of selected category
    public ArrayList getListRen(){
        ArrayList<Rental> listRen = new ArrayList();
        String all_rentals = "select * from "+tableNameRental;
        
        try{
            ResultSet rs = stmt.executeQuery(all_rentals);

            if(rs != null){
                while(rs.next()){
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
        }       //end try       //end try
        catch(Exception ex){
            System.out.println("getListVeh(): "+ex.getMessage());
        }
        
        return listRen;
    }      //end getListCat()
    
    
    
    //returns  customers for Id
    public Customer getCus(int cusNum){
        String cus_stmt = "select * from "+tableNameCustomer;
        
        Customer cus = new Customer();
        try{
            ResultSet rs = stmt.executeQuery(cus_stmt);
            
            if(rs != null){
                while(rs.next()){
                    int cusNumber = rs.getInt(1);
                    String fName = rs.getString(2);
                    String sName = rs.getString(3);
                    String idNum = rs.getString(4);
                    String phoneNum = rs.getString(5);
                    Boolean canRent = rs.getBoolean(6);

                    cus = new Customer(fName, sName, idNum, phoneNum, canRent);
                    if(cusNum==cusNumber){
                        return cus;
                    }
                }       //end while
            }
        }
        catch(Exception ex){
            System.out.println("getCus(): "+ex.getMessage());
        }
        
        return cus;
    }
    
    
    //returns  customers for Id
    public Vehicle getVeh(int vehNum){
        String veh_stmt = "select * from "+tableNameVehicle;
        
        Vehicle veh = new Vehicle();
        try{
            ResultSet rs = stmt.executeQuery(veh_stmt);
            
            if(rs != null){
                while(rs.next()){
                    int vehNumber = rs.getInt(1);
                    String make = rs.getString(2);

                    String cat = rs.getString(3);

                    int category=1;
                    if(cat.equalsIgnoreCase("sedan")){
                        category = 1;
                    }
                    else if(cat.equalsIgnoreCase("suv")){
                        category = 2;
                    }

                    String price = rs.getString(4);
                    Boolean available = rs.getBoolean(5);

                    veh = new Vehicle(make, category, vehNum, available);

                    if(vehNum==vehNumber){
                        return veh;
                    }
                }       //end while
            }       //end if
        }
        catch(Exception ex){
            System.out.println("getVeh(): "+ex.getMessage());
        }
        
        return veh;
    }
    
    

    //close connection to the database
    public void closeDB(){
        try{
            System.out.println("About to close Statement and con....");
            stmt.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            System.out.println("Statement and Con closed successfully....");
        }
        catch(Exception ex){
            ex.getMessage();
        }       //end catch
    }       //end closeDB
    
}       //END CLASS
