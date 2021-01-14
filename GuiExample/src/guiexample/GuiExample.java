package guiexample;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class GuiExample extends JFrame implements ActionListener
{
    //****declare label and textfield****
//*******Table-related declarations******************************************************************
    ArrayList<Student> list;
    JTable table;
    DefaultTableModel tableModel;
//*************************************************************************
    
    private JTextField nameTxt = new JTextField(10);
    private JLabel nameLbl = new JLabel("Enter your name");
    
    //declare buttons
    private JButton blueBtn = new JButton("Blue");
    private JButton pinkBtn = new JButton("Pink");
    private JButton resetBtn = new JButton("Reset");
    
    //declare radio buttons
    private JRadioButton redRadio = new JRadioButton("Red");
    private JRadioButton blueRadio = new JRadioButton("Blue");
    private JRadioButton greenRadio = new JRadioButton("Green");
    
    //group for radio buttons
    private ButtonGroup group = new ButtonGroup();        
    
    //declare text area
    private JTextArea messagetxt = new JTextArea(10,30);
    
    
    //Constructor for objects of class GuiExample 
    public GuiExample() 
    {
        //call parent class constructor super();
        super("Frame for Gui components");          //creates a frame with label "Frame for Gui Components"
        
        //layout of the frame
        setLayout(new FlowLayout());
        //setLayout(new GridLayout(3,2));
        //setLayout(new BorderLayout());
             
        //adding buttons to Frame
        add(pinkBtn);
        add(blueBtn);
        add(resetBtn);

        //register components with listener
        pinkBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        //adding radio buttons group and to Frame
        group.add(redRadio);
        group.add(blueRadio);
        group.add(greenRadio);
        add(redRadio);
        add(blueRadio);
        add(greenRadio);
        
        //register components with listener
        redRadio.addActionListener(this);
        blueRadio.addActionListener(this);
        
        //adding textfield and label to Frame
        add(nameLbl);
        add(nameTxt);
        
        //register components with listener
        nameTxt.addActionListener(this);
        
//***************Populating a JTable with data from an Arraylist************************************        
        tableModel = new DefaultTableModel(0,3);
        table = new JTable(tableModel);
        list = new ArrayList<Student>();
        list.add(new Student(1234, "Jon", 20));
        list.add(new Student(3456, "Mary", 10));
        list.add(new Student(5678, "Joe", 19));
        for (int i = 0; i< list.size(); i++){
            tableModel.addRow(new Object[]{list.get(i).getId(), list.get(i).getName(),list.get(i).getScore()});
        }
        add(table);
        //System.out.println(tableModel.getRowCount());
//        System.out.println(tableModel.getValueAt(1,0));
//*************************************************************************************        
        
        //adding textarea to frame
        add(messagetxt,  BorderLayout.CENTER);

        //set color of JButton objects
        blueBtn.setBackground(Color.lightGray);
        pinkBtn.setBackground(Color.lightGray);    
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==pinkBtn)
            pinkBtn.setBackground(Color.pink);
               
            else if (e.getSource()==redRadio){
                messagetxt.setBackground(Color.red);
                messagetxt.setForeground(Color.white);
            }
            else if (e.getSource()==blueRadio){
                messagetxt.setBackground(Color.blue);
                messagetxt.setForeground(Color.white);
            }
            
        if (e.getSource()== nameTxt)
            messagetxt.append(nameTxt.getText()+"\n");
            
        if (e.getSource()== resetBtn){
            messagetxt.setBackground(Color.white);
            messagetxt.setForeground(Color.black);
            messagetxt.setText("");
        }
    }
    
}//end class