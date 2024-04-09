package org.jfree.data.test;
 
import java.security.InvalidParameterException;
 
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;
 
import junit.framework.TestCase;
 
public class DataUtilitiesTest extends TestCase
{
	private Values2D values2D;
	public void setUp()
	{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    values2D = testValues;
	    testValues.addValue(1, 0, 0);
	    testValues.addValue(4, 1, 0);
	}
	public void tearDown()
	{
	    values2D = null;
	}
	public void testValidDataAndColumnTotal()
	{
		assertEquals("Wrong sum returned. It should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.000000001d);
	}
	public void testNullDataColumnTotal()
	{
		try
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception thrown",
					e.getClass().equals(InvalidParameterException.class));
		}	
	}
	@SuppressWarnings("rawtypes")
	@Test // getCumulativePercentages function
	public void testgetCumulativePercentages() {
		// setup
		DefaultKeyedValues keyvalues = new DefaultKeyedValues() ;
		keyvalues.addValue((Comparable) 0.0, 6.0);
		keyvalues.addValue((Comparable) 1.0, 11.0);
		keyvalues.addValue((Comparable) 2.0, 3.0);
		keyedValues object_under_test = (keyedValues) DataUtilities.getCumulativePercentages ((KeyedValues) keyvalues);
		assertEquals(1.0, ((KeyedValues) object_under_test).getValue(2), 0.000000001d);
 
	}
 
	private void assertEquals(double d, Number value, double e) {
		// TODO Auto-generated method stub
	}
}