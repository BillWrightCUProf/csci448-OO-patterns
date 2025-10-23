package examples.streams;

import ooconcepts.animals.Hippo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamExamplesTest {

    @Test
    void testCountingViaReducing() {
        List<Hippo> hippos = List.of(
                new Hippo("Hippolyta", "grass", "river"),
                new Hippo("Hercules", "reeds", "lake"),
                new Hippo("Hermione", "water lilies", "pond")
        );

        long count = hippos.stream()
                .map(hippo -> 1L) // Map each hippo to a count of 1
                .reduce(0L, (a, b) -> a + b); // Sum all counts
        assertEquals(3, count, "There should be 3 hippos in the list");

        long countA = hippos.stream()
                .map(hippo -> 1L) // Map each hippo to a count of 1
                .reduce(0L, Long::sum); // Sum all counts
        assertEquals(3, countA, "There should be 3 hippos in the list");

        long count1 = hippos.stream()
                .reduce(0L, (acc, hippo) -> acc + 1, Long::sum);
        assertEquals(3, count1, "There should be 3 hippos in the list");

        long count2 = hippos.stream()
                .count();
        assertEquals(3, count2, "There should be 3 hippos in the list");

    }
}