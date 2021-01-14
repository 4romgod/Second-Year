/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Julio Cesar Chaves
 */
public class Project {

    
    //declare the arrayList of foodItems  
    public static ArrayList<FoodMenuItem> foodItemList = new ArrayList<>();

    public static void main(String[] args) {
        setupGui();
        addDefaultItems();
    }       //end main()
    
    
    public static void setupGui(){
        HomePage guiHome = new HomePage();        
        guiHome.setSize(700, 500);
        guiHome.setLocationRelativeTo(null);
        guiHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiHome.setVisible(true);
    }       //end setupGui()
    
    
    public static void addDefaultItems(){
        foodItemList.add(new project.FoodMenuItem("Cheese burger", "main meal", 11.5, null));
        foodItemList.add(new project.FoodMenuItem("Gatsby", "main meal", 8.5, null));
        foodItemList.add(new project.FoodMenuItem("Cappuccino", "drink", 10.25, null));
        foodItemList.add(new project.FoodMenuItem("Hot wings", "starter", 6.0, null));
        foodItemList.add(new project.FoodMenuItem("Fish and chips", "main meal", 9.5, null));
        foodItemList.add(new project.FoodMenuItem("Coffee", "drink", 5, null));
        foodItemList.add(new project.FoodMenuItem("Calamari", "starter", 5.5, null));
    }       //end addDefaultItems()
}
