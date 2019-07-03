package decryptinator;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import static decryptinator.Cracker.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GraphicIO extends JFrame {
	
	static String fileExport=null;
	private static final long serialVersionUID = 1L;
	
	//Create a label and a text field for the top value
	private JLabel TopJLabel;
	private JTextField TopJTextField;
			
	//Create a static field that displays the results
	private JLabel resultJLabel;
	private JTextField totalResultJTextField;
	
	//Create a "button" that will call a method and perform some action
	private JButton crackJButton;
         static JFrame frame;
         
    //Create a "button" that will call a method and perform some action
  	private JButton browseJButton;
         //static JFrame frame;
  	
  //Create a "button" that will call a method and perform some action
  	private JButton quitJButton;
         //static JFrame frame;
	
	//no-argument constructor
	public GraphicIO() {
		createUserInterface();
	}
	
	//Now let's create the GUI components 
	public void createUserInterface() {
		frame = new JFrame("Our JButton listener example");
		//Get the content pane and set layout to null
		Container contentPane = getContentPane();
		contentPane.setLayout( null);
		
		//set up the label for the top value we created earlier
		TopJLabel = new JLabel();
		TopJLabel.setText( "Input a value");
		TopJLabel.setBounds(16, 16, 130, 21);  //x,y,width,height
		contentPane.add( TopJLabel);
		
		//set up the text field that will hold the value for the phrase to be cracked
		TopJTextField = new JTextField();
		TopJTextField.setText("x");
		TopJTextField.setBounds(128,  16,  100,  25);//x,y,width,height
		TopJTextField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add( TopJTextField);			
		
		//set up the label for the results field
		resultJLabel = new JLabel();
		resultJLabel.setText("Result:");
		resultJLabel.setBounds(16, 46, 60, 21); //x,y,width,height
		contentPane.add( resultJLabel);
		
		//set up the static output field for the results label
		totalResultJTextField = new JTextField();
		totalResultJTextField.setBounds(128,  46,  250,  21);//x,y,width,height
		totalResultJTextField.setHorizontalAlignment(JTextField.RIGHT);
		totalResultJTextField.setEditable( false ); //since we don't want the user to input a value
		contentPane.add( totalResultJTextField);
		
		//set up a button that will perform an action via a method call
		crackJButton = new JButton();
		crackJButton.setText("Crack!");
		crackJButton.setBounds( 70,  86,  126,  24);//x,y,width,height
		contentPane.add( crackJButton);
		
		//set up a button that will perform an action via a method call
		browseJButton = new JButton();
		browseJButton.setText("Browse");
		browseJButton.setBounds( 198,  86,  126,  24);//x,y,width,height
		contentPane.add( browseJButton);
		
		//set up a button that will perform an action via a method call
		quitJButton = new JButton();
		quitJButton.setText("Quit");
		quitJButton.setBounds( 326,  86,  126,  24);//x,y,width,height
		contentPane.add( quitJButton);
		
                
			crackJButton.addActionListener(new ActionListener()
                    {
                      public void actionPerformed(ActionEvent e)
                      {
                                                      
                          String decryptString = TopJTextField.getText();  
                          System.out.println("decryptString is: "+decryptString);
                          
                          String[] stringToCrackArray = decryptString.split("");
                          String finalString = null;
						try {
							finalString = crack(stringToCrackArray);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                          
                          
                          
                          totalResultJTextField.setText(finalString);
                      }
                    });//end crackJButton listener
			
			browseJButton.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
            	  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

          		int returnValue = jfc.showOpenDialog(null);          		

          		if (returnValue == JFileChooser.APPROVE_OPTION) {
          			File selectedFile = jfc.getSelectedFile();  //stores value of selected file
          			fileExport = selectedFile.getAbsolutePath();          			
          		}                             
                  
              }
            });//end browseJButton listener
			
			quitJButton.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
                        System.exit(0);                      
            
              }
            });//end quitJButton listener		
		
		
		//set the properties of the window
		setTitle( "Simple Password Cracker");
		setSize( 454, 212);
		setVisible( true );
		
	}
	
	public static String returnFile() {
		//System.out.println("test");
		String tmpOut = fileExport; 
		return(tmpOut);
	}
	
public static String returnResult(String result){
		
		String retStr = result;
		return(retStr);
		
	}//end displayResult

}
