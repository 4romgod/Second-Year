package prac19_clientserver_gui;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {
    
    public static final String TAG = "DatabaseHelper: ";
    
    Connection con;
    String dbUrl = "jdbc:ucanaccess://C:\\publisher.mdb";
    
    //create statements
    Statement stmt;
    PreparedStatement pstmt;
    
    //table variables
    String tableName = "Movies";
    String col1 = "TITLE";
    String col2 = "ARTIST";
    String col3 = "PRICE";
    String col4 = "YEAR";
    
    //connect to the Microsoft Access database
    public void connectionDb(){
        try{
            System.out.println(TAG+"About to connect to databse...");
            con = DriverManager.getConnection(dbUrl);
            System.out.println(TAG+"Connection successful");
            
            System.out.println(TAG+"About to create statement...");
            stmt = con.createStatement();
            System.out.println(TAG+"Statement created succefully");
        }
        catch(Exception ex){
            System.out.println(TAG+"connectionDb(): "+ex.getMessage());
        }
        
        System.out.println("----------------------------------------------------------");
        
    }      //end connectionDb    
    
    //create the movies table
    public void createTable(){  
        String create_table_stmt = "create table "+tableName+" ("+col1+" TEXT, "+ col2+" TEXT, "+col3+" DOUBLE, "+col4+" INTEGER)";
        
        try{
            System.out.println(TAG+"About to execute SQL create statement...");
            stmt.executeUpdate(create_table_stmt);
            System.out.println(TAG+"Table created statement successful");
        }
        catch(Exception ex){
            System.out.println(TAG+"createTable(): "+ex.getMessage());
        }       //end processDb
        
        System.out.println("----------------------------------------------------------");

    }     //end processDb   
    
    //method to insert data into table
    public void insertCd(Cd cd){  
        String insert_stmt = "insert into "+tableName+"("+col1+", "+col2+", "+col3+", "+col4+") values(?,?,?,?)";
        
        try{
            System.out.println(TAG+"About to INSERT row using prepared statement...");
            pstmt = con.prepareStatement(insert_stmt);
            pstmt.setString(1, cd.getTitle());
            pstmt.setString(2, cd.getArtist());
            pstmt.setDouble(3, cd.getPrice());
            pstmt.setInt(4, cd.getYearReleased());
            pstmt.execute();        //actually executes the insertion statement
            System.out.println(TAG+"Insertion successful");
        }
        catch(Exception ex){
            System.out.println(TAG+"insertCd(): "+ex.getMessage());
        }
        
        System.out.println("----------------------------------------------------------");

    }       //end insert movie   
    
    //method to search the databse
    public Boolean searchFound(Cd cd){
        String query_stmt = "select * from "+tableName;
        
        try{
            System.out.println(TAG+"Executing SELECT Query...");
            ResultSet rs = stmt.executeQuery(query_stmt);
            System.out.println(TAG+"SELECT Query successful");
            
            if(rs!=null){
                while(rs.next()){
                    if(cd.getTitle().equalsIgnoreCase(rs.getString(1))){
                        return true;
                    }
                    
                }       //end while
            }       //end if  
        
        }
        catch(Exception ex){
            System.out.println(TAG+"searchDB(): "+ex.getMessage());
        }
        
        return false;

    }       //end searchDB()
    
    //close connection to the database
    public void closeDb(){
        try{
            System.out.println(TAG+"About to close Statement and con....");
            stmt.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            System.out.println(TAG+"Statement and Con closed successfully....");
        }
        catch(Exception ex){
            ex.getMessage();
        }       //end catch
        
        System.out.println("----------------------------------------------------------");

    }       //end closeDB
    
}       //end class
