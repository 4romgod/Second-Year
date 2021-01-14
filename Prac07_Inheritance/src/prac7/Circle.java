
package prac7;

public class Circle {

    int radius;
    
    public Circle(){
        radius = 0;
    }
    
    public Circle(int rad){
        radius = rad;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public int getDiameter(){
        return 2*getRadius();
    }
    
    public double getArea(){
        double area = Math.PI*Math.pow(radius, 2);
        return area;
    }
    
    public double getCircumference(){
        double circumference = 2*Math.PI*getRadius();
        return circumference;
    }
    

    public String toString(){
        String message = String.format("CIRCLE PROPERTIES \nArea:  %.2f  units square \nCircumference:  %.2f  units \n", getCircumference(), getArea());
        return message;
    }
    
}       //close the class
