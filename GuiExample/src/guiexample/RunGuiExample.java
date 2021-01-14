
package guiexample;

import javax.swing.*;

public class RunGuiExample
{
    public static void main(String[] args)
    {
        GuiExample myGui = new GuiExample();
        myGui.setLocationRelativeTo(null);
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setSize(450,400);
        myGui.setVisible(true);
    }
}