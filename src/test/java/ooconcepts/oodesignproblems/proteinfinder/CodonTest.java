package ooconcepts.oodesignproblems.proteinfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodonTest {

    @Test
    void testStartCodon() {
        Codon codon = new Codon("AUG");
        assertTrue(codon.isStart());
    }

    @Test
    void testStopCodon() {
        Codon codon = new Codon("UAA");
        assertTrue(codon.isStop());
        codon = new Codon("UAG");
        assertTrue(codon.isStop());
        codon = new Codon("UGA");
        assertTrue(codon.isStop());
    }

}