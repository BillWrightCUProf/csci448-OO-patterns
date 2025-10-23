package ooconcepts.trucks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyotaTest {

    @Test
    void testInstanceVariableOverriding() {
        Truck toyota = new Toyota();
        System.out.println(toyota);
        assertNotNull(toyota.getEngine());
    }
}