
package prac6;


public class Computer {
    
    String cpuType;
    double cpuSpeed;
    
    public Computer(String cpu, double speed){
        this.cpuType = cpu;
        this.cpuSpeed = speed;
    }

    public void setCpuType(String cpu) {
        this.cpuType = cpu;
    }
    
    public String getCpuType() {
        return cpuType;
    }

    public void setCpuSpeed(double speed) {
        this.cpuSpeed = speed;
    }
    
    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public String toString(){
        String message = String.format("CPU Type: %s \nSpeed: %.2f GHz", getCpuType(), getCpuSpeed());
        return message;
    }
    
}       //close the class
