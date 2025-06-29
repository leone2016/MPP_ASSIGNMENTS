package lab4;

import java.time.Month;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String employeeId, double salary) {
        super(employeeId);
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(Month month, int year) {
        return this.salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
