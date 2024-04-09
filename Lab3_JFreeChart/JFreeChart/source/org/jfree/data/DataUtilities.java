package org.jfree.data;
 
public class DataUtilities {
 
    public static double calculateRowTotal(Values2D data, int row) {
        if (data == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        int columnCount = data.getColumnCount();
        double total = 0.0;
        for (int column = 0; column < columnCount; column++) {
            Number value = data.getValue(row, column);
            if (value != null) {
                total += value.doubleValue();
            }
        }
        return total;
    }
 
    public static Number[] createNumberArray(double[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        int length = data.length;
        Number[] result = new Number[length];
        for (int i = 0; i < length; i++) {
            result[i] = data[i];
        }
        return result;
    }
 
    public static Number[][] createNumberArray2D(double[][] data) {
        if (data == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        int rowCount = data.length;
        Number[][] result = new Number[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            int columnCount = data[i].length;
            result[i] = new Number[columnCount];
            for (int j = 0; j < columnCount; j++) {
                result[i][j] = data[i][j];
            }
        }
        return result;
    }
 
	public static Object getCumulativePercentages(DefaultKeyedValues data) {
		// TODO Auto-generated method stub
		return null;
	}
}