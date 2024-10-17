package ooconcepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMainTest {

    @Test
    void testDefaultConstructor() {
        SimpleMain simpleMain = new SimpleMain(null);
        assertNotNull(simpleMain);
    }

}