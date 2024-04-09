package org.jfree.data;
 
import java.util.ArrayList;
import java.util.List;
 
public class CustomValues2D implements Values2D {
 
    private final List<List<Number>> data;
 
    public CustomValues2D(double[][] data) {
        this.data = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            List<Number> rowData = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                rowData.add(data[i][j]);
            }
            this.data.add(rowData);
        }
    }
 
    @Override
    public int getRowCount() {
        return data.size();
    }
 
    @Override
    public int getColumnCount() {
        if (!data.isEmpty()) {
            return data.get(0).size();
        }
        return 0;
    }
 
    @Override
    public Number getValue(int row, int column) {
        if (row < 0 || row >= getRowCount() || column < 0 || column >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        return data.get(row).get(column);
    }
 
    // Additional methods needed for testing
    public void addValue(int row, int column, Number value) {
        if (row < 0 || row >= getRowCount() || column < 0 || column >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        data.get(row).set(column, value);
    }
 
    public void removeValue(int row, int column) {
        if (row < 0 || row >= getRowCount() || column < 0 || column >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        data.get(row).set(column, null);
    }
 
	@Override
	public void addValue1(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue1(int i, int j, Number number) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue11(int row, int column, Number value) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public Comparable<?> getColumnKey(int column) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Comparable<?> getRowKey(int row) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public void addValue(Comparable<?> rowKey, Comparable<?> columnKey, int value) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(Comparable<?> rowKey, Comparable<?> columnKey, Number value) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public Number getValue(Comparable<?> rowKey, Comparable<?> columnKey) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public int getRowIndex(Comparable<?> rowKey) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public int getColumnIndex(Comparable<?> columnKey) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public double getColumnCountChangeMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public double getRowCountChangeMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public void clearAndTrim() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void removeColumn(Comparable<?> columnKey) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void removeColumn(int columnIndex) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void removeRow(Comparable<?> rowKey) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(int rowIndex, int columnIndex, int value, int previousValue) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(int rowIndex, int columnIndex, Number value, boolean notify) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(Comparable<?> rowKey, Comparable<?> columnKey, int value, boolean notify) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(int rowIndex, int columnIndex, Number value, boolean notify, boolean clear) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void addValue(Comparable<?> rowKey, Comparable<?> columnKey, Number value, boolean notify, boolean clear) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void removeValue(Comparable<?> rowKey, Comparable<?> columnKey) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void removeRow(int rowIndex) {
		// TODO Auto-generated method stub
		
	}
}