package final_exam;

/**
 * 13.	Your company is developing two different Java applications for its operations:
 *
 * Scenario 1: Real-Time Chat Server
 * The chat server receives thousands of short messages per minute from users. Each message needs to be
 * processed and broadcast to the intended recipients as quickly as possible. Most message-processing tasks
 * are very brief (less than 100ms). During traffic spikes (e.g., lunchtime), the number of simultaneous messages
 * can suddenly jump.
 *
 * Scenario 2: Image Processing Service
 * The image service processes uploaded images (e.g., resizing, filtering) for a social media app.
 * Each image-processing task can take several seconds or more. The number of image uploads at a time
 * is typically limited and predictable. Your server has 8 CPU cores and you want to avoid overloading it.
 *
 * For each scenario, which thread pool implementation (Executors.newCachedThreadPool() or
 * Executors.newFixedThreadPool(int n)) would you choose?
 *
 * Clearly state your choice for each application.
 * Justify your answer with respect to performance, resource usage, and system stability.
 */
public class _13_Company_Apps__T {
    public static void main(String[] args) {
        //scenario 1: real time chat server
        /**
         * Choice: Executors.newCachedThreadPool()
         *
         *  Choice: Executors.newCachedThreadPool()
         *
         * 🔍 Justification:
         *
         * Short-lived tasks: Each message takes < 100ms → a cached thread pool is efficient for handling many fast tasks.
         *
         * Bursty traffic: Cached thread pool can grow dynamically to handle spikes in load (e.g., lunchtime).
         *
         * Low thread reuse latency: Threads are reused if available, and idle threads are terminated after 60 seconds.
         *
         * Avoids bottlenecks: Unlike a fixed-size pool, it won't block message processing during spikes.
         *
         * ⚠️ Caveat: You must still monitor memory and CPU to ensure that a very high number of threads doesn't exhaust system resources.
         */

        //scenario 2: Image Proceccion Service
        /**
         * Choice: Executors.newFixedThreadPool(int 6)
         * 🔍 Justification:
         *
         * CPU-bound, long-running tasks: Each task takes several seconds → limit thread count to prevent CPU thrashing.
         *
         * Predictable load: You said the number of uploads is typically limited and predictable.
         *
         * System stability: A fixed pool ensures you don’t exceed the number of CPU cores and maintain optimal performance.
         *
         * Controlled concurrency: Prevents resource exhaustion by limiting the number of simultaneous image processing threads.
         *
         * 💡 Tip: You might even consider newFixedThreadPool(6) instead of 8 to leave room for OS and other tasks.
         */
    }
}
