
package project;

import java.util.*;


public class FoodMenuItem {
    
    String foodItem, category;
    double price;
    Sale saleInfo;
    
    public FoodMenuItem(){
        foodItem = "";
        category = "";
        price = 0;
        saleInfo = null;
    }

    public FoodMenuItem(String foodItem, String category, double price, Sale saleInfo) {
        setFoodItem(foodItem);
        setCategory(category);
        setPrice(price);
        setSaleInfo(saleInfo);
    }
    
    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Sale getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(Sale saleInfo) {
        this.saleInfo = saleInfo;
    }

    @Override
    public String toString() {
        return foodItem + " (" + category +")  R" + price;
    }
    

}       //end class
