//Mert Faruk Gunes - 3105875
package griffith;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table<T, V> implements Iterable<Column<T, V>> {
	private List<Column<T, V>> columns;

	public Table() {
		columns = new ArrayList<>();
	}

	public void addColumn(T field, V value) {
		Column<T, V> column = getColumn(field);
		//adding columns
		if (column == null) {
			column = new Column<>();
			column.addValue(field, value);
			columns.add(column);
		} else {
			column.addValue(field, value);
		}
	}
	//method for removing columns
	public void removeColumn(T field) {
		Column<T, V> column = getColumn(field);
		if (column != null) {
			columns.remove(column);
		}
	}
	//method for getting the fields
	public List<T> getAllFields() {
		List<T> fields = new ArrayList<>();
		for (Column<T, V> column : columns) {
			fields.add(column.getField());
		}
		return fields;
	}
	//method for adding values
	public void addValue(T field, V value) {
		Column<T, V> column = getColumn(field);
		if (column != null) {
			column.addValue(field, value);
		}
	}
	//method for removing values
	public void removeValue(T field, V value) {
		Column<T, V> column = getColumn(field);
		if (column != null) {
			column.removeValue(field, value);
		}
	}
	//method for checking values
	public ArrayList<V> getValues(T field) {
		Column<T, V> column = getColumn(field);
		if (column != null) {
			return column.getValues();
		}
		return new ArrayList<>();
	}
	//method for checking all values
	public ArrayList<V> getAllValues() {
		ArrayList<V> values = new ArrayList<>();
		for (Column<T, V> column : columns) {
			values.addAll(column.getValues());
		}
		return values;
	}
	//method for checking columns
	private Column<T, V> getColumn(T field) {
		for (Column<T, V> column : columns) {
			if (column.getField().equals(field)) {
				return column;
			}
		}
		return null;
	}
	//just an iterator.
	@Override
	public Iterator<Column<T, V>> iterator() {
		return columns.iterator();
	}
}