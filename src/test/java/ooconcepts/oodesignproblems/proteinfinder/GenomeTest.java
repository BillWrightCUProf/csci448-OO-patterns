package ooconcepts.oodesignproblems.proteinfinder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class GenomeTest {

    static RandomGenerator random = RandomGenerator.getDefault();
    static String START_CODON = "ATG";
    static List<String> STOP_CODONS   = List.of("TAA", "TAG",  "TGA");
    static List<String> POSSIBLE_TRIPLETS;
    static {
        POSSIBLE_TRIPLETS =AminoAcid.codonToAminoAcidMap.keySet().stream().map(codon -> codon.toString()).toList();
        POSSIBLE_TRIPLETS = new ArrayList<>(POSSIBLE_TRIPLETS);
        POSSIBLE_TRIPLETS.remove(START_CODON);
        POSSIBLE_TRIPLETS.removeAll(STOP_CODONS);
    }
    static int PROTEIN_MIN_LENGTH = 5;
    static int PROTEIN_MAX_LENGTH = 20;
    static int EXTRON_MIN_LENGTH = 5;
    static int EXTRON_MAX_LENGTH = 30;

    private static String generateRandomDNASequence(int minLength, int numOfGenes) {
        StringBuilder sb = new StringBuilder();
        int insertedGenes = 0;
        while (sb.length() < minLength && insertedGenes < numOfGenes) {
            sb.append(generateRandomJunkSequence());
            sb.append(generateRandomProteinSequence());
            insertedGenes++;
        }

        return sb.toString();
    }

    private static String getRandomTriplet() {
        return POSSIBLE_TRIPLETS.get(random.nextInt(POSSIBLE_TRIPLETS.size()));
    }

    private static String generateRandomJunkSequence() {
        StringBuilder sb = new StringBuilder();
        int extronBaseCount = random.nextInt(EXTRON_MAX_LENGTH - EXTRON_MIN_LENGTH + 1) + EXTRON_MIN_LENGTH;
        for (int i = 0; i < extronBaseCount; i++) {
            sb.append(getRandomTriplet());
        }
        return sb.toString();
    }

    private static String generateRandomProteinSequence() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_CODON);
        int introCodonCount = random.nextInt(PROTEIN_MAX_LENGTH - PROTEIN_MIN_LENGTH + 1) + PROTEIN_MIN_LENGTH;
        for (int i = 0; i < introCodonCount; i++) {
                sb.append(getRandomTriplet());
        }
        sb.append(STOP_CODONS.get(random.nextInt(STOP_CODONS.size())));
        return sb.toString();
    }

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

    @Test
    void testRandomSequenceConstruction() {
        String dnaString = generateRandomDNASequence(100, 10);
        Genome dnaSequence = new Genome(dnaString);
        System.out.println(dnaSequence);
    }

    @Test
    void testRNAConstructionFromRandomDNA() {
        int numOfGenes = 5;
        Genome dnaSequence = new Genome(generateRandomDNASequence(400, numOfGenes));
        System.out.println("Test sequence is " + dnaSequence.toString().length() + " bases long");
        System.out.println(dnaSequence);
        Genome rnaSequence = dnaSequence.convertToRNA();
        System.out.println(rnaSequence);
       assertTrue(rnaSequence.hasStartCodon());
       assertTrue(rnaSequence.hasStopCodon());
       List<Protein> proteins = rnaSequence.getAllProteins();
       System.out.println("Found " + proteins.size() + " proteins");
       System.out.println(proteins);
       assertEquals(numOfGenes, proteins.size());
    }


}
