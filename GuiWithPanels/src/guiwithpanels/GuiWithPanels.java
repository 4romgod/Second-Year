
package guiwithpanels;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiWithPanels extends JFrame implements ActionListener, ItemListener{
    
    //declare variables for panels
    private JPanel radioPanel = new JPanel(new GridLayout(1,3));        //at the bottom
    private JPanel textPanel = new JPanel();                            //in the middle
    private JPanel leftPanel = new JPanel();                            //on the left side
    private JPanel rightPanel = new JPanel();                           //on the right side
    
    //declare textfield and label
    private JTextField nameTxt = new JTextField();
    private JLabel nameLbl = new JLabel("Enter your name");
    
    //declare radio buttons
    private JRadioButton redRadio = new JRadioButton("Red");
    private JRadioButton blueRadio = new JRadioButton("Blue");
    private JRadioButton greenRadio = new JRadioButton("Green");
    private ButtonGroup group = new ButtonGroup();     //group for radio buttons
       
    //declare text area
    private JTextArea Messagetxt = new JTextArea(10,40);

    //declare Jbuttons
    private JButton addBtn = new JButton("Add student");
    private JButton remBtn = new JButton("Remove student");
    private JButton edtBtn = new JButton("Edit Student");
    private JButton exBtn = new JButton("Exit");
    
    //declare JCheckBoxess
    private JCheckBox maleChk = new JCheckBox("Male");
    private JCheckBox femaleChk = new JCheckBox("Female");

    //Constructor for objects of class GuiWithPanels
    public GuiWithPanels(){
        //call parent class constructor
        super("Frame dealing with panels");
        
        //layout of the frame
        setLayout(new BorderLayout());
        
        //layout of panels
        //radioPanel.setLayout(new GridLayout(3,1));
        textPanel.setLayout(new FlowLayout());
        leftPanel.setLayout(new GridLayout(2,2));
        rightPanel.setLayout(new FlowLayout());
        
        //adding radio buttons to panel and group
        group.add(redRadio);
        group.add(blueRadio);
        group.add(greenRadio);
        radioPanel.add(redRadio);
        radioPanel.add(blueRadio);
        radioPanel.add(greenRadio);
        
        //adding textfield and label to panel
        textPanel.add(nameLbl);
        nameTxt.setColumns(25);
        textPanel.add(nameTxt);

        //adding buttons to panel
        leftPanel.add(addBtn);
        leftPanel.add(remBtn);
        leftPanel.add(edtBtn);
        leftPanel.add(exBtn);
        
        //adding checkboxes to panel
        rightPanel.add(maleChk);
        rightPanel.add(femaleChk);

        //adding panels and textarea to frame
        add(textPanel,BorderLayout.NORTH);
        add(Messagetxt,BorderLayout.CENTER);
        add(radioPanel,BorderLayout.SOUTH);
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.EAST);
        
        //register components with Listeners
        nameTxt.addActionListener(this);
        redRadio.addItemListener(this);
        blueRadio.addItemListener(this);
        greenRadio.addItemListener(this);
        
    }       //close the constructor
    
    
    public void actionPerformed(ActionEvent action){      
        if (action.getSource() == nameTxt){
            Messagetxt.setText("Welcome " + nameTxt.getText());
        }      
    }       //close actionPerformed
      
    
    public void itemStateChanged(ItemEvent e){  
        
        if (e.getStateChange() == ItemEvent.SELECTED){                                    
            if (redRadio.isSelected())
            {
                Messagetxt.setBackground(Color.RED);
            }
                
            else if (blueRadio.isSelected()){
                Messagetxt.setBackground(Color.BLUE);
            }
            else if (greenRadio.isSelected()){
                Messagetxt.setBackground(Color.green);
            }
            
        }//end if e.getStateChanged    
        
    }//end method itemStateChanged
    
    
}//end class

