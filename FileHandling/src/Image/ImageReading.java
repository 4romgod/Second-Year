
package Image;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImageReading {
    
    JFileChooser chooser;
    File selectedFile;
    
    BufferedImage image;
    ByteArrayOutputStream baos;
    
    public void openImage(){
        try{
            chooser = new JFileChooser();

            //set initial directory where the dialog looks first
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            chooser.setAcceptAllFileFilterUsed(true);

            int result = chooser.showOpenDialog(null);

            String fileName="";

            //checks if a file was chosen
            if(result == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                fileName = selectedFile.getAbsolutePath();
                System.out.println("Selected File: "+fileName);
            }       //end if
            else {
            	return;
            }

            image = ImageIO.read(new File(fileName));
        }
        catch(IOException ioe){
            System.out.println("OpenImage: "+ioe.getMessage());
        }
    }       //end openImage
    
    public void processImage(){
    	
    	if(image!=null) {
	        try{       
	            baos = new ByteArrayOutputStream();
	            ImageIO.write(image, "jpg", baos);
	            String encodedImage="";
	            //encodedImage = Base64.encode(baos.toByteArray());
	            System.out.println(""+encodedImage);
	        }
	        catch(Exception e){
	            System.out.println("processImage: " + e.getMessage());
	        }
    	}		//end if
    	
    }        //end processImage()
    
    public void showImage(){
    	if(image!=null) {
	        JFrame frame = new JFrame();
	        frame.setVisible(true);
	        frame.setLayout(new FlowLayout());
	        frame.setSize(500,500);
	        JLabel lbl=new JLabel();
	        
	        ImageIcon icon=new ImageIcon(image);
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                
	        if(image == null) return;
	        int imageWidth = image.getWidth(null);
	        int imageHeight = image.getHeight(null);
	
	        Graphics g = image.getGraphics();
	        g.drawImage(image, 50, 50, null);
	
	        for (int i = 0; i*imageWidth <= 2; i++){
	            for(int j = 0; j*imageHeight <= 2;j++)
	                if(i+j>0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
	        }
    	}		//end if
    	
    }       //end showImage()
    
}       //end class
