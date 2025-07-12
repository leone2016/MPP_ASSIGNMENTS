package final_exam;
import java.util.*;

class Car {
    private final String brand;
    private final String model;
    private final int    price;
    private final int    year;

    public Car(String brand, String model, int price, int year) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year  = year;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int    getPrice() { return price; }
    public int    getYear()  { return year; }

    @Override
    public String toString() {
        return "Car{brand='%s', model='%s', price=%d, year=%d}"
                .formatted(brand, model, price, year);
    }
}

public class _8_Car_Sorted {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Volvo",   "XC40",    25000, 2020),
                new Car("Fiat",    "500",     18000, 2022),
                new Car("Volvo",   "XC60",    35000, 2022),
                new Car("Skoda",   "Octavia", 22000, 2021),
                new Car("Fiat",    "Panda",   15000, 2021),
                new Car("Renault", "Clio",    17000, 2020),
                new Car("Volvo",   "XC40",    27000, 2022),
                new Car("Skoda",   "Fabia",   17500, 2022)
        );

        cars.stream()
                .sorted(
                        Comparator.comparing(Car::getBrand)                    // 1) brand A→Z
                                .thenComparing(Car::getModel)                // 2) model A→Z
                                .thenComparing(Comparator.comparing(Car::getPrice).reversed())  // 3) price high→low
                                .thenComparingInt(Car::getYear))             // 4) year low→high
                .forEach(System.out::println);
    }
}