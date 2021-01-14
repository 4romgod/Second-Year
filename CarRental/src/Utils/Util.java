package Utils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Util {

    /**
     * Displays an image inside a JLable
     * @param picLbl        The JLable in which to display an image
     * @param imagePath     The path of the image to be displayed
     */
    public static void setIconImage(javax.swing.JLabel picLbl, String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage(); // transform it 
        Image newImg = image.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newImg);  // transform it back
        picLbl.setIcon(imageIcon);
    }       //end setIconImage()
    
    
    //verify if string is null
    public static Boolean isNull(String text){
        if(text.equals("")||text.equals(null)){
            return true;
        }
        else{
            return false;
        }
    }       //end isNull()

}       //end class
