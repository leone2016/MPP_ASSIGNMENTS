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

### Method Evaluation

Create a method in your `Examples` class called `evaluator`.
 Inside `evaluator`, evaluate each of your method expressions using input arguments of your own choosing.

#### Example:

```java
void evaluator() {
    System.out.println(toUpper2.apply("hello"));
    // test your other method references
}
```