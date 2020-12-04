import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Write the classes required to create a Morse Code Converter Utility. 
 * Your Morse Code Converter Utility will be using a generic linked binary tree 
 * with generic TreeNodes to convert Morse Code into English
 * Professor: Khandan Vahabzadeh Monshi
 * Assignment 5: Morse code converter
 * Class: CMSC 204, CRN: 23859
 * @author Odalis R. Flores
 * Due date: 12/03/2020
 */

public class MorseCodeTreeTest {
	private MorseCodeTree testTree=new MorseCodeTree();
	private TreeNode<String> testNode;
	private String code ="h s v i f u e l r a p w j  b d x n c k y t z g q m o ";

	@Before
	public void setUp() throws Exception {
		this.testNode = new TreeNode<String>("test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRoot() {
		TreeNode<String> testRoot = testTree.getRoot();
		assertEquals(testRoot, testTree.getRoot());
	}

	@Test
	public void testSetRoot() {
		try {
			testTree.setRoot(testNode);
			assertEquals(testNode, testTree.getRoot());
			}
		catch (Exception e){
			assertTrue("Threw an exception", false);
			}
	}

	@Test
	//you can test this class by implementing find node
	public void testInsert() {
		testTree.insert(".....", "blank");
		assertEquals("blank", testTree.fetch("....."));
	}

	@Test
	public void testAddNode() {
		assertEquals(testTree.nodeAddedSuccessfully(true), true);
	}

	@Test
	public void testFetch() {
		String testingT = "t";
		assertEquals(testingT, testTree.fetch("-"));
	}

	@Test
	public void testFetchNode() {
		try {
			assertEquals("a", testTree.fetch(".-"));
			assertEquals("b", testTree.fetch("-..."));
			assertEquals("c", testTree.fetch("-.-."));
			assertEquals("d", testTree.fetch("-.."));
			assertEquals("e", testTree.fetch("."));
			assertEquals("f", testTree.fetch("..-."));
			assertEquals("g", testTree.fetch("--."));
			assertEquals("h", testTree.fetch("...."));
			assertEquals("i", testTree.fetch(".."));
			assertEquals("j", testTree.fetch(".---"));
			assertEquals("k", testTree.fetch("-.-"));
			assertEquals("l", testTree.fetch(".-.."));
			assertEquals("m", testTree.fetch("--"));
			assertEquals("n", testTree.fetch("-."));
			assertEquals("o", testTree.fetch("---"));
			assertEquals("p", testTree.fetch(".--."));
			assertEquals("q", testTree.fetch("--.-"));
			assertEquals("r", testTree.fetch(".-."));
			assertEquals("s", testTree.fetch("..."));
			assertEquals("t", testTree.fetch("-"));
			assertEquals("u", testTree.fetch("..-"));
			assertEquals("v", testTree.fetch("...-"));
			assertEquals("w", testTree.fetch(".--"));
			assertEquals("x", testTree.fetch("-..-"));
			assertEquals("y", testTree.fetch("-.--"));
			assertEquals("z", testTree.fetch("--.."));
			}
		catch (Exception e){
			assertEquals("n", testTree.fetch("--.."));
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
			}
	}

	@Test
	public void testBuildTree() {
		String buildTree="";
		for(int i=0; i<testTree.toArrayList().size(); i++) {
			buildTree+= testTree.toArrayList().get(i)+" ";
		}
		assertEquals(code, buildTree);
	}

	@Test
	public void testToArrayList() {
		try {
			assertEquals("h", testTree.toArrayList().get(0));
			assertEquals("s", testTree.toArrayList().get(1));
			assertEquals("v", testTree.toArrayList().get(2));
			assertEquals("i", testTree.toArrayList().get(3));
			assertEquals("f", testTree.toArrayList().get(4));
			assertEquals("u", testTree.toArrayList().get(5));
			assertEquals("e", testTree.toArrayList().get(6));
			assertEquals("l", testTree.toArrayList().get(7));
			assertEquals("r", testTree.toArrayList().get(8));
			assertEquals("a", testTree.toArrayList().get(9));
			assertEquals("p", testTree.toArrayList().get(10));
			assertEquals("w", testTree.toArrayList().get(11));
			assertEquals("j", testTree.toArrayList().get(12));
			assertEquals("", testTree.toArrayList().get(13));
			assertEquals("b", testTree.toArrayList().get(14));
			assertEquals("d", testTree.toArrayList().get(15));
			assertEquals("x", testTree.toArrayList().get(16));
			assertEquals("n", testTree.toArrayList().get(17));
			assertEquals("c", testTree.toArrayList().get(18));
			assertEquals("k", testTree.toArrayList().get(19));
			assertEquals("y", testTree.toArrayList().get(20));
			assertEquals("t", testTree.toArrayList().get(21));
			assertEquals("z", testTree.toArrayList().get(22));
			assertEquals("g", testTree.toArrayList().get(23));
			assertEquals("q", testTree.toArrayList().get(24));
			assertEquals("m", testTree.toArrayList().get(25));
			assertEquals("o", testTree.toArrayList().get(26));
			}
		catch (Exception e){
			assertEquals("o", testTree.toArrayList().get(27));
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
			}
	}

	@Test
	public void testLNRoutputTraversal() {
		try {
			assertEquals("h", testTree.toArrayList().get(0));
			assertEquals("s", testTree.toArrayList().get(1));
			assertEquals("v", testTree.toArrayList().get(2));
			assertEquals("i", testTree.toArrayList().get(3));
			assertEquals("f", testTree.toArrayList().get(4));
			assertEquals("u", testTree.toArrayList().get(5));
			assertEquals("e", testTree.toArrayList().get(6));
			assertEquals("l", testTree.toArrayList().get(7));
			assertEquals("r", testTree.toArrayList().get(8));
			assertEquals("a", testTree.toArrayList().get(9));
			assertEquals("p", testTree.toArrayList().get(10));
			assertEquals("w", testTree.toArrayList().get(11));
			assertEquals("j", testTree.toArrayList().get(12));
			assertEquals("", testTree.toArrayList().get(13));
			assertEquals("b", testTree.toArrayList().get(14));
			assertEquals("d", testTree.toArrayList().get(15));
			assertEquals("x", testTree.toArrayList().get(16));
			assertEquals("n", testTree.toArrayList().get(17));
			assertEquals("c", testTree.toArrayList().get(18));
			assertEquals("k", testTree.toArrayList().get(19));
			assertEquals("y", testTree.toArrayList().get(20));
			assertEquals("t", testTree.toArrayList().get(21));
			assertEquals("z", testTree.toArrayList().get(22));
			assertEquals("g", testTree.toArrayList().get(23));
			assertEquals("q", testTree.toArrayList().get(24));
			assertEquals("m", testTree.toArrayList().get(25));
			assertEquals("o", testTree.toArrayList().get(26));
			}
		catch (Exception e){
			assertEquals("o", testTree.toArrayList().get(27));
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
			}
	}

	@Test
	public void testDelete() {
		try{
			testTree.delete("Can't Delete :(");
			assertTrue("Did not throw a UnsupportedOperationException",false);
			}
		catch (UnsupportedOperationException e){
			assertTrue("Successfully threw a UnsupportedOperationException",true);
			}
		catch (Exception e){
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
			}
		}

	@Test
	public void testUpdate() {
		try{
			testTree.update();
			assertTrue("Did not throw a UnsupportedOperationException",false);
			}
		catch (UnsupportedOperationException e){
			assertTrue("Successfully threw a UnsupportedOperationException",true);
			}
		catch (Exception e){
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
			}
		}
}
