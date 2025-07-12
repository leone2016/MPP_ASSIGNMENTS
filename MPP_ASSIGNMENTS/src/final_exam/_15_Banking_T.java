package final_exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
You are developing a banking application. At the end of the day, your system needs to process hundreds of
deposits made by different customers to the same bank account.

* You create a shared BankAccount object with a balance. Each deposit is performed in its own thread (using executor.execute(Runnable)).
* You need to ensure that the final balance is correct after all deposits—i.e., all deposits are applied
    safely, with no lost updates due to concurrency.

* Implement a BankAccount class with methods to deposit money and get the balance.
* Launch N deposit tasks in parallel using executor.execute(), each depositing $100.
* Print the final balance after all deposits have completed.
* Ensure thread-safety so the final balance is correct (N * $100 + initial balance).

 */
public class _15_Banking_T {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        int numDeposits = 100; // Number of parallel deposits
        int amount = 100; // Each deposit amount

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < numDeposits; i++) {
            executor.execute(() -> account.deposit(amount));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS); // Wait for all tasks

        System.out.println("Final Balance: $" + account.getBalance());
        System.out.println("Expected Balance: $" + (numDeposits * amount));
    }

}

class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " by " + Thread.currentThread().getName() +
                ", New Balance: " + balance);
    }

    public int getBalance() {
        return balance;
    }
}
