import java.util.ArrayList;
/**
 * Create a generic queue class called NotationQueue that will implement 
 * the QueueInterface given you. You will be creating NotationQueue from scratch.
 * 
 * Professor: Khandan Vahabzadeh Monshi
 * Assignment 2: Notation
 * Class: CMSC 204, CRN: 23859
 * @author Odalis R. Flores
 *
 * @param <T> generic type
 */
public class NotationQueue<T> implements QueueInterface{
	
	private ArrayList<T> queue;
	private int size;
	/**
	 * Default constructor
	 */
	public NotationQueue() {
		this.size =100;
		this.queue=new ArrayList<>(size);
	}
	/**
	 * Constructor that accepts integer size that creates a new arraylist of that size
	 * @param size integer size of arraylist queue
	 */
	public NotationQueue(int size) {
		this.size =size;
		this.queue=new ArrayList<>(size);
	}
	/**
	 * Constructor that accepts an arraylist and adds all those elements to the 
	 * arraylist
	 * @param newArr arraylist to be copied to queue array
	 */
	public NotationQueue(ArrayList<T> newArr) {
		this.size=newArr.size();
		this.queue= new ArrayList<>(size);
		queue.addAll(newArr);
	}
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if(queue.isEmpty()!=true)
			return false;
		else return true;
	}

	/**
	 * Determines of the Queue is empty
	 * @return true is the size method is equal to the field size
	 */
	public boolean isFull() {
		if(size()==size)
			return true;
		else return false;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException{
		if(isEmpty()==true) {
			throw new QueueUnderflowException();
		}
		else {
			T temp = queue.get(0);
			queue.remove(0);
			return temp;
		}
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return queue.size();
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@SuppressWarnings("unchecked")
	public boolean enqueue(Object e) throws QueueOverflowException{	
		if(isFull()==true)
			throw new QueueOverflowException();
		else {
			queue.add((T) e);
			return true;
		}
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
			String message = "";
			for (int i =0; i < queue.size();i++) {
				message+=queue.get(i);
			}
			return message;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String message = "";
		for (int i =0; i < queue.size();i++) {
			if(i==queue.size()-1)
				message+=queue.get(queue.size()-1);
			else
				message+=queue.get(i)+delimiter;
		}
		return message;
}
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) {
		for(Object n: list) {
			queue.add((T) n);
		}
	}
}

