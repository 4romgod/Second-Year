package Utils;

import Backend.DatabaseHelper;
import ObjectTemplate.Customer;
import ObjectTemplate.Rental;
import ObjectTemplate.Vehicle;
import Backend.ServerApp;
import java.io.ObjectOutputStream;

public class Services {

    //post request
    public static void insertToDB(Object obj, DatabaseHelper myDB, ObjectOutputStream output) {

        try {
            if (obj instanceof Customer) {
                Customer cus = (Customer) obj;       //cast object
                myDB.insertCustomer(cus);
                output.writeObject("Server: customer object received!");
                output.flush();
            } 
            else if (obj instanceof Vehicle) {
                Vehicle veh = (Vehicle) obj;         //cast object
                myDB.insertVehicle(veh);
                output.writeObject("Server: Vehicle object received!");
                output.flush();
            } 
            else if (obj instanceof Rental) {
                Rental ren = (Rental) obj;                                   //make our received object a rental object
                System.out.println("server: received rental object");
                myDB.insertRental(ren);                                     //insert it into the database

                Customer cusUpd = (Customer) myDB.getCus(ren.getCustNumber());         //customer to update
                Vehicle vehUpd = (Vehicle) myDB.getVeh(ren.getVehNumber());           //vehicle to update

                myDB.updateCustomer(cusUpd);                                //update the customer table
                myDB.updateVehicle(vehUpd);                                 //update the vehicle table

                output.writeObject("Server: Rental object received!");      //confirm object receival
                output.flush();
            }

        } //end try
        catch (Exception ex) {
            System.out.println("Service: insertToDB(): " + ex.getMessage());
        }

    }       //end insertToDB()

    
    public static void dataResponse(String req, DatabaseHelper myDB, ObjectOutputStream output) {
        try {

            if (req.equalsIgnoreCase(Constants.GET+Constants.CUSTOMERS)) {                  //client asks for the list of customers
                output.writeObject(myDB.getListCus());                  //give client the list of customers
                output.flush();
            } 
            else if (req.equalsIgnoreCase(Constants.GET+Constants.VEHICLES+Constants.SUV)) {              //client asks for the list of vehicles
                output.writeObject(myDB.getListVeh());                  //give client the list of vehicles
                output.flush();
            } 
            else if (req.equalsIgnoreCase(Constants.GET+Constants.VEHICLES+Constants.SEDAN)) {
                output.writeObject(myDB.getListVeh());
                output.flush();
            } 
            else if (req.equalsIgnoreCase(Constants.GET+Constants.RENTALS)) {
                output.writeObject(myDB.getListRen());
                output.flush();
            }
            
        } 
        catch (Exception ex) {
            System.out.println("Service: dataResponse(): " + ex.getMessage());
        }

    }       //end dataResponse()

}       //end class
