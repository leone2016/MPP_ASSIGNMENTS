package lab4;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {

    private double baseSalary;
    private double commission;//percentage
    private List<Orders>  orders;


    public Commissioned(String employeeId, double baseSalary, double commission) {
        super(employeeId);
        this.baseSalary = baseSalary;
        this.commission = commission;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Orders order) {
        orders.add(order);
    }

    @Override
    public double calcGrossPay(Month month, int year) {
        int prevMonth = LocalDate.now().getMonthValue()-1;
        double totalSales = 0;
        for(Orders order : orders){
            if(order.getOrderDate().getMonthValue() == prevMonth
            && order.getOrderDate().getYear() == year){
                totalSales += order.getOrderAmount();
            }
        }
        double commissionPerMonth = totalSales * commission/100;
        return baseSalary + commissionPerMonth;
    }
}
