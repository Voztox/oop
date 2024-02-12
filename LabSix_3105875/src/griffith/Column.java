//Mert Faruk Gunes - 3105875
package griffith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Column<T, V> {
	private HashMap<T, LinkedHashSet<V>> hash;

	public Column() {
		hash = new HashMap<>();
	}

	public void addValue(T field, V value) {
		if (!hash.containsKey(field)) {
			hash.put(field, new LinkedHashSet<>());
		}
		hash.get(field).add(value);
	}

	//method for removing the value
	public void removeValue(T field, V value) {
		if (hash.containsKey(field)) {
			hash.get(field).remove(value);
		}
	}

	public T getField() {
		return hash.keySet().iterator().next();
	}
	//arraylist for values.
	public ArrayList<V> getValues() {
		ArrayList<V> values = new ArrayList<>();
		for (LinkedHashSet<V> set : hash.values()) {
			values.addAll(set);
		}
		return values;
	}
}
