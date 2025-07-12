package final_exam;

import java.util.*;

class Warehouse<T> {
    private final Deque<T> stack = new ArrayDeque<>();

    /** Adds an item to the warehouse (push). */
    public void addItem(T item) {
        stack.push(item);
    }

    /** Retrieves and removes the most-recently added item (pop). */
    public T retrieveLastItem() {
        return stack.poll();         // returns null if empty
    }

    /** Current number of items stored. */
    public int getItemCount() {
        return stack.size();
    }
}

// Book.java
record Book(String title, String author) {}

// Laptop.java
record Laptop(String brand, String model) {}
public class _16_Warehouse {

    public static void main(String[] args) {
        /* -------- Books -------- */
        Warehouse<Book> bookWarehouse = new Warehouse<>();
        bookWarehouse.addItem(new Book("Effective Java", "Joshua Bloch"));
        bookWarehouse.addItem(new Book("Clean Code", "Robert C. Martin"));
        bookWarehouse.addItem(new Book("The Pragmatic Programmer", "Hunt & Thomas"));
        System.out.println("Book count: " + bookWarehouse.getItemCount());

        Book lastBook = bookWarehouse.retrieveLastItem();
        System.out.println("Retrieved last book: " + lastBook);
        System.out.println("Book count after retrieval: " + bookWarehouse.getItemCount());

        /* -------- Laptops -------- */
        Warehouse<Laptop> laptopWarehouse = new Warehouse<>();
        laptopWarehouse.addItem(new Laptop("Apple",  "MacBook Pro"));
        laptopWarehouse.addItem(new Laptop("Dell",   "XPS 13"));
        laptopWarehouse.addItem(new Laptop("Lenovo", "ThinkPad X1 Carbon"));
        System.out.println("\nLaptop count: " + laptopWarehouse.getItemCount());

        Laptop lastLaptop = laptopWarehouse.retrieveLastItem();
        System.out.println("Retrieved last laptop: " + lastLaptop);
        System.out.println("Laptop count after retrieval: " + laptopWarehouse.getItemCount());
    }
}
