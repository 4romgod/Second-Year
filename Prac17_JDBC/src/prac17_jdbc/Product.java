
package prac17_jdbc;

import java.io.Serializable;

public class Product implements Serializable{
    
    int catNum, quantSold;
    String desc;
    double purchPri, sellPri;
    boolean inStock;


    public Product(int catNum, String desc, double purchPri, double sellPri, int quantSold, boolean inStock) {
        this.catNum = catNum;
        this.quantSold = quantSold;
        this.desc = desc;
        this.purchPri = purchPri;
        this.sellPri = sellPri;
        this.inStock = inStock;
    }

    public int getCatNum() {
        return catNum;
    }

    public int getQuantSold() {
        return quantSold;
    }

    public String getDesc() {
        return desc;
    }

    public double getPurchPri() {
        return purchPri;
    }

    public double getSellPri() {
        return sellPri;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setCatNum(int catNum) {
        this.catNum = catNum;
    }

    public void setQuantSold(int quantSold) {
        this.quantSold = quantSold;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPurchPri(double purchPri) {
        this.purchPri = purchPri;
    }

    public void setSellPri(double sellPri) {
        this.sellPri = sellPri;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        double profit = (getSellPri()-getPurchPri())*getQuantSold();
        String message = String.format("%-20s R%-20.2f R%-20.2f %-20d R%.2f", getDesc(),getPurchPri(),getSellPri(),getQuantSold(), profit);

        return message;
    }
    
    
    
    
    
}
