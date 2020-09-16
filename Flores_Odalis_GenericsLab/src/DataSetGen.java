
/**
 *  Start with the DataSet class and make it into a generic DataSetGen class.  
 * This class should load any instance of a class that implements Measurable, 
 * and no classes that do not implement Measurable. Test it with the DataSetTester
 * Generic lab
 * CMSC 204 Fall 2020
 * Prof. Khandan Vahabzadeh Monsh
 * @author Odalis Flores 
 * Due date: 09/15/2020
 * Description: Start with the DataSet class and make it into a generic DataSetGen class.  
 * This class should load any instance of a class that implements Measurable, 
 * and no classes that do not implement Measurable.  Test it with the DataSetTester
 *
 * @param <T> a data type
 */
public class DataSetGen <T extends Measurable>{
	private double sum;
	private T maximum;
	private int count;

	   /**
	      Constructs an empty data set.
	   */
	   public DataSetGen()
	   {
	      sum = 0;
	      count = 0;
	      maximum = null;
	   }

	   /**
	      Adds a data value to the data set.
	      @param x a data value
	   */
	   public void add(T x)
	   {
	      sum = sum + x.getMeasure();
	      if (count == 0 || maximum.getMeasure() < x.getMeasure())
	         maximum = x;
	      count++;
	   }

	   /**
	      Gets the average of the added data.
	      @return the average or 0 if no data has been added
	   */
	   public double getAverage()
	   {
	      if (count == 0) return 0;
	      else return sum / count;
	   }

	   /**
	      Gets the largest of the added data.
	      @return the maximum or 0 if no data has been added
	   */
	   public T getMaximum()
	   {
	      return maximum;
	   }

}