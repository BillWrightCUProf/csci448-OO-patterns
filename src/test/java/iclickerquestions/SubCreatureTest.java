package iclickerquestions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubCreatureTest {

    @Test
    void testSubCreature() {
        SubCreature subCreature1 = new SubCreature("SubCreatureOne", 100.0, 10);
        SubCreature subCreature2 = new SubCreature("SubCreatureTwo", 50.0, 5);
//        assertEquals("SubCreatureOne", subCreature1.getName());
//        assertEquals("SubCreatureTwo", subCreature2.getName());
    }

}