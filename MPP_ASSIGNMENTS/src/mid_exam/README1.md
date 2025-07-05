# MED-TERM-EXAM PRACTICE

## EX 2
In a government system, each Person is issued exactly one Passport, and each Passport is associated with exactly one Person. The system must allow you to:

Track a Person’s Passport and a Passport’s Person.

Ensure that no Person can have more than one Passport, and no Passport can belong to more than one Person.

When a new Person is created, a new Passport is automatically created and linked to that Person.

**Tasks**

- Identify the classes involved.
  - **Person**
  - **Passport**
- List the names of the classes that are needed for this scenario.
  - **Person**
  - **Passport**
- Describe the relationship between the classes.
  - Relation one to one
  - [Person] 1 < -----> 1 [Passport]
  - Each person has one passport
  - One Passport is assigned for one person.
- State the type of multiplicity and how the references are maintained.
  - The `Person` class **creates and owns** a `Passport` upon construction.
  - Both classes hold references to each other.
  - Passport constructor is **package-private** or **private** to prevent direct creation outside of `Person`.
- Write Java code for the classes that models this one-to-one relationship.
- Your code should ensure each Person object has a unique Passport, and vice versa.
- Include constructors and necessary methods to maintain the relationship.

```java
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice Smith", "P1234567");
        System.out.println(p);
        System.out.println(p.getPassport());

        // Ensure one-to-one link
        assert p.getPassport().getPerson() == p;
    }
}

```

```java
public class Person {
    private String name;
    private Passport passport;

    public Person(String name, String passportNumber) {
        this.name = name;
        this.passport = new Passport(passportNumber, this);
    }

    public String getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', passport=" + passport.getPassportNumber() + "}";
    }
}

```

```java
public class Passport {
    private String passportNumber;
    private Person person;

    // Only Person can create Passport
    Passport(String passportNumber, Person person) {
        this.passportNumber = passportNumber;
        this.person = person;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Passport{passportNumber='" + passportNumber + "', person=" + person.getName() + "}";
    }
}

```

