package final_exam;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

class Employee {
    private final int employeeId;
    private final String name;
    private final LocalDate dateOfJoining;

    public Employee(int employeeId, String name, LocalDate dateOfJoining) {
        this.employeeId = employeeId;
        this.name = name;
        this.dateOfJoining = dateOfJoining;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public LocalDate getDateOfJoining() { return dateOfJoining; }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
/*
Write a method called getEmployeesSortedByJoiningDate that returns a list sorted:
●	By dateOfJoining (earliest first)
●	Then by name (A–Z)
●	If two employees have the same name and joining date, sort by a unique employee ID (ascending).
Use the Java Stream API for sorting.

Method Signature:
public List<Employee> getEmployeesSortedByJoiningDate(List<Employee> employees)

●	Test different joining dates (should sort by date).
●	Test same date, different names (should sort by name).
●	Test same date and name, different IDs (should sort by employeeId).
●	Test with an empty list.
*/
public class _22_TrackEmployee {
    public static List<Employee> getEmployeesSortedByJoiningDate(List<Employee> employees) {
        return employees.stream().sorted(
                Comparator.comparing(Employee::getDateOfJoining)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getEmployeeId)
        ).toList();
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(104, "Charlie", LocalDate.of(2022, 5, 1)),
                new Employee(101, "Alice", LocalDate.of(2020, 5, 1)),
                new Employee(103, "Alice", LocalDate.of(2020, 5, 1)),
                new Employee(102, "Bob", LocalDate.of(2019, 3, 1)),
                new Employee(105, "David", LocalDate.of(2023, 1, 15)),
                new Employee(106, "Eve", LocalDate.of(2020, 5, 1))
        );

        List<Employee> sorted = getEmployeesSortedByJoiningDate(employees);

        System.out.println("Sorted Employees:");
        sorted.forEach(System.out::println);
    }
}
