
package prac8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame implements ActionListener{

    //declare the panels
    private JPanel top = new JPanel();
    private JPanel leftSide = new JPanel();
    private JPanel middle = new JPanel();
    private JPanel rightSide = new JPanel();
    private JPanel bottom = new JPanel();
    
    //declare the labels
    private JLabel titleLbl = new JLabel("ADDING TWO NUMBERS");
    private JLabel num1Lbl = new JLabel("  Enter a number");
    private JLabel num2Lbl = new JLabel("  Enter another number");
    private JLabel sumLbl = new JLabel("  The sum is");
    
    //declare the texfields
    private JTextField num1Txt = new JTextField(15);
    private JTextField num2Txt = new JTextField(15);
    private JTextField sumTxt = new JTextField(15);
    
    //declare the button
    private JButton addBtn = new JButton("ADD");
    private JButton resetBtn = new JButton("Reset");
    private JButton redBtn = new JButton("red");
    private JButton blueBtn = new JButton("blue");
    private JButton greenBtn = new JButton("green");
    
    public Gui(){
        
        super("Frame for GUI components");
        
        //Layout of the frame
        setLayout(new BorderLayout());
        
        //Layouts of the 5 Panels
        leftSide.setLayout(new GridLayout(3,1));
        middle.setLayout(new GridLayout(3,1));
        top.setLayout(new FlowLayout());
        rightSide.setLayout(new GridLayout(3,1));
        bottom.setLayout(new FlowLayout());
        
        rightSide.setBorder(new EmptyBorder(0, 0, 0, 10));
        middle.setBorder(new EmptyBorder(0, 5, 0, 5));
        top.setBorder(new EmptyBorder(5, 0, 5, 0));
        bottom.setBorder(new EmptyBorder(5, 0, 5, 0));

        //add first row stuff
        leftSide.add(num1Lbl);
        middle.add(num1Txt);
        rightSide.add(redBtn);

        //add second row stuff
        leftSide.add(num2Lbl);
        middle.add(num2Txt);
        rightSide.add(blueBtn);

        //add third row stuff
        leftSide.add(sumLbl);
        middle.add(sumTxt);
        rightSide.add(greenBtn);

        //add title to top panel
        top.add(titleLbl);
        
        //add button to bottom panel
        bottom.add(addBtn);
        bottom.add(resetBtn);
        
        //add panela to the Frame
        add(leftSide, BorderLayout.WEST);
        add(rightSide, BorderLayout.EAST);
        add(middle, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);

        //add event listener for buttons
        addBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        greenBtn.addActionListener(this);
        
        //add tool tips for the buttons
        addBtn.setToolTipText("Add num1 and num2");
        resetBtn.setToolTipText("Sets back to normal state");
        redBtn.setToolTipText("Change num1 text field to red");
        blueBtn.setToolTipText("Change num2 text field to blue");
        greenBtn.setToolTipText("Change sum text field to green");

    }       //close the constructor

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addBtn){
            
            //this if statement verifies the input before adding them
            if(inputValid(num1Txt.getText()) && inputValid(num2Txt.getText())){
                int num1 = Integer.parseInt(num1Txt.getText());
                int num2 = Integer.parseInt(num2Txt.getText());
                int sum = num1 + num2;
                sumTxt.setText(""+sum);
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter valid numbers");
            }
            
        }       //close the if
        
        else if(e.getSource() == resetBtn){
            num1Txt.setBackground(Color.white);
            num2Txt.setBackground(Color.white);
            sumTxt.setBackground(Color.white);
            
            num1Txt.setText("");
            num2Txt.setText("");
            sumTxt.setText("");
        }
        
        else if(e.getSource() == redBtn){            
            num1Txt.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, ""+redBtn.getText());
        }
        
        else if(e.getSource() == blueBtn){           
            num2Txt.setBackground(Color.blue);
            JOptionPane.showMessageDialog(null, ""+blueBtn.getText());
        }
        
        else if(e.getSource() == greenBtn){            
            sumTxt.setBackground(Color.green);
            JOptionPane.showMessageDialog(null, ""+greenBtn.getText());
        }
        
    }       //close the actionPerformed method
    
    //method to verify if the input are integer values
    public boolean inputValid(String input){
        try{
            int num = Integer.parseInt(input);      
        } 
        catch(NumberFormatException | NullPointerException nfe){
            return false;
        }
        return true;
    }       //close the inputValid method


    
}       //close the class
