package examples.strategy;

import org.junit.jupiter.api.Test;

import static examples.strategy.Swimmer.Stroke.FREESTYLE;

class SwimmerTest {

    @Test
    void testSwimmer() {
        Swimmer swimmer = new Swimmer(FREESTYLE);
        swimmer.swim();
    }

}