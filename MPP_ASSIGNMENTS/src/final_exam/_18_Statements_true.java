package final_exam;
/*
Which of the following statements are true? (Choose all that apply.)
A. Comparable is in the java.util package.
B. Comparator is in the java.util package.
C. compare() is in the Comparable interface.
D. compare() is in the Comparator interface.
E. compare() takes one method parameter.
F. compare() takes two method parameters.


 */
public class _18_Statements_true {
    /*
    B, D, F
     */

    /*
    ✅ Breakdown of each option:
        Option	Statement	True/False	Explanation
        A	Comparable is in the java.util package.	❌ False	Comparable is in java.lang, not java.util.
        B	Comparator is in the java.util package.	✅ True	Comparator is in java.util.
        C	compare() is in the Comparable interface.	❌ False	Comparable uses the compareTo() method, not compare().
        D	compare() is in the Comparator interface.	✅ True	Comparator defines compare(T o1, T o2).
        E	compare() takes one method parameter.	❌ False	compare() takes two parameters. You might be thinking of compareTo() in Comparable, which takes one.
        F	compare() takes two method parameters.	✅ True	The method signature is int compare(T o1, T o2);
     */
}
