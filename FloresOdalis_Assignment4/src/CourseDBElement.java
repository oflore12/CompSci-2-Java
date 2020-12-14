/**
 * CourseDBElement implements Comparable, and consists of five attributes: 
 * the Course ID (a String), 
 * the CRN (an int), 
 * the number of credits (an int), 
 * the room number (a String), 
 * and the instructor name (a String).   
 * Normally the CourseDBElement will be an object consisting of these five attributes, 
 * and is referred to as a CDE.
 * @author Odalis Flores
 * Professor: Khandan Monshi
 * Class: CMSC 204
 * Assignment 4
 */
public class CourseDBElement implements Comparable{
	private String courseID;
	private int CRN;
	private int numOfCredits;
	private String roomNum;
	private String instructorName;
	
	/**
	 * Empty constructor
	 */
	public CourseDBElement() {
		this.courseID=null;
		this.CRN=0;
		this.numOfCredits=0;
		this.roomNum=null;
		this.instructorName=null;
	}
	
	/**
	 * Constructor that creates object for this class
	 * @param courseID the course ID
	 * @param crn the course CRN number
	 * @param numOfCredits the number of credits for class
	 * @param roomNum the room number for class
	 * @param instructorName the name of the instructor for class
	 */
	public CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructorName) {
		this.courseID=courseID;
		this.CRN=crn;
		this.numOfCredits=numOfCredits;
		this.roomNum=roomNum;
		this.instructorName=instructorName;
	}
	

	/**
	 * hashCode for CRN because CRN is unique to every class
	 * @return the hashcode for CRN
	 */
	@Override
	public int hashCode() {
		return crnToString().hashCode();
	}
	/**
	 * @param element a CourseDBElement
	 * @return a negative integer if x.compareTo(y) < 0, 
	 * zero if x.compareTo(y) == 0,
	 * and a positive integer if x.compareTo(y) > 0.
	 */
	public int compareTo(CourseDBElement element) {
		if(element.getCRN()- CRN <0)
			return -1;
		else if (element.getCRN()-CRN<0)
			return 1;
		else return 0;
	}
	
//	/**
//	 * the getter for course ID
//	 * @return the course ID
//	 */
//	public String getCourseID() {
//		return courseID;
//	}
//	/**
//	 * the setter for course ID
//	 * @param courseID the course ID
//	 */
//	public void setCourseID(String courseID) {
//		this.courseID = courseID;
//	}
	/**
	 * crnToString converts the integer CRN to a string
	 * @return the string contents of CRN
	 */
	public String crnToString() {
		return Integer.toString(CRN);
	}
	/**
	 * getter for course CRN
	 * @return the course crn
	 */
	public int getCRN() {
		return CRN;
	}
	/**
	 * setter for class CRN
	 * @param crn the class crn
	 */
	public void setCRN(int crn) {
		this.CRN = crn;
	}
//	/**
//	 * the getter for room number for class
//	 * @return the room number for class
//	 */
//	public String getRoomNum() {
//		return roomNum;
//	}
//	/**
//	 * the setter for the number for class
//	 * @param roomNum the room number for class
//	 */
//	public void setRoomNum(String roomNum) {
//		this.roomNum = roomNum;
//	}
//	/**
//	 * the getter for class instructor name
//	 * @return the class instructor name
//	 */
//	public String getInstructorName() {
//		return instructorName;
//	}
//	/**
//	 * the setter for class instructor name 
//	 * @param instuctorName the class instructor
//	 */
//	public void setInstructorName(String instuctorName) {
//		this.instructorName = instuctorName;
//	}
//	/**
//	 * the getter for number of credits for class
//	 * @return the number of credits for class
//	 */
//	public int getNumOfCredits() {
//		return numOfCredits;
//	}
//	/**
//	 * the setter for number of credits
//	 * @param numOfCredits the number of credits
//	 */
//	public void setNumOfCredits(int numOfCredits) {
//		this.numOfCredits = numOfCredits;
//	}
//	
	/**
	 * toString for this element
	 * @return the attributes for this class shown as ex. Course:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450
	 */
	public String toString() {
//		return ("Course:"+ getCourseID() + 
//				" CRN:" + getCRN() + 
//				" Credits:"+ getNumOfCredits()+
//				" Instructor:"+ getInstructorName()+
//				" Room:" + getRoomNum() );
		return ("Course:"+ courseID + 
		" CRN:" + getCRN() + 
		" Credits:"+ numOfCredits+
		" Instructor:"+ instructorName+
		" Room:" + roomNum );
	}
}
