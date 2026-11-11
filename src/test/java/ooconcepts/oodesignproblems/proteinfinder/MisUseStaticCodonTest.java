package ooconcepts.oodesignproblems.proteinfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// This causes an infinite loop when the constructor is called
class MisUseStaticCodonTest {

    @Test
    void testMisUseStaticCodon() {
        MisUseStaticCodon codon1 = new MisUseStaticCodon(Base.Urasil, Base.Adenine, Base.Adenine);
        System.out.println(codon1.getStartCodon());
    }

}