package final_exam;
/*
21.	You are developing a utility method for an e-commerce site that needs to help customers quickly find an
affordable, in-stock product from a given list of products.

Write a method called findFirstAffordableInStock that accepts a List<Product> and
returns an Optional<Product> representing the first product (in the original list order)
that is in stock and costs less than $500. Use a sequential stream and the findFirst() method.

Method signature:
public Optional<Product> findFirstAffordableInStock(List<Product> products)


Write unit tests for your method using JUnit framework:

●	Test with a list containing several products:
    ○	Some in stock, some not; some under $500, some above.
    ○	Verify that the returned product is the first in the list matching the criteria.
●	Test with a list where no products match:
    ○	All are either out of stock or too expensive.
    ○	Verify that the result is empty.
●	Test with an empty list:
    ○	The result should also be empty.
●	Test the case where multiple products match—ensure only the first one is returned.

 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Product {
    private final String name;
    private final boolean inStock;
    private final double price;
    private final double rating;

    public Product(String name, boolean inStock, double price, double rating) {
        this.name = name;
        this.inStock = inStock;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public boolean isInStock() { return inStock; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", inStock=" + inStock +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}


public class _21_Ecommerce {
    public static Optional<Product> findFirstAffordableInStock(List<Product> products){
        return products.stream()
                .filter(x-> x.isInStock() && x.getPrice() < 500)
                .findFirst();

    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", true, 1200.0, 4.7),
                new Product("Mouse", true, 25.0, 4.2),
                new Product("Monitor", false, 300.0, 4.3),
                new Product("Tablet", true, 450.0, 4.5),
                new Product("Headphones", true, 90.0, 4.1)
        );

        findFirstAffordableInStock(products)
                .ifPresentOrElse(
                        System.out::println,
                        ()->{
                            System.out.println("Product not found");
                        });
    }
}
