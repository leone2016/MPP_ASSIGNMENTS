package lab13;

import java.util.*;

/**
 * 5. Create a generic programming solution to the problem of finding the second smallest
 * element in a list. In other words, devise a public static method
 * secondSmallest so that it can handle the biggest possible range of types.
 */
public class prob5 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println(secondSmallest(list));

        List<String> names = List.of("Amine", "Bassem", "Chris", "Nina", "Kai", "Kristian");
        System.out.println(secondSmallest(names));

    }

    public static <T extends Comparable<T>> T secondSmallest(List<T> list) {
        if (list == null || list.size() < 2)
            throw new IllegalArgumentException("List must have at least 2 elements.");

        List<T> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        T smallest = sorted.getFirst();
        for (T elem : sorted) {
            if (!elem.equals(smallest)) {
                return elem;
            }
        }

        throw new NoSuchElementException("No second smallest element found.");
    }
}
