package final_exam;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

class Employee {
    private String name;
    private String department;
    private int age;
    private int salary;

    public Employee(String name, String department, int age, int salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class _9_Employee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 28, 53000),
                new Employee("Bob", "Engineering", 35, 76000),
                new Employee("Charlie", "HR", 41, 68000),
                new Employee("David", "Engineering", 29, 82000),
                new Employee("Eva", "Sales", 30, 49000),
                new Employee("Frank", "Engineering", 45, 99000),
                new Employee("Grace", "Sales", 27, 51000),
                new Employee("Heidi", "Engineering", 32, 75000)
        );
        /* ---- salary statistics (one pass) ---- */
        IntSummaryStatistics salaryStats =
                employees.stream()
                        .mapToInt(Employee::getSalary)
                        .summaryStatistics();

        /* ---- age statistics (one pass) ---- */
        IntSummaryStatistics ageStats =
                employees.stream()
                        .mapToInt(Employee::getAge)
                        .summaryStatistics();

        long totalEmployees = employees.size();

        System.out.println("Total number of employees : " + totalEmployees);
        System.out.printf( "Average salary             : %.2f%n", salaryStats.getAverage());
        System.out.println("Highest salary             : " + salaryStats.getMax());
        System.out.println("Lowest salary              : " + salaryStats.getMin());
        System.out.println("Total salary (sum)         : " + salaryStats.getSum());
        System.out.printf( "Average age                : %.2f%n", ageStats.getAverage());


    }
}
