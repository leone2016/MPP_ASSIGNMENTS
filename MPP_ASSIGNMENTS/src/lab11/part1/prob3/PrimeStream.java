package lab11.part1.prob3;

import java.util.stream.Stream;

/**
 * This exercise asks you to work with potentially infinite streams of prime numbers.
 * A. To begin, create a final variable Stream<Integer> primes that contains all prime
 * numbers (in particular, the Stream is infinite). Generate the primes using the iterate
 * method of Stream – do not use the map or filter Stream operations.
 *
 * B. Next, create a variation of the primes Stream that can be called multiple times by a
 * method printFirstNPrimes(long n), which prints to the console the first n prime
 * numbers. Note that the Stream primes that you created in part A cannot be used a
 * second time; how can you get around that limitation? Prove that you succeeded by calling
 * the method printFirstNPrimes(long n) (from a main method) more than once.
 * If you succeed, you should be able to run the following code without getting a runtime
 * exception:
 * public static void main(String[] args) {
 * PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
 * ps.printFirstNPrimes(10);
 * System.out.println("====");
 * ps.printFirstNPrimes(5);
 * }
 */
public class PrimeStream {

    // Utility
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Part A: Creates an infinite stream of primes
    private Stream<Integer> generatePrimes() {
        return Stream.iterate(2, i -> i + 1)
                .filter(this::isPrime); // Allowed here because it's inside a method
    }

    // Part B: Prints first n primes (safe to call multiple times)
    public void printFirstNPrimes(long n) {
        generatePrimes()
                .limit(n)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
