
package prac7;


public class Cylinder extends Circle{
    
    int height;
    
    public Cylinder(int rad, int height){
        super(rad);     //inherits the parent constructor
        this.height = height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return height;
    }

    public double getSurfaceArea(){   
        double sArea = super.getCircumference()*getHeight() + 2*super.getArea();
        return sArea;
    }       
     
    public double getVolume(){
        double volume = super.getArea()*height;
        return volume;
    }
    
    
    public String toString(){
        String message = String.format("CYLINDER PROPERTIES \nSurface Area:  %.2f  units square \nVolume:  %.2f  units cube \n", getSurfaceArea(), getVolume());
        return message;
    }
    
}       //close the class
