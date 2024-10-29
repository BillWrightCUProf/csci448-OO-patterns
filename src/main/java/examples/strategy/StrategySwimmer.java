package examples.strategy;

public class StrategySwimmer {
    SwimmingStrategy swimmingStrategy;

    StrategySwimmer(SwimmingStrategy swimmingStrategy) {
        this.swimmingStrategy = swimmingStrategy;
    }

    public void swim() {
        this.swimmingStrategy.swim();
    }
}
