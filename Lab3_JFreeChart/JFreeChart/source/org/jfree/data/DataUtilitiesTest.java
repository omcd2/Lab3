/* ===========================================================
* JFreeChart : a free chart library for the Java(tm) platform
* ===========================================================
*
* (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
*
* Project Info:  http://www.jfree.org/jfreechart/index.html
*
* This library is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation; either version 2.1 of the License, or
* (at your option) any later version.
*
* This library is distributed in the hope that it will be useful, but
* WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
* or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
* License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this library; if not, write to the Free Software Foundation,
* Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
*
* [Java is a trademark or registered trademark of Sun Microsystems, Inc.
* in the United States and other countries.]
*
* ------------------
* DataUtilities.java
* ------------------
* (C) Copyright 2003-2005, by Object Refinery Limited.
*
* Original Author:  David Gilbert (for Object Refinery Limited);
* Contributor(s):   -;
*
* $Id: DataUtilities.java,v 1.2 2005/05/17 12:24:00 mungady Exp $
*
* Changes
* -------
* 05-Mar-2003 : Version 1 (DG);
* 03-Mar-2005 : Moved createNumberArray() and createNumberArray2D() methods
*               from the DatasetUtilities class (DG);
* 17-May-2005 : Added calculateColumnTotal() and calculateRowTotal()
*               methods (DG);
*
*/

package org.jfree.data;
 
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
 
import org.junit.Test;
 
public class DataUtilitiesTest {
 
	public double calculateColumnTotal(Values2D data, int column) {
	    double total = 0.0;
	    for (int i = 0; i < data.getRowCount(); i++) {
	        total += (double) data.getValue(i, column); // Mutated line
	    }
	    return total;
	}
	
    @Test
    public void testCalculateColumnTotalWithEmptyData() {
        Values2D data = new CustomValues2D(new double[][]{});
        assertEquals(0.0, DataUtilities.calculateRowTotal(data, 0), 0.0001);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotalNullData() {
        DataUtilities.calculateRowTotal(null, 0);
    }
 
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotalInvalidColumnIndex() {
        Values2D data = new CustomValues2D(new double[][]{{1.0, 2.0}});
        DataUtilities.calculateRowTotal(data, 2);
    }
 
    @Test
    public void testCalculateRowTotal() {
        Values2D data = new CustomValues2D(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        assertEquals(3.0, DataUtilities.calculateRowTotal(data, 0), 0.0001);
        assertEquals(7.0, DataUtilities.calculateRowTotal(data, 1), 0.0001);
    }
 
    @Test
    public void testCalculateRowTotalWithEmptyData() {
        Values2D data = new CustomValues2D(new double[][]{});
        assertEquals(0.0, DataUtilities.calculateRowTotal(data, 0), 0.0001);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotalNullData() {
        DataUtilities.calculateRowTotal(null, 0);
    }
 
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotalInvalidRowIndex() {
        Values2D data = new CustomValues2D(new double[][]{{1.0, 2.0}});
        DataUtilities.calculateRowTotal(data, 2);
    }
 
    @Test
    public void testCreateNumberArray() {
        double[] data = {1.0, 2.5, 3.8};
        Number[] expected = {1.0, 2.5, 3.8};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArrayNull() {
        DataUtilities.createNumberArray(null);
    }
 
    @Test
    public void testCreateNumberArrayWithEmptyData() {
        double[] data = {};
        Number[] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
 
    @Test
    public void testCreateNumberArray2D() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
 
    @Test
    public void testCreateNumberArray2DWithNullData() {
        double[][] data = null;
        try {
            DataUtilities.createNumberArray2D(data);
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2DWithEmptyData() {
        double[][] data = {};
        DataUtilities.createNumberArray2D(data);
    }
 
    @Test
    public void testCalculateColumnTotalWithNullValues() {
        Values2D data = new CustomValues2D(new double[][]{{1.0, 2.0}, {Double.NaN, 4.0}});
        assertEquals(1.0, DataUtilities.calculateRowTotal(data, 0), 0.0001);
        assertEquals(6.0, DataUtilities.calculateRowTotal(data, 1), 0.0001);
    }
 
    @Test
    public void testCalculateRowTotalWithNullValues() {
        Values2D data = new CustomValues2D(new double[][]{{1.0, Double.NaN}, {3.0, 4.0}});
        assertEquals(1.0, DataUtilities.calculateRowTotal(data, 0), 0.0001);
        assertEquals(7.0, DataUtilities.calculateRowTotal(data, 1), 0.0001);
    }
 
    @Test
    public void testCreateNumberArrayWithMixedValues() {
        double[] data = {-1.0, 2.5, 0.0, -3.8};
        Number[] expected = {-1.0, 2.5, 0.0, -3.8};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
 
    @Test
    public void testCreateNumberArray2DWithJaggedArray() {
        double[][] data = {{1.0, 2.0}, {3.0}};
        Number[][] expected = {{1.0, 2.0}, {3.0, Double.NaN}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
 
    @Test
    public void testCreateNumberArray2DWithNaNValues() {
        double[][] data = {{1.0, Double.NaN}, {3.0, 4.0}};
        Number[][] expected = {{1.0, Double.NaN}, {3.0, 4.0}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
 
    @Test
    public void testCreateNumberArray2DWithEmptyData1() {
        double[][] data = {};
        Number[][] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
}