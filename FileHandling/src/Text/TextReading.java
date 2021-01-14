package Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextReading {

    private BufferedReader br;
    JFileChooser chooser;

    public void openText() {
        try {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt", "doc"));
            chooser.setAcceptAllFileFilterUsed(true);

            int result = chooser.showOpenDialog(null);

            File selectedFile;
            String fileName = "";
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                fileName = selectedFile.getAbsolutePath();
                System.out.println("Selected file: " + fileName);
            } //end if
            else {
                return;
            }

            br = new BufferedReader(new FileReader(fileName));
        } catch (IOException ioe) {
            System.out.println("openText: " + ioe.getMessage());
        }
    }        //end openText()

    public void processText() {
        if (br != null) {
            try {
                String ln = br.readLine();

                while (ln != null) {
                    System.out.println(ln + "\n");
                    ln = br.readLine();
                }       //end while
            } catch (IOException ioe) {
                System.out.println("processText: " + ioe.getMessage());
            }
        }	//end if

    }     //end processText()

    public void closeText() {
    }       //end closeText()

}
