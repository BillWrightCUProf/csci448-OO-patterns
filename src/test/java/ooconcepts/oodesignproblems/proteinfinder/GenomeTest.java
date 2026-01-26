package ooconcepts.oodesignproblems.proteinfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenomeTest {

    @Test
    void testGenomeConstruction() {
        Genome genome = new Genome("ATGCGA");
        System.out.println(genome);
    }

    @Test
    void testInValidBaseSequence() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Genome("AUGCBG")
        );
        assertTrue(ex.getMessage().contains("Invalid"));
        assertTrue(ex.getMessage().contains("DNA"));
    }

    @Test
    void testRNAConstructionFromDNA() {
        String dnaString = "ATGCGA";
        Genome dnaSequence = new Genome(dnaString);
        Genome rnaSequence = dnaSequence.convertToRNA();

        String expectedRNAString = dnaString.replace("T", "U");
        assertEquals(expectedRNAString, rnaSequence.toString());

        System.out.println(dnaSequence);
        System.out.println(rnaSequence);
    }
}
