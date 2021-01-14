
package prac17_jdbc;

import java.sql.*;

public class MyDB {
    
    Connection conn;
    PreparedStatement pstmt;
    Statement stmt;
    
    String tableName = "Product";
    
    private String Col1 = "Catalogue_num";
    private String Col2 = "Item_Desc";
    private String Col3 = "Purchase_Price";
    private String Col4 = "Sell_Price";
    private String Col5 = "Quantity_Sold";
    private String Col6 = "inStock";

    //connect to the database
    public Connection connect(){
        
        try{
            String URL = "jdbc:ucanaccess://D:\\NetBeansProjects\\Prac17_JDBC\\Sales.mdb";
            System.out.println("About to connect...");
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established successfully");

        }       //end try
        catch(Exception ex){
            ex.getMessage();
        }       //end catch
        
        return conn;
    
    }       //end connect()
    
    public void createProductTable(){ 
        String create_Table_stmt = "create table "+tableName+" ("+Col1+" INTEGER," + Col2+" TEXT,"+ Col3+" DOUBLE,"+ Col4+" DOUBLE,"+ Col5+" INTEGER,"+ Col6+" BOOLEAN)";
    
        try{
            System.out.println("Creating statement argument...");
            stmt = conn.createStatement();
            System.out.println("Statement object created successfully");
            
            System.out.println("About to execute SQL stmt...");
            stmt.executeUpdate(create_Table_stmt);
            System.out.println("SQL statement executed successfully");
            
        }
        catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
        }       //end catch
    
    }        //end createSaleTable()
    
    
    public void insertValues(int catNo, String desc, double purchPr, double sellPr, int quantSold, boolean inStock){
        
        String insert_stmt = "insert into "+tableName+" ("+Col1+"," + Col2+","+ Col3+","+ Col4+","+ Col5+","+ Col6+") values(?,?,?,?,?,?)";
        
        try{
            System.out.println("About to execute insert prepared statement...");
            pstmt = conn.prepareStatement(insert_stmt);
            pstmt.setInt(1, catNo);
            pstmt.setString(2, desc);
            pstmt.setDouble(3, purchPr);
            pstmt.setDouble(4, sellPr);
            pstmt.setInt(5, quantSold);
            pstmt.setBoolean(6, inStock);
            pstmt.executeUpdate();                        
            System.out.println("Insert prepared statement executed successfully");
        }
        catch(Exception ex){
            ex.getMessage();
        }
   
    }        //end insertValues
    
    
    public void close(){
        try{
            System.out.println("About to close Statement....");
            stmt.close(); // close the Statement to let the database know we're done with it
            conn.close(); // close the Connection to let the database know we're done with it
            System.out.println("Statement closed successfully....");
        }
        catch(Exception ex){
            ex.getMessage();
        }       //end catch
    }       //end close
    
    
    
}       //end class
