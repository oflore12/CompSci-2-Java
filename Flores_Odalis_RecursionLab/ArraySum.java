/**
 * Write a recursive method to sum the values in an array of integers.
 * Create a file ArraySum.java and add the recursive method 
 * public int sumOfArray (Integer[] a,int index)
 * Note that ‘a’ is an array of type Integer that is specified 
 * in the driver file, and ‘index’ is an integer that shows which number in the array to sum next.  
 * Use the driver class ArraySumDriver.java to populate your array and demonstrate that your method works.  
 * Lab: Recursion lab
 * Class: CMSC 204, CRN:23859
 * Professor: Khandan Vahabzadeh Monshi
 * @author Odalis R. Flores
 * Due date: 09/29/2020
 */
public class ArraySum {
	/**
	 * sumOfArray recursion sum of array
	 * @param a array of integers
	 * @param index of the last element to sum
	 * @return
	 */
	public int sumOfArray (Integer[] a,int index) {
		if(index==0)
			return a[index];
		return (sumOfArray(a, index-1)+ a[index]);
	}

}
