/**
 * Create a generic stack class called NotationStack. 
 * NotationStack will implement the Stack Interface given you. 
 * You will be creating NotationStack from scratch 
 * Professor: Khandan Vahabzadeh Monshi
 * Assignment 2: Notation
 * Class: CMSC 204, CRN: 23859
 * @author Odalis R. Flores
 *
 * @param <T> generic type
 */
import java.util.ArrayList;
import java.util.Collection;

public class NotationStack<T> implements StackInterface{
	//size of array
	private int size;
	//array of type t to hold stack
	private T[] data;
	//top of the stack
	private int topIndex;

	@SuppressWarnings("unchecked")
	/**
	 * Deafult constructor
	 */
	public NotationStack(){	
		size=100;
		data = (T[]) new Object[size];
		topIndex=-1;
	}
	/**
	 * Constructor that accepts integer size to initalize array
	 * @param size the size of the stack
	 */
	@SuppressWarnings("unchecked")
	public NotationStack(int size){	
		this.size = size;
		T[] temp = (T[]) new Object[size];
		data=temp;
		topIndex=-1;
	}
	/**
	 * Constructor that accepts an arraylist as paramenter
	 * it copies the elements from the arraylist to the array stack
	 * @param element arraylist to copy to stack
	 */
	public NotationStack(ArrayList<T> element){
		this.size= element.size();
		T[] temp = (T[]) new Object[size];
		for(int i=0;i<element.size();i++) {
			temp[i]=element.get(i);
		}
		data=temp;
		topIndex=size-1;
	}
	/**
	 * Checks if the stack is empty
	 */
	public boolean isEmpty() {
		if(topIndex<0) {
			return true;
		}
		else
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(size()== size) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Deletes the value at the top of the stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException {
		if(isEmpty()==false) {
			T temp = data[topIndex];
			data[topIndex]=null;
			topIndex--;
			return temp;
		}
		else throw new StackUnderflowException("");
		
	}
	/**
	 * Returns the value at the top of the stack without deleting it
	 * @throws StackUnderflowException stack is empty
	 */
	public T top() throws StackUnderflowException {
		if(isEmpty()==false) {
			return data[topIndex];
		}
		else 
			throw new StackUnderflowException("");
	}
	/**
	 * Tracks the size of the stack
	 */
	public int size() {
		return (topIndex+1);
	}
	/**
	 * pushes the objects to the top of the stack
	 * @throws StackOverflowException if the stack is full
	 */
	@SuppressWarnings("unchecked")
	public boolean push(Object e) throws StackOverflowException {
	
		if(isFull()==false) {
			data[topIndex+1]= (T) e;
			topIndex++;
			return true;
		}
		else
			throw new StackOverflowException();

		}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String message = "";
		for (int i =0; i < size();i++) {
			message+=data[i];
		}
		return message;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		
		String message = "";
		for (int i =0; i < size()-1;i++) {
			message+=data[i]+delimiter;
		}
		message+=data[size()-1];
		return message;
	}
}
