package ooconcepts.oodesignproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void testWorldCreationAndCound() {
        for (int i=0; i<10; i++) {
            World world = new World(i*2,i*2+i);
            System.out.println(world);
        }
        System.out.println(World.getCreatedWorlds());
        assertEquals(10, World.getCreatedWorlds().size());
    }

}