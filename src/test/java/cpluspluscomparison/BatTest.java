package cpluspluscomparison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatTest {
    @Test
    void testBat() {
        Bat bat = new Bat("Bruce");
        assertNotNull(bat);
        bat.move();
    }

    @Test
    void testFlyingAndCrawling() {
        Bat bat = new Bat("Bruce");
        assertNotNull(bat);
        bat.move(); // Should print "Bat is flying"

        Flies bat2 = new Bat("Bruce");
        assertNotNull(bat2);
        bat2.move(); // Should print "Bat is flying"

        Crawls bat3 = new Bat("Bruce");
        assertNotNull(bat3);
        bat3.move(); // Should print "Bat is flying"
    }

}