
package project;


public class Sale {
    
    int itemsSold;
    double totalSalesValue;
    FoodMenuItem item;

    public Sale(FoodMenuItem item, int itemsSold, double totalSalesValue) {
        this.itemsSold = itemsSold;
        this.totalSalesValue = totalSalesValue;
        this.item = item;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public double getTotalSalesValue() {
        return totalSalesValue;
    }

    public void setTotalSalesValue(double totalSalesValue) {
        this.totalSalesValue = totalSalesValue;
    }

    public FoodMenuItem getItem() {
        return item;
    }

    public void setItem(FoodMenuItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Sale{" + "itemsSold=" + itemsSold + ", totalSalesValue=" + totalSalesValue + ", item=" + item + '}';
    }
    
    
    
    
}       //end class
