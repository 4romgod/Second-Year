
package loan;

import java.awt.event.*;    
import javax.swing.*;   

public class Loan extends JFrame implements ActionListener {  

    private JMenuItem newItem, deleteItem, exitItem, option1Item, option2Item, option3Item; 
   
    public Loan(){
        super( "Small loans" );   
        //JMenuBar object
        JMenuBar menuBar = new JMenuBar();      
        setJMenuBar( menuBar );     
          
        //JMenu objects
        JMenu fileMenu = new JMenu( "File" );    
        JMenu editMenu = new JMenu( "Options" );
        
        //JMenuItem objects
        newItem = new JMenuItem( "New Account" );   
        deleteItem = new JMenuItem( "Delete Account" );     
        exitItem = new JMenuItem( "Exit" );             

        option1Item = new JMenuItem( "Option 1" );  
        option2Item = new JMenuItem( "Option 2" );  
        option3Item = new JMenuItem( "Option 3" );          

        //register JMenuItem objects with the Listener
        newItem.addActionListener(this);         
        deleteItem.addActionListener(this);         
        exitItem.addActionListener(this);         

        option1Item.addActionListener(this);         
        option2Item.addActionListener(this);         
        option3Item.addActionListener(this);         
          
        //add the JMenuItem objects to the JMenu objects
        fileMenu.add( newItem );  
        fileMenu.add( deleteItem );           
        fileMenu.addSeparator();  
        fileMenu.add( exitItem );
          
        editMenu.add(option1Item);
        editMenu.add(option2Item);
        editMenu.add(option3Item);
          
        //add the JMenu objects to the JMenubar object
        menuBar.add( fileMenu );       
        menuBar.add( editMenu );         
          
        setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );     
        setSize( 370, 330 ); 
        setVisible( true );      
    }  // end constructor
    
    public void actionPerformed( ActionEvent event ){
        
            /**You can use the getActionCommand() method to determine the source of the ActionEvent.
            *  The getActionCommand() method returns the label text associated with the component that
            *  generated the event.*/
            if (event.getActionCommand().equals("Exit"))
                System.exit(0);
            else if (event.getActionCommand().equals("New Account"))
                JOptionPane.showMessageDialog(null,"New account option selected");
            else if (event.getActionCommand().equals("Delete Account"))
                JOptionPane.showMessageDialog(null,"Delete account option selected");
            
            /**...or you can use the getSource() method, which returns the component 
             *    that generated the event*/
            if (event.getSource()== option1Item)
                JOptionPane.showMessageDialog(null,"Option1 selected");
            else if (event.getSource()== option2Item)
                JOptionPane.showMessageDialog(null,"Option2 selected");
            else if (event.getSource()== option3Item)
                JOptionPane.showMessageDialog(null,"Option3 selected");
             
        }
    
    public static void main( String args[] ){          
        new Loan();                        
    }   //close the main method  
    
} 

