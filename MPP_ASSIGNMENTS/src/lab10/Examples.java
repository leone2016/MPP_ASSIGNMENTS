package lab10;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {

    Function<Employee, String> getName2 = Employee::getName;
    BiConsumer<Employee, String> setName2 = Employee::setName;
    BiFunction<String, String, Integer> compare2 = String::compareTo;
    BiFunction<Integer, Integer, Double> pow2 = Math::pow;
    Function<Apple, Double> getWeight2 = Apple::getWeight;
    Function<String, Integer> parse2 = Integer::parseInt;



    void evaluator() {


        System.out.println("** A: `(Employee e) -> e.getName()` ");
        Function<Employee, String> getName1 = (e) -> e.getName();
        Function<Employee, String> getName2 = Employee::getName;
        System.out.println(getName1.apply(new Employee("Bob")));


        System.out.println("** B. `(Employee e, String s) -> e.setName(s) ");
        Employee bob = new Employee("Bob");
        BiConsumer<Employee, String> setName= (e, name) -> e.setName(name);
        BiConsumer<Employee, String> setName2= Employee::setName;
        setName.accept(bob, "LEO");
        System.out.println(bob);
        setName.accept(bob, "CARL");
        System.out.println(bob);


        //C: `(String s1, String s2) -> s1.compareTo(s2)`
        System.out.println("** C: `(String s1, String s2) -> s1.compareTo(s2)`");
        // Lambda
        BiFunction<String, String, Integer> compare1 = (s1, s2) -> s1.compareTo(s2);
        // Method reference
        BiFunction<String, String, Integer> compare2 = String::compareTo;
        String a = "apple";
        String b = "b";
        System.out.println("Using compare1: " + compare1.apply(a, b));
        System.out.println("Using compare2: " + compare2.apply(a, b));


        System.out.println("** D: `(Integer x, Integer y) -> Math.pow(x, y)`");
        // Lambda
        BiFunction<Integer, Integer, Double> mathPow1 = (a1, b1) -> Math.pow(a1,b1);
        // Method reference
        BiFunction<Integer, Integer, Double> mathPow2 = Math::pow;
        System.out.println("Using mathPow1: " + mathPow1.apply(2, 3));
        System.out.println("Using mathPow2: " + mathPow2.apply(2, 3));


        System.out.println(" **E.** `(Apple a) -> a.getWeight()`");
        Function<Apple, Double> getWeight1 = (Apple a2) -> a2.getWeight();
        Function<Apple, Double> getWeight2 = Apple::getWeight;
        System.out.println("Weight1: " + getWeight1.apply(new Apple(1.5)));
        System.out.println("Weight2: " + getWeight2.apply(new Apple(1.5)));


        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> compareEmp1 = (e1, e2) -> comp.compare(e1, e2);
        BiFunction<Employee, Employee, Integer> compareEmp2 = comp::compare;

        Employee emp2 = new Employee("Charlie");
        System.out.println("Compare Employees: " + compareEmp2.apply(emp2, emp2));
    }

    public static void main(String[] args) {
        Examples ex = new Examples();
        ex.evaluator();
    }

}
