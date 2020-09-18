/**
 * Description: Create an application that will check for valid passwords.
 * The following rules must be followed to create a valid password.
 * 1.	At least 6 characters long
 * 2.	10 or more characters is a strong password, between 6 and 9 characters is a weak (but acceptable) password.
 * 3.	At least 1 numeric character
 * 4.	At least 1 upper case alphabetic character
 * 5.	At least 1 lower case alphabetic character
 * 6.	At least 1 special character
 * 7.	No more than 2 of the same character in a sequence
 * 
 * Professor: Khandan Monshi
 * Class: CMSC 204 CRN: 23859
 * Assignment 1
 * @author Odalis R. Fores
 * Due date: 09/17/2020
 */

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordCheckerUtility {
	
	/**
	 *PasswordCheckerUtility is an empty constructor
	 */
	public PasswordCheckerUtility(){}
	
	/**
	 * comparePasswords will test if passwords match
	 * @param password string to be checked with  string confirm password
	 * @param passwordConfirm string to be checked against password
	 * @throws UnmatchedException if passwords do not match
	 */
	public static void comparePasswords(String password, String confirmPassword) throws UnmatchedException{
		if(comparePasswordsWithReturn(password, confirmPassword)==false)
			throw new UnmatchedException();
	}
	
	/**
	 * comparePasswordsWithReturn will check if passwords enter match
	 * @param password string to be checked to match
	 * @param passwordConfirm string to be checked against password to match
	 * @return true if both password and confirmPassword are the same
	 */
	public static boolean comparePasswordsWithReturn(String passowrd, String confirmPassword) {
		String pattern = passowrd;
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(confirmPassword);
		return(matcher.matches());
	}
	
	/**
	 * isValidLength checks if password is greater than 6 characters long
	 * @param password String to be checked for length
	 * @return true if password meets minimum length
	 * @throws LengthExceoption if password does not meet min length
	 */
	public static boolean isValidLength(String password) throws LengthException{
		//boolean status=false;
		if (password.length()>= 6)
			return true;
		else{
			throw new LengthException("The password must be at least 6 characters long");
		}
		//return status;
	}
	
	/**
	 * hasUpperAlpha checks if password has an upper case letter
	 * @param password String to be checked for alpha character requirement
	 * @return true if meets alpha character requirement
	 * @throws NoUpperAlphaException if no upper case is found in string
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		String pattern = ".*[A-Z].*";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(password);
		boolean status = matcher.matches();
		if(status== false)
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		return status;	
	}
	
	/**
	 * hasLowerAlpha checks if password has a lower case letter
	 * @param password String to be checked for lower case requirement
	 * @return true if meets lower case requirement
	 * @throws NoLowerAlphaException if no lower case letter in string
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		String pattern = ".*[a-z].*";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(password);
		boolean status = matcher.matches();
		if(status== false)
			throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
		return status;	
	}
	
	/**
	 * hasDigit checks if string as a digit
	 * @param password String to be checked for digit requirement
	 * @return true if meets digit requirement
	 * @throws NoDigitException if no digit is found in string
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		
		String pattern = ".*\\d.*";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(password);
		//boolean status = matcher.matches();
		
		if(matcher.matches()== true)
			return true;
		else
			throw new NoDigitException("The password must contain at least one digit");
	}
	
	/**
	 * hasSpecialChar checks if string has a special character
	 * @param password String to be checked for SpecialCharacter requirement
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException if no special character is found in string
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		
		String pattern = ".*\\W.*";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(password);
		boolean status = matcher.matches();
		if(status== false)
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		return status;
	}
	
	/**
	 * hasSameCharInSequence checks if string has more than 2 of the same characters in sequence
	 * @param password String to be checked for Sequence requirement
	 * @return true if meets Sequence requirement
	 * @throws InvalidSequenceException if more than 2 characters are the same in sequence
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
		boolean status=true;
		int count=0;
		int passLength= password.length()-2;
		do{
			if(password.charAt(count) == password.charAt(count+1))
				if(password.charAt(count+1)==password.charAt(count+2))
					status=false;
			count++;
		}while(count<passLength && status!=false);
		if(status== false)
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		return status;
	}
	
	/**
	 * isValidPassword checks if string has all requirements to be a valid password
	 * @param string to be checked for validity
	 * @returns true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException thrown if string is less than 6 characters
	 * @throws NoUpperAlphaException thrown if no upper case letter in string
	 * @throws NoLowerAlphaException thrown if no lower case letter in string
	 * @throws NoDigitException thrown if no digit is found in string
	 * @throws NoSpecialCharacterException thrown if no special character is found in string
	 * @throws InvalidSequenceException thrown if more than 2 characters are the same in sequence
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		boolean status=false;
		if(isValidLength(password)==true && hasUpperAlpha(password)==true&& hasLowerAlpha(password)==true
				&& hasDigit(password)==true && hasSpecialChar(password)==true && hasSameCharInSequence(password)==true)
				status=true;
		return status;
	}
	
	/**
	 * hasBetweenSixAndNineChars checks if string has between 6-9 characters inclusive
	 * @param password String to be checked for length
	 * @return true if password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password){
		if(password.length()>=6 && password.length()<=9)
			return true;
		else return false;
	}
	
	/**
	 * isWeakPassword checks if password is valid and between 6-9 to be considered weak
	 * @param password string to be checked if weak password
	 * @return true if password is valid and weak
	 * @throws WeakPasswordException if weak and valid
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		boolean status=false;
		if(hasBetweenSixAndNineChars(password)==true)
			try {
				if(isValidPassword(password)==true) {
					status= true;
					throw new WeakPasswordException("Password OK but weak");
				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return status;
	}
	
	
	/**
	 * getInvalidPasswords Reads a file of passwords and the passwords that failed the check will be added 
	 * to an invalidPasswords ArrayList with space->space and the reason, 
	 * @param passwords list of passwords read from a file
	 * @return invalidPasswords ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords (ArrayList<String>passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for(int i=0; i<passwords.size();i++) {
			try {
				PasswordCheckerUtility.isValidPassword(passwords.get(i));
			} 
			catch (Exception e) {
				invalidPasswords.add(passwords.get(i)+" -> "+e.getMessage());
			}
		}
		return invalidPasswords;
	}

}

