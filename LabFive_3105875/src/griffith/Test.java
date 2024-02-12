//Mert Faruk Gunes - 3105875
package griffith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// 4 products
		Product first = new Product("Bread", 1.56);
		Product second = new Product("Butter", 3.15);
		Product third = new Product("Chocolate", 2.01);
		Product fourth = new Product("Napkins", 1.56);

		// Array list for 5 products.
		ArrayList<Product> order = new ArrayList<>();
		order.add(first);
		order.add(second);
		order.add(third);
		order.add(fourth);

		// Using clone or copy constructor, add two of the same products to the order list
		try {
			Product cloneProduct = new Product(first);
			order.add(cloneProduct);

			Product copyProduct = new Product(third);
			order.add(copyProduct);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		// assert for testing.
		assert first.equals(fourth) : "First and Fourth should be equal";
		assert first.hashCode() == fourth.hashCode() : "Hash codes for First and Fourth should be equal";

		assert !first.equals(second) : "First and Second should not be equal";
		assert first.hashCode() != second.hashCode() : "Hash codes for First and Fourth should not be equal";

		// sorting
		Collections.sort(order);

		// Write each product to Order.txt file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt"))) {
			writer.write("Code, Title, Price,");
			writer.newLine();
			for (Product product : order) {
				writer.write(product.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// file for order condensed
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderCondensed.txt"))) {
			writer.write("Amount, Code, Title, Price,");
			writer.newLine();

			// Sorting
			Comparator<Product> priceThenTitleComparator = Comparator.comparingDouble(Product::getPrice).thenComparing(Product::getTitle);
			Collections.sort(order, priceThenTitleComparator);

			// writing each product
			int amount = 1;
			for (int i = 1; i < order.size(); i++) {
				if (order.get(i).equals(order.get(i - 1))) {
					amount++;
				} else {
					writer.write(amount + "," + order.get(i - 1).toString());
					writer.newLine();
					amount = 1;
				}
			}
			// Write the last product
			writer.write(amount + "," + order.get(order.size() - 1).toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
