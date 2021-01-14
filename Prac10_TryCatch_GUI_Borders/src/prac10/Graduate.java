
package prac10;

public class Graduate extends Student{
    
    String qualification;
    double fee;
    
    public Graduate(){
        super();
        qualification = "";
        fee = 0;
    }
    
    public Graduate(String id, String name, int score, String qual, double fee){
        super(id, name, score);
        this.qualification = qual;
        this.fee = fee;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        String message = "GRADUATE{" + super.toString() + " Qualification=" + qualification + ", Fee=" + fee + '}';
        return message;
    }


}
