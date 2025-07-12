package final_exam;

/**
 * Your team is designing a backend for a ride-sharing app. Two services require parallel processing:
 *
 * Service A: Driver Location Updates
 * Thousands of drivers report their GPS location every few seconds. Each update is a tiny, fast operation
 * (takes a few milliseconds to process). The number of incoming updates fluctuates a lot, especially during
 * rush hour or special events.
 *
 * Service B: Ride Fare Calculation
 * Each time a ride ends, a fare calculation job is triggered. Fare calculation involves fetching user data,
 * promotions, map routes, and can take 2–4 seconds per ride. Your server has 16 CPU cores and is also running
 * other backend services. You want to avoid excessive CPU contention and keep the backend responsive.
 *
 * For each service above, would you choose a cached thread pool or a fixed thread pool?
 *
 * Clearly state your choice for each service.
 * Explain your reasoning, focusing on resource management, latency, and scalability.
 */
public class _14_Ride_Sharing_app_T {

    /**
     * SERVICE A:
     *Choice: Executors.newCachedThreadPool()
     *
     * ✅ Reasoning:
     *
     * Short tasks (~milliseconds): Ideal for cached thread pools which can spawn many threads temporarily and reuse them efficiently.
     *
     * Highly variable load: Cached pools grow dynamically, perfect for spikes during rush hours or events.
     *
     * Low overhead per thread: Since tasks are lightweight, the CPU won’t be overwhelmed even with a high thread count.
     *
     * Fast response needed: Minimizing queue wait time helps preserve low-latency GPS update handling.
     *
     * 📌 Summary:
     *
     * newCachedThreadPool() ensures high throughput and responsiveness for a massive, fluctuating number of tiny, fast operations.
     *
     * SERVICE B:
     * Reasoning:
     *
     * Longer, CPU-bound tasks (2–4 seconds): A fixed number of threads prevents overloading the CPU and keeps system stable.
     *
     * Server has 16 cores: To balance load with other backend services, use fewer than 16 threads, e.g., 8 or 12.
     *
     * Avoid contention: Too many threads doing heavy processing can hurt overall responsiveness due to context switching or memory pressure.
     *
     * Predictable rate: Fare calculations are tied to ride completions, which is more stable compared to location updates.
     */
}
