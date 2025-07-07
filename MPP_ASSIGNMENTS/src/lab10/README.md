# Lab 10

## 2. Lambda and Method Reference Exercises

Assign the lambda expressions to a variable of the appropriate type and then express as a  
method reference. Indicate which type of method reference you are using. Assume that the  
`Employee` and `EmployeeNameComparator` classes are available. To make it easier, do all this  
inside an `Examples` class in your workspace. Refer to  
[Java Function Package Documentation](http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)  
as necessary.

### Example:
```java
(String x) -> x.toUpperCase()
Function<String, String> toUpper1 = (String x) -> x.toUpperCase();
Function<String, String> toUpper2 = String::toUpperCase;
// Method reference type: Class::instanceMethod
```

### Exercises:

**A.** `(Employee e) -> e.getName()`

```java
Function<Employee, String> getName1 = (e) -> e.getName();
Function<Employee, String> getName2 = Employee::getName;

System.out.println(getName1.apply(new Employee("Bob")));
```

 **B.** `(Employee e, String s) -> e.setName(s)`

```java
BiConsumer<Employee, String> setName= (e, name) -> e.setName(name);
BiConsumer<Employee, String> setName2= Employee::setName;
setName.accept(bob, "LEO");
System.out.println(bob);
setName.accept(bob, "CARL");
System.out.println(bob);
```

 **C.** `(String s1, String s2) -> s1.compareTo(s2)`

```java
// Lambda
BiFunction<String, String, Integer> compare1 = (s1, s2) -> s1.compareTo(s2);
// Method reference
BiFunction<String, String, Integer> compare2 = String::compareTo
String a = "apple";
String b = "b
System.out.println("Using compare1: " + compare1.apply(a, b));
System.out.println("Using compare2: " + compare2.apply(a, b));
```

 **D.** `(Integer x, Integer y) -> Math.pow(x, y)`

```java
// Lambda
BiFunction<Integer, Integer, Double> mathPow1 = (a, b) -> Math.pow(a,b);
// Method reference
BiFunction<Integer, Integer, Double> mathPow2 = Math:pow
System.out.println("Using mathPow1: " + mathPow1.apply(2, 3));
System.out.println("Using mathPow2: " + mathPow2.apply(2, 3));
```

```java
Function<Apple, Double> getWeight1 = (Apple a) -> a.getWeight();
Function<Apple, Double> getWeight2 = Apple::getWeight;
```

 **F.** `(String x) -> Integer.parseInt(x);`

```java
Function<String, Integer> parseInt1 = (String a) -> Integer.parseInt(a);
Function<String, Integer> parseInt2 = Integer::parseInt;
```



 **G.** 

```java
EmployeeNameComparator comp = new EmployeeNameComparator();
(Employee e1, Employee e2) -> comp.compare(e1, e2)

BiFunction<Employee, Employee, Integer> compareEmp1 = (e1, e2) -> comp.compare(e1, e2);
BiFunction<Employee, Employee, Integer> compareEmp2 = comp::compare;
```

---------

## **1. Short Answer**

### **a. Identify Parameters and Free Variables**



```java
Runnable r = () -> {
    int[][] products = new int[s][t];
    for (int i = 0; i < s; i++) {
        for (int j = i + 1; j < t; j++) {
            products[i][j] = i * j;
        }
    }
};

```

**Parameters**: `()` → **none**

**Free variables**: `s`, `t`
 These are free because they are referenced inside the lambda but not defined inside it or passed as parameters.

#### **ii.**

```java
Comparator<String> comp = (s, t) -> {
    if (ignoreCase == true) {
        return s.compareToIgnoreCase(t);
    } else {
        return s.compareTo(t);
    }
};
```

**Parameters**: `(s, t)` → **both parameters**

**Free variable**: `ignoreCase`
 It’s used in the lambda but not declared inside it, so it must come from the enclosing context.

---------

## **b. Method Reference: `Math::random`**

### **i. Rewrite as Lambda Expression**

```java
Supplier<Double> supplier = () -> Math.random();
```

------

### **ii. Use in a `main` Method**

```

import java.util.function.Supplier;

public class RandomLambdaExample {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random();
        System.out.println("Random number: " + supplier.get());
    }
}
```

------

### **iii. Use Inner Class to Replace the Lambda**

```java
import java.util.function.Supplier;

public class RandomInnerClassExample {

    static class RandomSupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }

    public static void main(String[] args) {
        Supplier<Double> supplier = new RandomSupplier();
        System.out.println("Random number: " + supplier.get());
    }
}
```

------

A. Look at the code in the package lesson10.lecture.comparator2. Suppose we sort using
the sort method in the EmployeeInfo class together with the NameComparator. Look at the
compare method in the NameComparator: If two Employee objects have the same name,
what is the return value of compare? This tells us that these Employee objects should be equal,
but is this always true? Give an example of two Employee objects having the same name but
that should not be considered equal. Rewrite the compare method so that, if compare does

return 0, the Employee objects are indeed equal. (This issue is known as consistency with

equals.)

### Problem:

```java
public class NameComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
```

This will treat `Employee("John", 30000)` and `Employee("John", 70000)` as "equal" in a sorted set or map – which violates the contract of consistency with `equals()`.

------

### Fix:

Include a **secondary comparison**, like salary or employee ID:

```
java


CopyEdit
public class NameComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        int result = e1.getName().compareTo(e2.getName());
        if (result == 0) {
            // Tie-breaker: use employee ID or salary
            return Integer.compare(e1.getId(), e2.getId());
        }
        return result;
    }
}
```

This guarantees that `compare(a, b) == 0` implies `a.equals(b)` (assuming `equals()` is based on ID).

------

## **Part B – Fix Comparator in `comparator3`**

Same principle applies:

```
java


CopyEdit
public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        int result = Double.compare(e1.getSalary(), e2.getSalary());
        if (result == 0) {
            return e1.getName().compareTo(e2.getName()); // Secondary condition
        }
        return result;
    }
}
```

------

## *Part C – Fix Comparator Lambda**

For example, this lambda:

```
java


CopyEdit
Comparator<Employee> comp = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
```

 Fix:

```
java


CopyEdit
Comparator<Employee> comp = (e1, e2) -> {
    int result = Double.compare(e1.getSalary(), e2.getSalary());
    if (result == 0) {
        return e1.getName().compareTo(e2.getName()); // or compare IDs
    }
    return result;
};
```

------

## Part D – BiFunction for Power and Product

### Lambda:

```
java


CopyEdit
(x, y) -> {
    List<Double> list = new ArrayList<>();
    list.add(Math.pow(x, y));
    list.add(x * y);
    return list;
}
```

### Full Working Code:

```
java


CopyEdit
import java.util.*;
import java.util.function.BiFunction;

public class PowerAndProduct {
    public static void main(String[] args) {
        BiFunction<Double, Double, List<Double>> func = (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };

        System.out.println(func.apply(2.0, 3.0)); // Output: [8.0, 6.0]
    }
}
```

------

## Part E – Word Count Filter (Good Practice)

```
java


CopyEdit
public int countWords(List<String> words, char c, char d, int len) {
    return (int) words.stream()
        .filter(word -> word.length() == len)
        .filter(word -> word.indexOf(c) != -1)
        .filter(word -> word.indexOf(d) == -1)
        .count();
}
```

------

