package examples.strategy;

import org.junit.jupiter.api.Test;

class SwimmerTest {

    @Test
    void testSwimmer() {
        Swimmer swimmer = new Swimmer(Stroke.FREESTYLE);
        swimmer.swim();
    }

}