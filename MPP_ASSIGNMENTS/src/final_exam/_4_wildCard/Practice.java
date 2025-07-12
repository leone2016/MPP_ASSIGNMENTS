package final_exam._4_wildCard;
import java.util.*;

/** Simple class hierarchy */
class A             { @Override public String toString() { return "A"; } }
class B extends A   { @Override public String toString() { return "B"; } }
class C extends B   { @Override public String toString() { return "C"; } }
class D extends C   { @Override public String toString() { return "D"; } }

public class Practice {

    public static void main(String[] args) {

        /* -----------------------------------------------------------
         * 1. Build an ordinary List<B> that actually contains B and C
         * ----------------------------------------------------------- */
        List<B> concreteList = new ArrayList<>();
        concreteList.add(new B());
        concreteList.add(new C());     // C IS-A B, so this is allowed
        // concreteList.add(new A());  // ❌ compile-time error

        /* -----------------------------------------------------------
         * 2. Assign to an UPPER-bounded wildcard reference
         *      List<? extends A>  (Producer = "extends")
         * ----------------------------------------------------------- */
        List<? extends A> extendsList = concreteList;

        // ✅ Reading is safe – every element is *at least* an A
        A first = extendsList.get(0);
        System.out.println("First element from extendsList -> " + first);

        // ❌ Writing is **not** allowed (except null)
        // extendsList.add(new B());   // compile-time ERROR
        // extendsList.add(new C());   // compile-time ERROR
        extendsList.add(null);         // the only permitted value

        /* -----------------------------------------------------------
         * 3. Assign to a LOWER-bounded wildcard reference
         *      List<? super B>  (Consumer = "super")
         * ----------------------------------------------------------- */
        List<? super B> superList = new ArrayList<A>();   // could also be new ArrayList<Object>()

        // ✅ You can add B or any subclass of B
        superList.add(new B());
        superList.add(new C());
        superList.add(new D());

        // ❌ Reading only guarantees Object
        Object x = superList.get(0);
        System.out.println("First element from superList -> " + x);

        /* -----------------------------------------------------------
         * 4. Methods that demonstrate PECS (“Producer Extends / Consumer Super”)
         * ----------------------------------------------------------- */
        printAll(extendsList);          // PRODUCER – only reads              ( ? extends A )
        addTwoElements(superList);      // CONSUMER – only writes             ( ? super  B )
    }

    /** A producer method – it only needs to *read* elements */
    private static void printAll(List<? extends A> list) {
        for (A a : list) {
            System.out.println("printAll -> " + a);
        }
    }

    /** A consumer method – it only needs to *write* B (or subclasses) */
    private static void addTwoElements(List<? super B> list) {
        list.add(new B());
        list.add(new C());
        System.out.println("addTwoElements -> size now " + list.size());
    }
}