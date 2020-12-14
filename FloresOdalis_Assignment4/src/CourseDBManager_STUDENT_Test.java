import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface dbm = new CourseDBManager();
	
	
	CourseDBElement element1= new CourseDBElement("ENGL101",10050,4,"HM203","David Lastname");
	CourseDBElement element2= new CourseDBElement("CMSC140",12345,3,"CS104","CompFirst SciLast");

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dbm = new CourseDBManager();

	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dbm = null;
	}


	@Test
	public void testAdd() {
		try {
			dbm.add("ENGL101",10050,4,"HM203","David Lastname");
			dbm.add("CMSC140",12345,3,"CS104","CompFirst SciLast");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testGet() {
		try {
			dbm.add("ENGL101",10050,4,"HM203","David Lastname");
			dbm.add("CMSC140",12345,3,"CS104","Not the same");
			assertEquals(dbm.get(10050).toString(),element1.toString());
			assertFalse(dbm.get(12345).toString().equals(element2.toString()));
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testReadFile() {
		try {
			File inputFile = new File("StudentTest.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC140 12345 3 CS104 CompFirst CompLast");
			inFile.println("CMSC203 12344 4 CS332 Science Teacher");
			inFile.println("ENGL102 34567 5 HM303 English Teacher");
			inFile.print("SOCY100 45678 2 HM100 Socilogy Teacher");
			inFile.close();
			dbm.readFile(inputFile);
			ArrayList<String> list = dbm.showAll();
			assertEquals(list.get(1),"\nCourse:CMSC140 CRN:12345 Credits:3 Instructor:CompFirst CompLast Room:CS104");
			assertEquals(list.get(0),"\nCourse:CMSC203 CRN:12344 Credits:4 Instructor:Science Teacher Room:CS332");
			assertEquals(list.get(2),"\nCourse:ENGL102 CRN:34567 Credits:5 Instructor:English Teacher Room:HM303");
			assertEquals(list.get(3),"\nCourse:SOCY100 CRN:45678 Credits:2 Instructor:Socilogy Teacher Room:HM100");
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	public void testShowAll() {
		
		dbm.add("ENGL101",10050,3,"HM203","David Lastname");
		dbm.add("CMSC140",12345,3,"CS104","CompFirst SciLast");
		dbm.add("CMSC140",15672,3,"CS104","CompFirst SciLast");
		dbm.add("CMSC203",12346,4,"HM200","Science Teacher");
		ArrayList<String> list = dbm.showAll();
		assertEquals(list.get(0),"\nCourse:ENGL101 CRN:10050 Credits:3 Instructor:David Lastname Room:HM203");
		assertEquals(list.get(1),"\nCourse:CMSC140 CRN:12345 Credits:3 Instructor:CompFirst SciLast Room:CS104");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:12346 Credits:4 Instructor:Science Teacher Room:HM200");
		assertEquals(list.get(3),"\nCourse:CMSC140 CRN:15672 Credits:3 Instructor:CompFirst SciLast Room:CS104");
		assertTrue(list.size()==dbm.showAll().size());
	}

}
