
package prac15_serialization;

import java.io.Serializable;

public class Product implements Serializable{
    int prodType;
    String prodDescription;
    int prodSellPrice;
    int prodQuantity;

    public Product() {
        prodType = 0;
        prodDescription = "";
        prodSellPrice = 0;
        prodQuantity = 0;
    }

    public Product(int prodType, String prodDescription, int prodSellPrice, int prodQuantity) {
        this.prodType = prodType;
        this.prodDescription = prodDescription;
        this.prodSellPrice = prodSellPrice;
        this.prodQuantity = prodQuantity;
    }

    public void setProdType(int prodType) {
        this.prodType = prodType;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public void setProdSellPrice(int prodSellPrice) {
        this.prodSellPrice = prodSellPrice;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public int getProdType() {
        return prodType;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public int getProdSellPrice() {
        return prodSellPrice;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "prodType=" + prodType + ", prodDescription=" + prodDescription + ", prodSellPrice=" + prodSellPrice + ", prodQuantity=" + prodQuantity + '}';
    }
    
    
    
    
    
}       //end class
    