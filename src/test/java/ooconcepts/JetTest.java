package ooconcepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JetTest {

    @Test
    void testJetCreation() {
        Jet jet = new Jet(1000);
        assertNotNull(jet);
        assertEquals(1000, jet.getSpeed());
    }

    @Test
    void testJetSpeedChange() {
        Jet jet = new Jet(1000);
        jet.setSpeed(2000);
        assertEquals(4000, jet.getSpeed());
    }

    @Test
    void testAcceleration() {
        Jet jet = new Jet(1000);
        jet.accelerate();
        assertEquals(2000, jet.getSpeed());
        jet.accelerate();
        assertEquals(4000, jet.getSpeed());
    }
}