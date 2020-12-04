/**
 * Write the classes required to create a Morse Code Converter Utility. 
 * Your Morse Code Converter Utility will be using a generic linked binary tree 
 * with generic TreeNodes to convert Morse Code into English
 * Professor: Khandan Vahabzadeh Monshi
 * Assignment 5: Morse code converter
 * Class: CMSC 204, CRN: 23859
 * @author Odalis R. Flores
 * Due date: 12/03/2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree morseTree = new MorseCodeTree();
	/**
	 * returns a string with all the data in the tree in LNR order 
	 * with an space in between them. Uses the toArrayList method in 
	 * MorseCodeTree It should return the data in this order: 
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o" 
	 * Note the extra space between j and b - that is because there is 
	 * an empty string that is the root, and in the LNR traversal, the 
	 * root would come between the right most child of the left tree (j) 
	 * and the left most child of the right tree (b). This is used for 
	 * testing purposes to make sure the MorseCodeTree has been built 
	 * properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		String printTree= "";
	
		for(int i=0; i<morseTree.toArrayList().size(); i++) {
			if(i==morseTree.toArrayList().size()-1) {
				printTree+= morseTree.toArrayList().get(i);
			}
			else
				printTree+= morseTree.toArrayList().get(i)+" ";
		}
		return printTree;
	}
	/**
	 * Converts Morse code into English. Each letter is delimited by a 
	 * space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: 
	 * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param code the Morse code 
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String translation="";
		String tempCode="";

		if(code.charAt(code.length()-1)!=' ') {
			code+=" ";
		}
		
		for(int i=0;i<code.length();i++) {
			
			if(code.charAt(i)!=' '&& code.charAt(i)!='/') {
				tempCode+=code.charAt(i);
			}
			
			if(code.charAt(i)==' ') {
				translation+=morseTree.fetch(tempCode);
				tempCode="";
			}
			
			if(code.charAt(i)=='/') {
				translation+=" ";
			}
		}
		return translation;
	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited 
	 * by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: 
	 * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param codeFile - name of the file that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNoteFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String morseTxt= "";
		Scanner sc = new Scanner(codeFile);
		
		while(sc.hasNextLine()) {
			morseTxt+=sc.nextLine();
		}
		return convertToEnglish(morseTxt);
	}
}
