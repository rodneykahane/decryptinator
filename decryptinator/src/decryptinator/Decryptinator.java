package decryptinator;

import static decryptinator.ConsoleIO.*;
import java.io.*;
import javax.swing.*;

public class Decryptinator {

	public static void main(String[] args) throws FileNotFoundException {
		
    	//get string to crack
        GraphicIO application = new GraphicIO();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

		getInput();      
	}

}
