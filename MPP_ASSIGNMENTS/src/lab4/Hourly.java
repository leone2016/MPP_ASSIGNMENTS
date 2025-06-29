package lab4;

import java.time.Month;

public class Hourly extends Employee {

    private double hourlyWage;
    private double hourlyPerWeek;
    public static final int WEEKS_PER_MONTH = 4;

    public Hourly(String employeeId, double hourlyWage, double hourlyPerWeek) {
        super(employeeId);
        this.hourlyWage = hourlyWage;
        this.hourlyPerWeek = hourlyPerWeek;
    }

    @Override
    public double calcGrossPay(Month month, int year) {
        return hourlyWage * hourlyPerWeek * WEEKS_PER_MONTH;
    }
}
