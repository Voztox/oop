//Mert Faruk Gunes - 3105875
package griffith;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private static int nextCode = 1;
    private final int productCode;
    private String title;
    private double price;

    // Constructor
    public Product(String title, double price) throws IllegalArgumentException {
        setTitle(title);
        setPrice(price);
        productCode = nextCode++;
    }

    // constructor
    public Product(Product otherProduct) throws IllegalArgumentException {
        this.productCode = otherProduct.productCode;
        this.title = otherProduct.title;
        this.price = otherProduct.price;
    }

    // getter 
    public int getCode() {
        return productCode;
    }

    // getter setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    // getter setter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    // toString method
    @Override
    public String toString() {
        return "code =" + productCode + ", title='" + title + "', price=" + price;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productCode == product.productCode;
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(productCode);
    }

    // Implement Comparable
    @Override
    public int compareTo(Product otherProduct) {
        return this.title.compareTo(otherProduct.title);
    }
}
