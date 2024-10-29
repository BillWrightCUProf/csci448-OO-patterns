package examples.strategy;

import org.junit.jupiter.api.Test;
import java.util.List;


class StrategySwimmerTest {

    @Test
    void testSwim() {
        StrategySwimmer freestyleSwimmer = new StrategySwimmer(new Freestyle());
        StrategySwimmer butterflySwimmer = new StrategySwimmer(new Butterfly());
        List<StrategySwimmer> swimmers = List.of(freestyleSwimmer, butterflySwimmer);

        for (StrategySwimmer swimmer : swimmers) {
            swimmer.swim();
        }
    }

}