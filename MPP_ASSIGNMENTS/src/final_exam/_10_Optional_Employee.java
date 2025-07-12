package final_exam;

import java.util.*;
import java.util.stream.*;

/**
 * Print all employees, showing "No Manager" if managerName is missing, using Optional.ofNullable.
 * Print the names of employees whose salary is not yet assigned (salary is null), using Optional.ofNullable.
 * Find the average salary for each department, ignoring employees whose salary is missing (null).
 */
class Employee2 {
    private String name;
    private String department;
    private Double salary;
    private String managerName;

    public Employee2(String name, String department, Double salary, String managerName) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.managerName = managerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
public class _10_Optional_Employee {

    public static void main(String[] args) {
        List<Employee2> employees = Arrays.asList(
                new Employee2("Alice", "HR", 53000.0, "Bob"),
                new Employee2("Bob", "HR", 65000.0, null),
                new Employee2("Charlie", "Engineering", null, "Diana"),
                new Employee2("Diana", "Engineering", 92000.0, null),
                new Employee2("Eva", "Sales", 47000.0, "Frank"),
                new Employee2("Frank", "Sales", 69000.0, null),
                new Employee2("Grace", "Sales", null, "Frank")
        );

        System.out.println("=== All Employees (with manager info) ===");
        employees.forEach(e -> {
            String manager = Optional.ofNullable(e.getManagerName()).orElse("No Manager");
            System.out.println(e.getName() + " (Manager: " + manager + ")");
        });

        System.out.println("\n=== Employees without Salary Assigned ===");
        employees.stream()
                .filter(e -> Optional.ofNullable(e.getSalary()).isEmpty())
                .map(Employee2::getName)
                .forEach(System.out::println);

        System.out.println("\n=== Average Salary by Department ===");
        employees.stream()
                .filter(e -> e.getSalary() != null)
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.averagingDouble(Employee2::getSalary)
                ))
                .forEach((dept, avgSalary) ->
                        System.out.printf("%s: %.2f%n", dept, avgSalary));
    }

}
