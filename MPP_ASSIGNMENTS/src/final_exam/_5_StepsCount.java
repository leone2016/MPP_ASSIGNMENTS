package final_exam;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class _5_StepsCount {

    public static void main(String[] args) {
        Map<String, Integer> stepCounts = Map.ofEntries(
                Map.entry("2024-06-01", 9000),
                Map.entry("2024-06-02", 10700),
                Map.entry("2024-06-03", 11500),
                Map.entry("2024-06-04", 9800),
                Map.entry("2024-06-05", 12500),
                Map.entry("2024-06-06", 13400),
                Map.entry("2024-06-07", 8200),
                Map.entry("2024-06-08", 15600),
                Map.entry("2024-06-09", 12900),
                Map.entry("2024-06-10", 9900),
                Map.entry("2024-06-11", 14700),
                Map.entry("2024-06-12", 8800),
                Map.entry("2024-06-13", 11400),
                Map.entry("2024-06-14", 14300),
                Map.entry("2024-06-15", 10200),
                Map.entry("2024-06-16", 15100),
                Map.entry("2024-06-17", 12700),
                Map.entry("2024-06-18", 10800),
                Map.entry("2024-06-19", 9700),
                Map.entry("2024-06-20", 16400),
                Map.entry("2024-06-21", 11900),
                Map.entry("2024-06-22", 10600),
                Map.entry("2024-06-23", 15500),
                Map.entry("2024-06-24", 13700),
                Map.entry("2024-06-25", 12100),
                Map.entry("2024-06-26", 11200),
                Map.entry("2024-06-27", 13200),
                Map.entry("2024-06-28", 8600),
                Map.entry("2024-06-29", 16800),
                Map.entry("2024-06-30", 9900)
        );

        /* ----------------------------------------------------------------- */
        /* 1)  Max / Min step counts and their dates                         */
        /* ----------------------------------------------------------------- */
        IntSummaryStatistics stats = stepCounts.values().stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Total steps: " + stats.getMax()+
                "\nAverage steps: " + stats.getAverage()+
                "\nMinimum steps: " + stats.getMin()+
                "\nMaximum steps: " + stats.getMax()+
                "\nCount of days: " + stats.getCount());


        int maxSteps = stats.getMax();
        int minSteps = stats.getMin();

        String maxDates = stepCounts.entrySet().stream()
                .filter(e -> e.getValue() == maxSteps)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));


        String minDates = stepCounts.entrySet().stream()
                .filter(e -> e.getValue() == minSteps)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.printf("Date(s) with highest steps (%d): %s%n",
                maxSteps, maxDates);
        System.out.printf("Date(s) with lowest steps (%d): %s%n",
                minSteps, minDates);


        /* ----------------------------------------------------------------- */
        /* 2)  Total and average for the month                               */
        /* ----------------------------------------------------------------- */
        long   totalSteps = stats.getSum();
        double avgSteps   = stats.getAverage();

        System.out.printf("Total steps: %d%n", totalSteps);
        System.out.printf("Average steps per day: %.2f%n", avgSteps);
        /* ----------------------------------------------------------------- */
        /* 3)  Dates above average                                           */
        /* ----------------------------------------------------------------- */
        String aboveAvg = stepCounts.entrySet().stream()
                .filter(e -> e.getValue() > avgSteps)
                .map(e -> e.getKey() + " (" + e.getValue() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("Dates above average: " + aboveAvg);

    }

}
