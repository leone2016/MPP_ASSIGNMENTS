package final_exam;

import java.util.function.BiFunction;

/**
 * Anonymous Inner Class:
 *      Create an instance of MessageFormatter using an anonymous inner class that returns a string in the format:
 * "To <recipient>: <message>"
 * Store it in a variable and use it to format the message "Don't forget the meeting." for the recipient "Alice".
 * Lambda and BiFunction:
 * Java’s standard library has the functional interface BiFunction<T, U, R>.
 * Create a BiFunction<String, String, String> instance with the same logic, using a lambda expression.
 * Store it in a variable and trigger it for "Bob" and "Lunch at 1 PM.".
 * Call Both:
 * Print the results of both steps.
 *
 * Sample Output
 * To Alice: Don't forget the meeting.
 * To Bob: Lunch at 1 PM.
 */
@FunctionalInterface
interface MessageFormatter {
    String format(String recipient, String message);
}


public class _11_functional_interface {

    public static void main(String[] args) {
        MessageFormatter ms = new MessageFormatter() {
            @Override
            public String format(String recipient, String message) {
                return String.format("To %s: %s", recipient, message);
            }
        };

        BiFunction<String, String, String> bif = (x,y) -> String.format("To %s: %s", x, y);

        System.out.println(ms.format("Alice", "Don't forget the meeting."));
        System.out.println(bif.apply("Bob", "Lunch at 1pm."));
    }
}
