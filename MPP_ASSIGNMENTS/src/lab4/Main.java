package lab4;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        Hourly emp1 = new Hourly("EH001", 23, 40);
        Salaried emp2 = new Salaried("ES001", 4000);
        Commissioned emp3 = new Commissioned("EC001", 2000, 0.10);

        emp3.addOrder(new Orders(1, LocalDate.of(2024, Month.MAY, 10), 10000));
        emp3.addOrder(new Orders(2, LocalDate.of(2024, Month.JUNE, 5), 8000));
        emp3.addOrder(new Orders(3, LocalDate.of(2024, Month.JUNE, 12), 7000));

        System.out.println("Hourly Employee:");
        emp1.calcCompensation(Month.JUNE, 2024).print();
        System.out.println("\nSalaried Employee:");
        emp2.calcCompensation(Month.JUNE, 2024).print();
        System.out.println("\nCommissioned Employee:");
        emp3.calcCompensation(Month.JUNE, 2024).print();
    }
}
