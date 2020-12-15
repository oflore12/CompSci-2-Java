import java.util.Comparator;
import java.util.ListIterator;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument.Iterator;
/**
 * Implements a generic sorted double list using a provided Comparator. 
 * It extends BasicDoubleLinkedList class.
 * @author Odalis Flores
 * Professor Khandan Monshi
 * Assignment 3
 * @param <T>
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{
	
	Comparator<T>comparator;
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator2 Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		this.comparator=comparator2;
	}
	/**
	 * Inserts the specified element at the correct position in the sorted list. 
	 * Notice we can insert the same element several times. Your implementation 
	 * must traverse the list only once in order to perform the insertion. 
	 * Do not implement this method using iterators. 
	 * Notice that you don't need to call any of the super class methods in order 
	 * to implement this method.
	 * @param data the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data){
		return null;
	    }
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException 
	 * will be generated using the message "Invalid operation for sorted list."
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException 
	 * will be generated using the message "Invalid operation for sorted list."
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @return data element or null
	 */
	public SortedDoubleLinkedList<T> remove (T data, Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
	
}