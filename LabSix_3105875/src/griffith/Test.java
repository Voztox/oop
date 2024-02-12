//Mert Faruk Gunes - 3105875
package griffith;

public class Test {
	public static void main(String[] args) {
		Table<String, Object> table = new Table<>();
		//example inputs.
		table.addColumn("Name", "Mert");
		table.addColumn("Age", 21);
		table.addColumn("Gender", "male");
		table.addColumn("Salary", 1000.0);
		table.addColumn("Address", "South Circular Rd.");
		table.addColumn("Phone", "831-6918");
		// adding columns
		System.out.println("All fields: " + table.getAllFields());
		System.out.println("All values: " + table.getAllValues());

		for (Column<String, Object> column : table) {
			System.out.println("Field: " + column.getField());
			System.out.println("Values: " + column.getValues());
		}
	}
}