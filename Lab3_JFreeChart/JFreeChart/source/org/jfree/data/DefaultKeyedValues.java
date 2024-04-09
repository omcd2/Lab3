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
 * -----------------------
 * DefaultKeyedValues.java
 * -----------------------
 * (C) Copyright 2002-2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: DefaultKeyedValues.java,v 1.9 2005/07/01 14:43:50 mungady Exp $
 *
 * Changes:
 * --------
 * 31-Oct-2002 : Version 1 (DG);
 * 11-Feb-2003 : Fixed bug in getValue(key) method for unrecognised key (DG);
 * 05-Mar-2003 : Added methods to sort stored data 'by key' or 'by value' (DG);
 * 13-Mar-2003 : Implemented Serializable (DG);
 * 08-Apr-2003 : Modified removeValue(Comparable) method to fix bug 717049 (DG);
 * 18-Aug-2003 : Implemented Cloneable (DG);
 * 27-Aug-2003 : Moved SortOrder from org.jfree.data --> org.jfree.util (DG);
 * 09-Feb-2004 : Modified getIndex() method - see bug report 893256 (DG);
 * 15-Sep-2004 : Updated clone() method and added PublicCloneable 
 *               interface (DG);
 * 25-Nov-2004 : Small update to the clone() implementation (DG);
 * 24-Feb-2005 : Added methods addValue(Comparable, double) and 
 *               setValue(Comparable, double) for convenience (DG);
 *
 */

// DefaultKeyedValues.java
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultKeyedValues implements KeyedValues, Serializable {
    private static final long serialVersionUID = 8468154364608194797L;
    private List<KeyedValue> data;

    public DefaultKeyedValues() {
        this.data = new ArrayList<>();
    }

    public int getItemCount() {
        return this.data.size();
    }

    public Number getValue(int index) {
        return this.data.get(index).getValue();
    }

    public Comparable getKey(int index) {
        return this.data.get(index).getKey();
    }

    public int getIndex(Comparable key) {
        for (int i = 0; i < getItemCount(); i++) {
            if (getKey(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public List<Comparable> getKeys() {
        List<Comparable> keys = new ArrayList<>();
        for (KeyedValue keyedValue : this.data) {
            keys.add(keyedValue.getKey());
        }
        return keys;
    }

    public Number getValue(Comparable key) {
        int index = getIndex(key);
        return index >= 0 ? getValue(index) : null;
    }

    public void addValue(Comparable key, double value) {
        addValue(key, Double.valueOf(value));
    }

    public void addValue(Comparable key, Number value) {
        setValue(key, value);
    }

    public void setValue(Comparable key, double value) {
        setValue(key, Double.valueOf(value));
    }

    public void setValue(Comparable key, Number value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int index = getIndex(key);
        if (index >= 0) {
            this.data.get(index).setValue(value);
        } else {
            this.data.add(new DefaultKeyedValue(key, value));
        }
    }

    public void removeValue(int index) {
        this.data.remove(index);
    }

    public void removeValue(Comparable key) {
        int index = getIndex(key);
        if (index >= 0) {
            removeValue(index);
        }
    }

    // Other methods...
}
