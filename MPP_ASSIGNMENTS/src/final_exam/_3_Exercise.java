package final_exam;


/**
 * Suppose you are designing a payment system for an e-commerce platform. Create a Java interface named PaymentProcessor
 * that meets the following requirements:
 *
 * Contains one abstract method boolean processPayment(double amount) for processing a payment of a given amount.
 * Includes one default method void printReceipt(double amount) that prints a receipt message, calling a private helper
 * method inside the interface to format the message.
 * Has one static method boolean validateCard(String cardNumber) that returns true if the given card number has exactly 16 digits.
 * Uses one private method String formatReceipt(double amount) that returns a formatted string, e.g., "Receipt: Paid $45.50".
 * Write a class CreditCardPayment that implements this interface and always returns true from processPayment.
 */

interface PaymentProcessor{
    boolean processPayment(double amount);

    static boolean validateCard(String numberCard) {
        return numberCard.matches("\\d{16}") ;
    }

    private String formatReceipt(double amount) {
        return String.format("Receipt: Paid $%.2f", amount);
    }

    default void printReceipt(double amount){
        System.out.println(formatReceipt(amount));;
    }
}
public class _3_Exercise  implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    @Override
    public void printReceipt(double amount) {
        PaymentProcessor.super.printReceipt(amount);
    }

    public static void main(String[] args) {
        _3_Exercise test = new _3_Exercise();
        test.printReceipt(10000);

        String testCard = "123456789009876  ";
        System.out.println("Card valid: " + PaymentProcessor.validateCard(testCard));
    }
}
