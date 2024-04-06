package misc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.*;

public class JavaFeaturesTests {

    @Test
    void testDateFormat() {
        var startDateTime = OffsetDateTime.parse("2013-10-20T19:20:30+01:00");
        System.out.println(startDateTime);
    }

    @Test
    void unScramble() {
        String scrambled = "buffalo";
        Map<Character, Integer> letterCounts = generateLetterCounts(scrambled.toUpperCase());

        try {
            List<String> possibleWords = Files.lines(Path.of("/Users/billwright/Downloads/dictionary.txt"))
                    .filter(word -> generateLetterCounts(word).equals(letterCounts))
                    .toList();
            System.out.println(possibleWords);
        } catch (IOException ex) {
            // do nothing
        }
    }

    @Test
    void listFileContents() {
        try {
            Files.lines(Path.of("/Users/billwright/Downloads/tiny.txt"))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            // do nothing
        }
    }


    private Map<Character, Integer> generateLetterCounts(String scrambled) {
        Map<Character, Integer> counts = new HashMap<>();
        for (Character character : scrambled.toCharArray()) {
            Integer currentCount = counts.getOrDefault(character, 0);
            counts.put(character, ++currentCount);
        }
        return counts;
    }

//    private Boolean countsMatch(Map<Character, Integer>)

    List<String> allOrders(Set<Character> input) {
        if (input.isEmpty()) {
            return List.of("");
        }
        List<String> permutations = new ArrayList<>();
        // split string into strings of one-character length
        for (Character start : input) {
            Set<Character> rest = new HashSet<>(input);
            rest.remove(start);
            for (String end : allOrders(rest)) {
                permutations.add(start + end);
            }
        }
        return permutations;
    }
}
