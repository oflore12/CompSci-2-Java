import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * This generic double-linked list relies on a head (reference to first element
 *  of the list) and tail (reference to the last element of the list). 
 *  Both are set to null when the list is empty. Both point to the same 
 *  element when there is only one element in the list. A node structure has 
 *  only three fields: data and the prev and next references. The class must 
 *  only define the following entities: an inner class Node, an inner class 
 *  that implements ListIterator (for the iterator method), head and tail 
 *  references and an integer representing the list size. 
 *  however only the hasNext(), next(), hasPrevious() and previous() 
 *  methods of ListIterator need to be implemented, all other methods 
 *  can throw the UnsupportedOperationException:
 * @author Odalis Flores
 * Assignment 3 CMSC 204
 * @param <T>
 */
public class BasicDoubleLinkedList <T> implements Iterator<Object>{
	
	protected Node head;
	protected Node tail;
	protected int size=0;
	
	public BasicDoubleLinkedList(){
		head=null;
		tail=null;
	}
	/**
	 * Adds an element to the end of the list. 
	 * Do not use iterators to implement this method.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node end = new Node (data);
		if(head==null) {
			head=tail=end;
		}
		else {
			tail.next=end;
			end.previous=tail;
			tail=end;
		}
		size++;
		return this;
	}
	/**
	 * Adds element to the front of the list. 
	 * Do not use iterators to implement this method.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node front = new Node(data);
		
		if(head==null) {
			head=tail=front;
			size++;
			return this;
		}
		
		front.next= head;
		front.previous = null;
		head=front;
		size++;
		return this;
		

	}
	/**
	 * Removes the first instance of the targetData from the list. 
	 * Notice that you must remove the elements by performing a single traversal 
	 * over the list. You may not use any of the other retrieval methods associated 
	 * with the class in order to complete the removal process. You must use the provided 
	 * comparator (do not use equals) to find those elements that match the target. 
	 * Do not implement this method using iterators.
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		Node current=head;
		if(head==null)
			return null;
		else{
			while(comparator.compare(targetData, current.data)!=0) {
				current=current.next;
			}
			if(current==head) {
				head = head.next;
				size--;
				return this;
			}
			if(current==tail) {
				tail = tail.previous;
				size--;
				return this;
			}
			current.previous=current.next.previous;
			current.next=current.previous;
            size--;
            return this;
		}
	}
	/**
	 * Returns but does not remove the first element from the list. 
	 * If there are no elements the method returns null. 
	 * Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst() {
//		System.out.print("This is the head "+ head.data+"");
		return head.data;
	}
	/**
	 * Returns but does not remove the last element from the list. 
	 * If there are no elements the method returns null.
	 * Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getLast() {
		return tail.data;
	}
	/**
	 * This method just returns the value of the instance variable you use 
	 * to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;	
	}
	/**
	 * This method must be implemented using an inner class that implements ListIterator 
	 * and defines the methods of hasNext(), next(), hasPrevious() and previous(). 
	 * Remember that we should be able to call the hasNext() method as many times as we 
	 * want without changing what is considered the next element.
	 * Specified by:
	 * iterator in interface java.lang.Iterable<T>
	 * @return Instance of iterator inner class
	 * @throws UnsupportedOperationException
	 * @throws NoSuchElementException
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException,NoSuchElementException {
		DoubleIterator nodeIterator = new DoubleIterator();
		return nodeIterator;
	}
	/**
	 * Removes and returns the first element from the list. 
	 * If there are no elements the method returns null. 
	 * Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		Node first = head;
		while(first!=null) {
			head.previous=null;
			head = head.next;
			size--;
			return first.data;
		}
		return null;
	}
	/**
	 * Removes and returns the last element from the list. 
	 * If there are no elements the method returns null. 
	 * Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		Node last = tail;
		while(last!=null) {
			tail.next=null;
			tail = tail.previous;
			size--;
			return last.data;
		}
		return null;
	}
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList(){
        ArrayList<T> list = new ArrayList<>();
        ListIterator<T> nodeIterator = new DoubleIterator();
        while(((BasicDoubleLinkedList<T>.DoubleIterator) nodeIterator).itSize()<size) {
            list.add(nodeIterator.next());
        }
        return list;  
	}		
	/**
	 * inner node class that creates a node based on the previous and next elements
	 * default will set the next and previous to null
	 * @author O_Flores96
	 */
	 class Node {
		 protected T data;
		 protected Node previous;
		 protected Node next;
		 
		public Node(Node previousElement,T element,Node nextElement){
			this.data=element;
			this.previous=previousElement;
			this.next=nextElement;
		}
		public Node(T element){
			 this.data=element;
			 this.previous=null;
			 this.next=null;
		 }
	}
	/**
	 * Iterator imlements list iterator
	 * will iterate through each node by keeping track of the node size
	 * will add class to see current size
	 * starts with current node set to null
	 * @author O_Flores96
	 */
	private class DoubleIterator implements ListIterator<T>{
		protected Node current=null;
		private int elements=0;
		
		public DoubleIterator() {
			this.current=null;
		}
		@Override
		public boolean hasNext() {
			if(current==null&&head!=null) {
				return true;
			}
			else if(elements>0) {
				return current.next!=null;
				}
			else if(elements==size){
				return false;
			}
			else return false;
		}

		@Override
		public T next() {
			if(hasNext()==false)
			throw new NoSuchElementException("no element");
			
			if(current==null&& head!=null) {
				current=head;
				elements++;
				return current.data;
				
			}
			else if(current!=null) {
				current = current.next;
				elements++;
				return current.data;
			}
			else 
				throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			if(elements==size)
				return true;
			else if(elements==1) {
				current=head;
				return true;}
			else if(elements>1) {
				return current.previous!=null;
				}
			else return false;
		}

		@Override
		public T previous() {
			if(hasPrevious()==false)
				throw new NoSuchElementException("no element");
			if(elements==size) {
				elements--;
				return current.data;
				}
			else if(elements ==1) {
				elements--;
				return current.data;
				}
			else if(elements>1) {
				current = current.previous;
				elements--;
				return current.data;
			}
			else throw new NoSuchElementException("no element");
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}
		/**
		 * 
		 * @return the index for elements;
		 */
		public int itSize() {
			return elements;
		}
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
}