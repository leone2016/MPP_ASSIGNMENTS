package final_exam;

import java.util.LinkedHashSet;
import java.util.Optional;

/**
 * Obtain the last element from a LinkedHashSet using reduce() of Java 8 Stream API.
 *
 *       LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
 *       linkedSet.add("Carrot");
 *       linkedSet.add("Broccoli");
 *       linkedSet.add("Spinach");
 *       linkedSet.add("Tomato");
 */
public class _7_LinkedHashSet {

    public static void main(String[] args) {
        //Obtain the last element from a LinkedHashSet using reduce() of Java 8 Stream API.

        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Carrot");
        linkedSet.add("Broccoli");
        linkedSet.add("Spinach");
        linkedSet.add("Tomato");

        Optional<String> lastElement =  linkedSet.stream()
                .reduce((curr, acc) -> acc);


        if (lastElement.isPresent()) {
            System.out.println("Last element: " + lastElement.get());
        } else {
            System.out.println("LinkedHashSet is empty.");
        }

    }
}
