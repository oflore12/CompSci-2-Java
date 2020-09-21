import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * GradeBookTest class will test all methods in GradeBook class.
 * Assignment: JUnit Test Lab
 * Professor: Khandan Moshi
 * Due date: 09/20/2020
 * @author Odalis Flores
 *
 */
public class GradeBookTest {

	/**
	 * @throws java.lang.Exception
	 */
	GradeBook obj1;
	GradeBook obj2;
	@Before
	public void setUp() throws Exception {
		//Create 2 gradebook objects of size 5
		//use addScore to add scores
		obj1= new GradeBook(5);
		obj1.addScore(29);
		obj1.addScore(27);
		obj1.addScore(24);
		obj1.addScore(23);
		obj1.addScore(17);
		obj2=new GradeBook(5);
		obj2.addScore(45);
		obj2.addScore(55);
		obj2.addScore(22);
		obj2.addScore(32);
		obj2.addScore(12);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		obj1=null;
		obj2=null;
	}

	/**
	 * Test method for {@link GradeBook#addScore(double)}.
	 * Test scored were added by calling toString method that displays the scores
	 */
	@Test
	public void testAddScore() {
		assertTrue(obj1.toString().equals("29.0 27.0 24.0 23.0 17.0 "));
		assertTrue(obj2.toString().equals("45.0 55.0 22.0 32.0 12.0 "));
	}

	/**
	 * Test method for {@link GradeBook#sum()}.
	 * Test the sum of both objects by adding them and comparing to the sum method
	 */
	@Test
	public void testSum() {
		assertEquals(120, obj1.sum(), .0001);
		assertEquals(166, obj2.sum(), .0001);
		}

	/**
	 * Test method for {@link GradeBook#minimum()}.
	 * Test the minimum score for each object and compare with min method
	 */
	@Test
	public void testMinimum() {
		assertEquals(17, obj1.minimum(), .0001);
		assertEquals(12, obj2.minimum(), .0001);
		}

	/**
	 * Test method for {@link GradeBook#finalScore()}.
	 * final score is sum - the min, compare value to the finalscore method
	 */
	@Test
	public void testFinalScore() {
		assertEquals(103, obj1.finalScore(), .0001);
		assertEquals(154, obj2.finalScore(), .0001);
		}

	/**
	 * Test method for {@link GradeBook#getScoreSize()}.
	 * Test the score size by callingthe getScoreSize method
	 * should be 5
	 */
	@Test
	public void testGetScoreSize() {
		assertEquals(5, obj1.getScoreSize(), .0001);
		assertEquals(5, obj2.getScoreSize(), .0001);
		}
	/**
	 * Test method for {@link GradeBook#toString()}.
	 * Test toString method, all scores should be separated by a space
	 */
	@Test
	public void testToString() {
		assertTrue(obj1.toString().equals("29.0 27.0 24.0 23.0 17.0 "));
		assertTrue(obj2.toString().equals("45.0 55.0 22.0 32.0 12.0 "));
		}

}
