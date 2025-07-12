package final_exam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Car2 {
    String brand;
    int price;

    public Car2(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', price=" + price + "}";
    }
}
public class _6_Car_reduce {
    public static void main(String[] args) {
        List<Car2> Car2s = Arrays.asList(
                new Car2("Skoda", 18544),
                new Car2("Volvo", 22344),
                new Car2("Fiat", 23650),
                new Car2("Renault", 19700),
                new Car2("Volvo", 24500),
                new Car2("Fiat", 21700),
                new Car2("Renault", 19600),
                new Car2("Volvo", 18650),
                new Car2("Fiat", 19800)
        );

        Optional<Car2> mostExpensive = Car2s.stream()
                .reduce((curr, acc) -> curr.getPrice() > acc.getPrice() ? curr : acc);

        mostExpensive.ifPresent(System.out::println);

    }
}
