package lab4;

import java.time.Month;

public abstract class Employee {
    private final String employeeId;

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    public void print(){
        System.out.println("Employee ID: " + this.employeeId);
    }
    public Paycheck calcCompensation(Month month, int year){
        double grossPay = calcGrossPay(month, year);

        return new Paycheck(grossPay);
    }
    public abstract double calcGrossPay(Month month, int year);


}
