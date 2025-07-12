package final_exam;

import java.util.Map;

/**
 * You are given the following map of breakfast foods and their calorie counts:
 *         Map<String, Integer> calorieMap = Map.of(
 *                 "Grits", 150,
 *                 "Pancakes", 350,
 *                 "Burrito", 400,
 *                 "Bacon & Eggs", 300,
 *                 "Greek Salad", 200,
 *                 "Caesar Salad", 250,
 *                 "Sandwich", 330
 *         );
 *
 * Write a Java Stream expression to print the names and calorie counts of all foods that contain the word
 * "Salad" in their name and have more than 200 calories. The output should be in the format:
 *
 * Caesar Salad: 250
 */
public class _2_Exercise {
    public static void main(String[] args) {
        Map<String, Integer> calorieMap = Map.of(
                "Grits", 150,
                "Pancakes", 350,
                "Burrito", 400,
                "Bacon & Eggs", 300,
                "Greek Salad", 200,
                "Caesar Salad", 250,
                "Sandwich", 330
        );


        calorieMap.entrySet().stream()
                .filter( x-> x.getKey().contains("Salad") && x.getValue() > 200)
                .forEach( x-> System.out.println(x.getKey() + ": " + x.getValue()));

//                .stream()
//                .filter(x->x.contains("Salad"))
//                .
//                .forEach(System.out::println);

    }
}
