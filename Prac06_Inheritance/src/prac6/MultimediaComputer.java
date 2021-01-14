
package prac6;


public class MultimediaComputer extends Computer{
    
    double cdRomSpeed;
    
    public MultimediaComputer(String cpu, double cpuSpeed, double romSpeed){
        super(cpu, cpuSpeed);       //this calls the constructor of parent class: Computer
        this.cdRomSpeed = romSpeed;
    }
    
    public void setCdRomSpeed(double cdRomSpeed) {
        this.cdRomSpeed = cdRomSpeed;
    }
    
    public double getCdRomSpeed() {
        return cdRomSpeed;
    }

    public String toString(){
        String message = String.format(super.toString() + "\nCD-ROM Speed: " + getCdRomSpeed());
        return message;
    }
    
    
}       //close the class
