package lab5.prob4;

import java.time.LocalDate;

public class CustOrderFactory {

    private CustOrderFactory() {}

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order createOrder(Customer customer, LocalDate date) {
        return Order.newOrder(customer,date);
    }
}
