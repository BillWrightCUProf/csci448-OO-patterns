package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testDistanceTo() {
        Location loc1 = new Location(3, 4);
        Location loc2 = new Location(0, 0);
        double expectedDistance = 5.0; // 3-0 and 4-0 forms a right triangle with hypotenuse 5
        assertEquals(expectedDistance, loc1.distanceTo(loc2), 0.001);
    }
}