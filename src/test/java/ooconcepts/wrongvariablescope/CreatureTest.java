package ooconcepts.wrongvariablescope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void createCreature() {
        Creature creature = new RadioactiveCreature("Bilbo", 5.0, 3);
        Creature joe = new RadioactiveCreature("joe", 5.0, 3);
        assertEquals("Bilbo", creature.getName());

        System.out.println("# of Creature created" + Creature.numberOfInstancesCreated);
    }
}