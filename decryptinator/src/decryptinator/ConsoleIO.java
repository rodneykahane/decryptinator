package decryptinator;

import java.util.Scanner;

public class ConsoleIO {
	
	
	public static String getInput() {
        Scanner keyBoard = new Scanner(System.in);  //scanner to get user input
        String crackString;  //used to return input

        System.out.print("Enter a string: ");
        crackString = keyBoard.nextLine();
        
        keyBoard.close();
        
        return (crackString);
	}//end getInput  
	
	public static void error() {
		System.out.println("Count NOT locate has in dictionary file.");
		
	}//end error
	
	public static void displayResult(String result){
		
		System.out.println("The word is " + result);
		
	}//end displayResult
	
	
	public static void progressBar(int progress){
		
		//insert some code to draw progress bar, recursive function?
		
		
	} //end progressBar
	

}
