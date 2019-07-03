package decryptinator;

import java.util.Scanner;
import java.io.*;

public class Cracker {
	
	public static int testClass() {
		System.out.println("this is a test of testClass");
		return (0);
	}//end testClass
    
	
	public static String crack(String crackWord[]) throws FileNotFoundException {
		int found = 0;
	    int offset = 0;  //letter offset
	    int k = 0;  //used to shift through 2d array alphabet[]
	    int success = 0; //increases offset each pass if solution has NOT been found
	    String[] stringToCrackArray;  //convert string to array
	    int[] stringToIntArray = {0,0,0,0,0,0};  //used in converting the numbers in the 2d array from chars to ints
	    String[] hashArray = {"0","0","0","0","0","0"};
	    int temp;  //used to convert offsets back to letters
	    int j = 0;  //for looping through stringToCrackArray array
	    String[] numberPositions = {"0","0","0","0","0","0"};        
	    String[][] alphabet = {{"a","1"},{"b","2"},{"c","3"},{"d","4"}, {"e","5"}, {"f","6"},{"g","7"},{"h","8"},{"i","9"},{"j","10"},{"k","11"},{"l","12"},{"m","13"},{"n","14"},{"o","15"},{"p","16"},{"q","17"},{"r","18"},{"s","19"},{"t","20"},{"u","21"},{"v","22"},{"w","23"},{"x","24"},{"y","25"},{"z","26"}};
	    Scanner s = null;  //scanner to take file input
	    String finalString=null;
	    String dictionaryFilePath=null;
	
	    stringToCrackArray = crackWord;	   
	    
	    while (offset<=25){         
            while(success < stringToCrackArray.length){                        
                for (int i=0;i<=alphabet.length-1;i++){                
                    if(stringToCrackArray[j].equals(alphabet[i][0])) {                   
                        k=i;
                        break;
                    }//end if   
                }//end for            
                numberPositions[j]=alphabet[k][1];
                success++;
                j++;
            }//end while  

            //convert string to int because numbers in 2d array are considered char and NOT ints
            for (int l=0;l<numberPositions.length;l++)
                stringToIntArray[l] = Integer.parseInt(numberPositions[l]);        

            //add offset to numbers
            for (int m=0;m<numberPositions.length;m++)
                stringToIntArray[m] = stringToIntArray[m]+(offset-1);  //ex - if offset is 13, use 12 to account for array starting at 0      

            //convert offsets back to letters
            for (int q=0;q<stringToIntArray.length;q++){

                if(stringToIntArray[q]>=26){
                    temp = stringToIntArray[q]-26;                
                    hashArray[q] = alphabet[temp][0];
                } else {                
                    hashArray[q] = alphabet[stringToIntArray[q]][0];
                }//end if/else
            }//end for


           //convert hashArray back into a string --> testHash
            String testHash = "";
            for (int q=0;q<hashArray.length;q++)
                testHash = testHash+hashArray[q];               

            //open dictionary file and compare testHash to contents

                try {
                    //s = new Scanner(new BufferedReader(new FileReader("c:\\users\\rodney\\documents\\words.txt")));  //win file path
                    //s = new Scanner(new BufferedReader(new FileReader("/Users/Rodney/Documents/words.txt")));  //mac file path                    
                	dictionaryFilePath = GraphicIO.returnFile(); //for use with GraphicIO
                	s = new Scanner(new BufferedReader(new FileReader(dictionaryFilePath)));  //for use with GraphicIO
                	
                    while (s.hasNext()) {
                        
                        String current = s.nextLine();
                        if (testHash.equals(current.toLowerCase())){   //force dictionary input to lowercase in case user does not use caps                        	
                        	finalString = current;
                            offset = 26;  //raise offset to out of bounds to end looping
                            found = 1;                            
                        } else {
                            //System.out.println("Could NOT locate hash in dictionary file.");
                        }                        
                    }//end while
                } finally {
                    if (s != null) {
                        s.close();
                    }//end if                        
                }//end finally
                
            offset++;
        }//end big while
        if (found == 0)
            //InputOutput.error();
        	finalString = "Could NOT locate in dictionary file";
		
        return (finalString);
	}  //end crack

}
