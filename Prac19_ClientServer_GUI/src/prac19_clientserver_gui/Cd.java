package prac19_clientserver_gui;


import java.io.Serializable;


public class Cd implements Serializable{
    
    String title;
    String artist;
    double price;
    int yearReleased;
    
    public Cd(){
        this.title ="";
        this.artist="";
        this.price=0;
        this.yearReleased=0;
    }
    
    public Cd(String t, String a, double p, int y){
        this.title=t;
        this.artist=a;
        this.price=p;
        this.yearReleased=y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    @Override
    public String toString() {
        return "Cd{" + "title=" + title + ", artist=" + artist + ", price=" + price + ", yearReleased=" + yearReleased + '}';
    }
    
    
    
}       //end Cd class
