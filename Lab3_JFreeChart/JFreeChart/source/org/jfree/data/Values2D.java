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
 * -------------
 * Values2D.java
 * -------------
 * (C) Copyright 2002-2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: Values2D.java,v 1.3 2005/03/28 19:40:26 mungady Exp $
 *
 * Changes:
 * --------
 * 28-Oct-2002 : Version 1 (DG);
 *
 */

package org.jfree.data;

/**
 * A general purpose interface that can be used to access a table of values.
 */
public interface Values2D {

    /**
     * Returns the number of rows in the table.
     *
     * @return The row count.
     */
    public int getRowCount();

    /**
     * Returns the number of columns in the table.
     *
     * @return The column count.
     */
    public int getColumnCount();

    /**
     * Returns a value from the table.
     *
     * @param row  the row index (zero-based).
     * @param column  the column index (zero-based).
     *
     * @return The value (possibly <code>null</code>).
     * 
     * @throws IndexOutOfBoundsException if the <code>row</code> 
     *         or <code>column</code> is out of bounds.
     */
    public Number getValue(int row, int column);

	void addValue(int i, int j, int k);

	void addValue1(int i, int j, int k);

	void removeValue(int i, int j);

	void addValue(int i, int j, Number number);

	void addValue1(int i, int j, Number number);

	void addValue11(int row, int column, Number value);

	Comparable<?> getRowKey(int row);

	Comparable<?> getColumnKey(int column);

	int getColumnIndex(Comparable<?> columnKey);

	int getRowIndex(Comparable<?> rowKey);

	Number getValue(Comparable<?> rowKey, Comparable<?> columnKey);

	void addValue(Comparable<?> rowKey, Comparable<?> columnKey, Number value);

	void addValue(Comparable<?> rowKey, Comparable<?> columnKey, int value);

	void removeValue(Comparable<?> rowKey, Comparable<?> columnKey);

	void removeRow(int rowIndex);

	void addValue(Comparable<?> rowKey, Comparable<?> columnKey, Number value, boolean notify, boolean clear);

	void addValue(int rowIndex, int columnIndex, Number value, boolean notify, boolean clear);

	void addValue(int rowIndex, int columnIndex, int value, int previousValue);

	void addValue(int rowIndex, int columnIndex, Number value, boolean notify);

	void addValue(Comparable<?> rowKey, Comparable<?> columnKey, int value, boolean notify);

	void removeRow(Comparable<?> rowKey);

	void removeColumn(int columnIndex);

	void removeColumn(Comparable<?> columnKey);

	void clear();

	void clearAndTrim();

	double getRowCountChangeMultiplier();

	double getColumnCountChangeMultiplier();

}