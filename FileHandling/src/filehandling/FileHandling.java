
package filehandling;

import Image.ImageReading;
import Text.TextReading;

public class FileHandling {

    public static void main(String[] args) {

        chooseText();
        //chooseImage();
      
    }       //end main
    
    public static void chooseImage(){
        ImageReading image = new ImageReading();
        image.openImage();
        image.processImage();
        image.showImage();
    }      //end 
    
    public static void chooseText(){
        TextReading text = new TextReading();
        text.openText();
        text.processText();
    }      //end 
    
}       //end class
