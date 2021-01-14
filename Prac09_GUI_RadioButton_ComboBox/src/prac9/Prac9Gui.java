/**
 * LESSONS
 * 1. Using the KeyListener interface
 * 2. Working with the comboBox
 * 3. Using the append method
 * 4. Creating margins using EmptyBorder 
 */

package prac9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Prac9Gui extends JFrame implements ActionListener, KeyListener{
    
    //declare the panels
    private JPanel left = new JPanel();
    private JPanel middle = new JPanel();
    private JPanel bottom = new JPanel();
    
    //declare the JLabels
    private JLabel radioButtonLbl = new JLabel("Radio Button");
    private JLabel textFieldLbl = new JLabel("TextField");
    private JLabel comboBoxLbl = new JLabel("ComboBox");
    
    //declare the buttons
    private JButton redBtn = new JButton("Red");
    private JButton blueBtn = new JButton("Blue");
    private JButton readBtn = new JButton("Read");
    private JButton exitBtn = new JButton("Exit");
    
    //declare the radio components
    private JRadioButton greenRadio = new JRadioButton("Green");
    private JRadioButton yellowRadio = new JRadioButton("Yellow");
    private ButtonGroup group = new ButtonGroup();
    
    //declare comboBox
    String[] colors = {"Cyan", "Black",  "White"};
    private JComboBox comboColors = new JComboBox(colors);    
    
    //declare a textField
    private JTextField textField = new JTextField(7);
    
    //declare JTextArea
    private JTextArea messageArea = new JTextArea(15,30);

    //constructor
    public Prac9Gui(){
        
        super("Fun with colours");
        
        //layout for the frame
        setLayout(new BorderLayout());
        
        //layout for panels
        left.setLayout(new GridLayout(7,0));
        middle.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());
        
        //set the margins for the panels
        left.setBorder(new EmptyBorder(0, 5, 0, 0));
        bottom.setBorder(new EmptyBorder(35, 0, 0, 0));
        
        //add components to bottom panel
        bottom.add(redBtn);
        bottom.add(blueBtn);
        bottom.add(readBtn);
        bottom.add(exitBtn);
        
        //add components to left panel
        left.add(radioButtonLbl);
        group.add(greenRadio);
        group.add(yellowRadio);
        left.add(greenRadio);
        left.add(yellowRadio);
        
        left.add(textFieldLbl);
        left.add(textField);
        
        left.add(comboBoxLbl);
        left.add(comboColors);
                      
        //add components to middle panel
        messageArea.setBackground(Color.black);
        middle.add(messageArea);
        
        
        add(left, BorderLayout.WEST);
        add(bottom, BorderLayout.SOUTH);
        add(middle, BorderLayout.CENTER);
        
        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        readBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        
        greenRadio.addActionListener(this);
        yellowRadio.addActionListener(this);
        
        textField.addKeyListener(this);
        
        comboColors.addActionListener(this);
        
    }       //close constructor
    
    
    public void actionPerformed(ActionEvent e) {        
        if(e.getSource() == redBtn){        //red Button clicked
            messageArea.setBackground(Color.red);         
            messageArea.append("Red button selected\n");
        }
        else if(e.getSource() == blueBtn){    //blue button clicked
            messageArea.setBackground(Color.blue);      
            messageArea.append("Blue button selected\n");
        }
        else if(e.getSource() == readBtn){      //read button clicked
            String message = textField.getText()+"\n";
            messageArea.setText(message);
        }
        else if(e.getSource() == exitBtn){      //exit button clicked
            System.exit(0);
        }   
        if(e.getSource() == greenRadio){       //green radio button clicked
            messageArea.setForeground(Color.GREEN);
            messageArea.append("green radioButton selected\n");
        }
        else if(e.getSource() == yellowRadio){      //yellow radio button clicked
            messageArea.setForeground(Color.yellow);
            messageArea.append("yellow radioButton selected\n");
        }
        else if(e.getSource() == comboColors){
            String selectedColor = comboColors.getSelectedItem().toString();
            String message = selectedColor+" selected in ComboBox\n";
            
            switch(selectedColor){
                case "Cyan":
                    messageArea.setBackground(Color.cyan);
                    messageArea.append(message);
                    break;
                case "Black":
                    messageArea.setBackground(Color.black);
                    messageArea.append(message);
                    break;
                case "White":
                    messageArea.setBackground(Color.white);
                    messageArea.append(message);
                    break;
            }       //end the switch
        }
        
        
    }       //close the actionPerformed method

    
    
    @Override
    public void keyPressed(KeyEvent key) {
        if(key.getKeyCode() == KeyEvent.VK_ENTER){
            String message = textField.getText()+"\n";
            messageArea.append(message);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }


}       //close the class
