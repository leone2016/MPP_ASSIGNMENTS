package final_exam;

import java.util.*;
import java.util.concurrent.*;

public class _12_ThemeParkTest__T {
    public static void main(String[] args) throws InterruptedException {
        Set<_12_ChocolateDispenser_T> dispensers = ConcurrentHashMap.newKeySet();
        ExecutorService festivalWorkers = Executors.newFixedThreadPool(10);

        Runnable setupTask = () -> {
            _12_ChocolateDispenser_T dispenser = _12_ChocolateDispenser_T.getInstance();
            dispensers.add(dispenser);
        };

        // 10 festival workers all try to set up the dispenser at once!
        for (int i = 0; i < 10; i++) {
            festivalWorkers.submit(setupTask);
        }

        festivalWorkers.shutdown();
        festivalWorkers.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Unique _12_ChocolateDispenser instances: " + dispensers.size());
        System.out.println("Number of times dispenser setup happened: " + _12_ChocolateDispenser_T.getSetupCount());
        System.out.println("Did chaos happen (singleton broken)? " +
                (dispensers.size() > 1 || _12_ChocolateDispenser_T.getSetupCount() > 1 ? "Yes!" : "No. System safe."));

        /**
         * Why did chaos (multiple setups) occur?
         *
         *      This check is not synchronized. In a multithreaded environment, the following can happen:
         *      Thread A checks instance == null → it's true
         *      Thread B checks instance == null → also true (before Thread A finishes creating it)
         *      Both threads proceed to create a new instance → singleton is broken
         * How can you protect the chocolate (make the singleton thread-safe)?
         * Fix it with: synchronized or double-checked locking with volatile.
         * What could happen in a real-world system (data corruption, wasted resources, etc.) if you don’t enforce the singleton?
         * 🌍 Real-World Consequences of a Broken Singleton
         * Problem	Description
         * Data corruption:	    Multiple instances can lead to conflicting writes (e.g., double dispensing chocolate 🍫).
         * Wasted resources:	Extra objects = more memory, unnecessary connections, file handles, etc.
         * Inconsistent state:	Logging, config files, caches, or payment processors might show strange behavior.
         * Hard-to-debug bugs:	Race conditions are often non-deterministic and painful to trace.
         */
    }

}
