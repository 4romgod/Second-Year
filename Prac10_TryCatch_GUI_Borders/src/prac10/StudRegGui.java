
package prac10;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudRegGui extends JFrame implements ActionListener{
    
    ArrayList graduateList = new ArrayList();       //stores list of graduates
    Graduate[] grads;
    
    //declare the buttons
    private JButton addBtn = new JButton("ADD");
    private JButton sortBtn = new JButton("SORT");
    private JButton displayBtn = new JButton("DISPLAY");
    
    //declare the JLabels
    private JLabel idLbl = new JLabel("ID: ");
    private JLabel surnameLbl = new JLabel("Surname: ");
    private JLabel qualificationLbl = new JLabel("Qualification: ");
    private JLabel feeLbl = new JLabel("Fee: ");
    
    //declare the textFields
    private JTextField idTxt = new JTextField(8);
    private JTextField surnameTxt = new JTextField(8);
    //private JTextField qualificationTxt = new JTextField(8);
    private JTextField feeTxt = new JTextField(8);
    
    //declare combo box
    String[] qualifications = {"None", "NDIPIT", "NCINT", "NDINFT"};
    private JComboBox comboBoxQual = new JComboBox(qualifications); 
    
    
    //deal with the top panel
    private JPanel topPnl = new JPanel();
    private JPanel centerPnl = new JPanel();
    private JPanel bottomPnl = new JPanel();
    
    
    //creating a menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("MENU");
    private JMenuItem menuAdd = new JMenuItem("ADD");
    private JMenuItem menuSort = new JMenuItem("SORT");
    private JMenuItem menuDisplay = new JMenuItem("DISPLAY");

    //declaring the JList
    private JList list = new JList();

    //declare the constructor
    public StudRegGui(){
        super("STUDENT REGISTRATION");
        
        setLayout(new BorderLayout());
        
        topPnl();
        centerPnl();
        bottomPnl();

        add(topPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
        add(bottomPnl, BorderLayout.SOUTH);        
          
    }       //end constructor
    
    
    //method to deal with top panel
    public void topPnl(){                    
        topPnl.setLayout(new GridLayout(1,4));  
        
        JPanel componentsPnl = new JPanel();
        componentsPnl.setLayout(new GridLayout(1,4));
        componentsPnl.setBorder(new EmptyBorder(5,0,2,0));
        
        componentsPnl.add(idLbl);
        componentsPnl.add(idTxt);
        componentsPnl.add(surnameLbl);
        componentsPnl.add(surnameTxt);
        
        topPnl.add(componentsPnl);
                
        TitledBorder title = new TitledBorder("STUDENT");
        topPnl.setBorder(title);
        
    }       //end topPnl method
    
    
    //method to deal with center panel
    public void centerPnl(){                       
        centerPnl.setLayout(new GridLayout(1,4));      
        
        JPanel componentsPnl = new JPanel();
        componentsPnl.setLayout(new GridLayout(1,4));
        componentsPnl.setBorder(new EmptyBorder(5,0,2,0));
        
        componentsPnl.add(qualificationLbl);
        componentsPnl.add(comboBoxQual);
        componentsPnl.add(feeLbl);
        componentsPnl.add(feeTxt);
        
        comboBoxQual.addActionListener(this);
                
        centerPnl.add(componentsPnl);
        
        TitledBorder title = new TitledBorder("GRADUATE");
        centerPnl.setBorder(title);
        
    }       //end centerPnl method
    
    
    //method to deal with bottom panel 
    public void bottomPnl(){                       
        bottomPnl.setLayout(new GridLayout(1,3));        
        bottomPnl.add(addBtn);
        bottomPnl.add(sortBtn);
        bottomPnl.add(displayBtn);
                
        addBtn.addActionListener(this);
        sortBtn.addActionListener(this);
        displayBtn.addActionListener(this);
                
        TitledBorder title = new TitledBorder("OPERATIONS");
        bottomPnl.setBorder(title);
        
        menuBar.add(menu);
        menu.add(menuAdd);
        menu.add(menuSort);
        menu.add(menuDisplay);
        bottomPnl.add(menuBar);
        
        menuAdd.addActionListener(this);
        menuSort.addActionListener(this);
        menuDisplay.addActionListener(this);
        
    }       //end bottomPnl method

    
    @Override       //override the actionPerformed method
    public void actionPerformed(ActionEvent event) {
        

        //-------------------------------BUTTONS ACTION--------------------------------------
        if((event.getSource() == addBtn)|| (event.getSource() == menuAdd)){        //adds graduate instance into an arrayList
            verifyInputs();
        }
        
        else if((event.getSource() == sortBtn) || (event.getSource() == menuSort)){
            graduateList.sort(comSurname);
        }
        
        else if((event.getSource() == displayBtn) || (event.getSource() == menuDisplay)){
            String message = "";
            for(int i=0; i<graduateList.size(); i++){
                message += graduateList.get(i).toString() + "\n";
            }  
            JOptionPane.showMessageDialog(null, message);
        }
        //--------------------------------END BUTTONS ACTION-----------------------------
        
        
        //-------------------------------COMBOBOX ACTION---------------------------------
        if(event.getSource() == comboBoxQual){
            switch(comboBoxQual.getSelectedItem().toString()){
                case "NDIPIT":
                    JOptionPane.showMessageDialog(null, "National Diploma in Information Technology");
                    break;
                case "NCINT":
                    JOptionPane.showMessageDialog(null, "NCINT");
                    break;
                case "NDINFT":
                    JOptionPane.showMessageDialog(null, "NDINFT");
                    break;
            }       //end the switch 
        }
        //--------------------------END COMBOBOX ACTION------------------------------
        

    }       //end the actionPerformed method
    
    
    //sort list according to surname
    Comparator<Student> comSurname = new Comparator<Student>(){
        public int compare(Student stud1, Student stud2){
            return stud1.getName().compareToIgnoreCase(stud2.getName());
        }
    };
    
    
    //------------------------------------------------------VERIFICATION METHODS------------------------------
    //verify all the inputs
    public void verifyInputs(){
        Graduate grad = new Graduate();
            
            if(inputNotNull(idTxt.getText())){            
                String id = idTxt.getText();
                grad.setiD(id);
                idTxt.setBackground(Color.white);
            }
            else{
                idTxt.setBackground(Color.red);
            }
            
            if(inputNotNull(surnameTxt.getText())){            
                String surname = surnameTxt.getText();
                grad.setName(surname);                
                surnameTxt.setBackground(Color.white);
            }
            else{
                surnameTxt.setBackground(Color.red);
            }
            
            if(inputNotNull(comboBoxQual.getSelectedItem().toString())){            
                String qual = comboBoxQual.getSelectedItem().toString();
                grad.setQualification(qual);                
            }
            else{
                JOptionPane.showMessageDialog(null, "Select qualification");
            }
            
            if(inputValid(feeTxt.getText())){            
                double fee = Double.parseDouble(feeTxt.getText());
                grad.setFee(fee);                
                feeTxt.setBackground(Color.white);
            }
            else{
                feeTxt.setBackground(Color.red);
            }
            
            //only add a student after all the input is verified
            if(inputValid(feeTxt.getText()) && inputNotNull(idTxt.getText()) && inputNotNull(surnameTxt.getText())){            
                graduateList.add(grad);
            }   
    }
    
    //method to verify if the input is a double value
    public boolean inputValid(String input){
        try{
            double num = Double.parseDouble(input);      
        } 
        catch(NumberFormatException | NullPointerException nfe){
            return false;
        }
        return true;
    }       //close the inputValid method
    
    //method to verify if the input is not null
    public boolean inputNotNull(String input){
        if((input.equalsIgnoreCase("")) || (input.equals(null))){
            return false;
        }
        else
            return true;
    }
    
//------------------------------------------------------END VERIFICATION METHODS------------------------------

 
    
}       //close the class
