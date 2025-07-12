package final_exam;

import java.util.*;
import java.util.concurrent.*;

public class _12_ThemeParkTest {
    public static void main(String[] args) throws InterruptedException {
        Set<_12_ChocolateDispenser> dispensers = ConcurrentHashMap.newKeySet();
        ExecutorService festivalWorkers = Executors.newFixedThreadPool(10);

        Runnable setupTask = () -> {
            _12_ChocolateDispenser dispenser = _12_ChocolateDispenser.getInstance();
            dispensers.add(dispenser);
        };

        // 10 festival workers all try to set up the dispenser at once!
        for (int i = 0; i < 10; i++) {
            festivalWorkers.submit(setupTask);
        }

        festivalWorkers.shutdown();
        festivalWorkers.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Unique _12_ChocolateDispenser instances: " + dispensers.size());
        System.out.println("Number of times dispenser setup happened: " + _12_ChocolateDispenser.getSetupCount());
        System.out.println("Did chaos happen (singleton broken)? " +
                (dispensers.size() > 1 || _12_ChocolateDispenser.getSetupCount() > 1 ? "Yes!" : "No. System safe."));

        /**
         * Why did chaos (multiple setups) occur?
         * How can you protect the chocolate (make the singleton thread-safe)?
         * What could happen in a real-world system (data corruption, wasted resources, etc.) if you don’t enforce the singleton?
         *
         */
    }

}
