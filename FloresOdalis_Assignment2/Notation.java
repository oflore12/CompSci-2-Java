/**
 * The Notation class will have a method infixToPostfix to convert infix notation to postfix notation that will take in a string 
 * and return a string, a method postfixToInfix to convert postfix notation to infix notation that will take in a string 
 * and return a string, and a method to evaluatePostfix to evaluate the postfix expression. It will take in a string 
 * and return a double.
 * Professor: Khandan Vahabzadeh Monshi
 * Assignment 2: Notation
 * Class: CMSC 204, CRN: 23859
 * @author Odalis R. Flores
 */
class Notation{
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		NotationStack<?> stack= new NotationStack(postfixExpr.length());
		double expression=0, first, second;
		for(int i =0; i< postfixExpr.length();i++) {
			//if space ignore
			if(postfixExpr.charAt(i)==' ') {
			}
			//if digit push to stack
			if (postfixExpr.charAt(i)>=48 && postfixExpr.charAt(i)<=57) {
				try {
					stack.push(postfixExpr.charAt(i));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
			//if character is operator 
			if(postfixExpr.charAt(i)=='*'|| postfixExpr.charAt(i)=='/'|| postfixExpr.charAt(i)=='+'|| postfixExpr.charAt(i)=='-') {
				try {
					first=Double.valueOf(stack.pop().toString());
					second=Double.valueOf(stack.pop().toString());
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				//evaluate based on operator
				if(postfixExpr.charAt(i)=='*')
					expression = second* first;
				else if(postfixExpr.charAt(i)=='/')
					expression = second/ first;
				else if(postfixExpr.charAt(i)=='+')
					expression = second+ first;
				else if(postfixExpr.charAt(i)=='-')
					expression = second- first;
					
				try {
					stack.push(expression);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		return expression;
	}
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		NotationStack<?> stack= new NotationStack(postfix.length());
		String infix="", first, second;
		for(int i =0; i< postfix.length();i++) {
			//if space ignore
			if(postfix.charAt(i)==' ') {
			}
			//if digit push to stack
			if (postfix.charAt(i)>=48 && postfix.charAt(i)<=57) {
				try {
					stack.push(postfix.charAt(i));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
			//if character is operator 
			if(postfix.charAt(i)=='*'|| postfix.charAt(i)=='/'|| postfix.charAt(i)=='+'|| postfix.charAt(i)=='-') {
				try {
					first=stack.pop().toString();
					second=stack.pop().toString();
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				infix="("+ second + postfix.charAt(i) + first+")";
				try {
					stack.push(infix);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		if(stack.size()>1) {
			throw new InvalidNotationFormatException();
		}
		else return stack.toString();
	}
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		NotationStack<?> stack= new NotationStack(infix.length());
		NotationQueue<?> postfix=new NotationQueue(infix.length());
		for(int i =0; i< infix.length();i++) {
			//if space ignore
			if(infix.charAt(i)==' ') {
				
			}
			//if digit add to postfix queue, enqueue
			if (infix.charAt(i)>=48 && infix.charAt(i)<=57) {
				try {
					postfix.enqueue(infix.charAt(i));
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				}
			}
			//if parenthesis add to stack
			if(infix.charAt(i)=='(') {
				try {
					stack.push(infix.charAt(i));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
			//if operator push to stack in order
			try {
				if(infix.charAt(i)=='*') {
					stack.push('*');
					}
				else if(infix.charAt(i)=='/') {
					stack.push('/');
					}
				else if(infix.charAt(i)=='+') {
					stack.push('+');
				}
				else if(infix.charAt(i)=='-') {
					stack.push('-');
				} 
			}catch (StackOverflowException e) {
				e.printStackTrace();
				}
			//if ")" send back the operators of the stack by popping them
			if(infix.charAt(i) ==')') {
				try {
					postfix.enqueue(stack.pop());
					stack.pop();
				}catch(QueueOverflowException | StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
		}
	}
		return postfix.toString();
	}
}