
package prac10;


public class Student{
    
    String name, iD;
    int score;
    
    public Student(){
        name = "";
        iD = "";
        score = 0;
    }
    
    public Student(String id, String name, int score){
        this.iD = id;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "STUDENT{" + "Name=" + name + ", ID=" + iD + ", Score=" + score + '}';
    }

    
    
}
