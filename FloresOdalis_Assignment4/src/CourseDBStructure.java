import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
/**
 * implement hash tables with buckets 
 * it will be an array of linked lists of CourseDBElements
 * each CDE with have a hash code that comes from the CRN since CRN are unqiue to course
 * @author Odalis Flores
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	LinkedList<CourseDBElement>[] hashTable;
	private CourseDBElement object;
	private int size=0;
	/**
	 * The first one takes in an integer which represents the estimated size of the hash table. 
	 * @param sizeOfHashTable
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int sizeOfHashTable) {
		hashTable = new LinkedList[sizeOfHashTable];
	}
	/**
	 * The second constructor takes in a String and an int.  The string will be "Testing"
	 * and the int will be the size of the hash table.  This is used only for testing. 
	 * @param testing testing string
	 * @param sizeOfHashTable size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int sizeOfHashTable) {
		hashTable = new LinkedList[sizeOfHashTable];
	}
	
	public CourseDBStructure() {
		hashTable = new LinkedList[100];
	}
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* @param element the CDE to be added
	*/
	@Override
	public void add(CourseDBElement element) {
		int currentIndex = element.hashCode()%getTableSize();
		if(hashTable[currentIndex] == null) {
			hashTable[currentIndex] = new LinkedList<CourseDBElement>();
			hashTable[currentIndex].add(element);
		}
		else hashTable[currentIndex].add(element);
		size++;
	}

	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param element the CDE to be added
	 * @throws IOException 
	*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crnHash = Integer.toString(crn);
		int currentIndex = crnHash.hashCode()%getTableSize();
		
		if(hashTable[currentIndex] != null) {
			int index=hashTable[currentIndex].size();
			index--;
			while(hashTable[currentIndex].get(index).getCRN()!=crn) {
				index--;
			}
			object = hashTable[currentIndex].get(index);
			return object;
		}
		else throw new IOException();
	}

	@Override
	public int getTableSize() {
		return hashTable.length;
	}
}
