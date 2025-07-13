package final_exam;

import java.util.*;
import java.util.function.BiFunction;

public class _20_WordChampion {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "rhinoceros", "cat", "strawberry", "dog");

        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        Optional<String> longest = words.stream()
                .reduce(mapper::apply);

        longest.ifPresent(word -> System.out.println("Longest word: " + word));

        BiFunction<String, String, String> vowelChampion = (w1, w2) -> {
            int v1 = countVowels(w1);
            int v2 = countVowels(w2);
            if (v1 > v2) return w1;
            if (v2 > v1) return w2;
            // Tie-breaker: pick lexicographically last
            return w1.compareTo(w2) > 0 ? w1 : w2;
        };

        Optional<String> champion = words.stream()
                .reduce(vowelChampion::apply);

        champion.ifPresent(word -> System.out.println("Vowel Champion: " + word));
    }

    static int countVowels(String word) {
        return (int) word.toLowerCase()
                .chars()
                .filter(ch -> "aeiou".indexOf(ch) >= 0)
                .count();
    }
}
