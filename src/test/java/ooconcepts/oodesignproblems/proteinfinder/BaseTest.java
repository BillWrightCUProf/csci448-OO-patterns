package ooconcepts.oodesignproblems.proteinfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {

    @Test
    void testCodeRepresentation() {
        String representation = Base.Adenine.code();
        assertEquals("A", representation);
    }

}