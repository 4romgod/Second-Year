package com.its.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_DerbyApp {

    public static void main(String[] args) {
        String create_Table_stmt = "create table TESTIP2 (Employee_ID     INTEGER, Name VARCHAR(30))";
        String insert_Values_stmt = "insert into TESTIP2 values   (250,'Mary Smith')";
        String update_Values_stmt = "UPDATE TESTIP2 SET NAME='PEGGY'      WHERE Employee_ID=150";
        String delete_Values_stmt = "DELETE FROM TESTIP2 WHERE    Employee_ID =   250";
        String retrieve_Values_qry = "SELECT * FROM TESTIP2";

        try {
            String dbURL = "jdbc:derby://localhost:1527/c:/Radford/adp262s-2017/MyTestDB.mdb;create=true";
            String driverName = "org.apache.derby.jdbc.ClientDriver";
//        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";

            System.out.println("About to Load the JDBC Driver....");
            Class.forName(driverName).newInstance();
            System.out.println("Driver Loaded Successfully....");
            System.out.println("About to get a connection....");
            Connection con = DriverManager.getConnection(dbURL, "", "");
            System.out.println("Connection Established Successfully....");
            // create a java.sql.Statement so we can run queries
            System.out.println("Creating statement Object....");
            Statement s = con.createStatement();
            System.out.println("Statement object created Successfully....");

            System.out.println("About to execute SQL stmt....");
            s.executeUpdate(create_Table_stmt); // execute the SQL statement
//        ResultSet rs = s.executeQuery(retrieve_Values_qry); // select the data from the table
//        if (rs != null){ // if rs == null, then there is no ResultSet to view
//            System.out.println("************************** ");
//            while ( rs.next() ) // this will step through our data row-by-row
//            {
//                System.out.println("Data from columns: "
//                + rs.getString(1) + " "+rs.getString(2) );
//             }//end while
//            System.out.println("************************** ");
//         }//end if
            System.out.println("SQL statement executed  Successfully....");

            System.out.println("About to close Statement....");
            s.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            System.out.println("Statement closed successfully....");
        }
        catch (Exception err) {
            System.out.println("ERROR: " + err);
        }

    }       //end main()

}       //end class
