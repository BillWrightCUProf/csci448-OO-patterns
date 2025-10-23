package examples.factory.solution.composition;

public class DuckFactoryWithFlyFactor extends DuckFactory {
    private FlyBehaviorFactory flyBehaviorFactory;
    private QuackBehaviorFactory quackBehaviorFactory;

    public DuckFactoryWithFlyFactor() {
        flyBehaviorFactory = new FlyBehaviorFactory();
        quackBehaviorFactory = new QuackBehaviorFactory();
    }
    public DuckFactoryWithFlyFactor(FlyBehaviorFactory flyBehaviorFactory, QuackBehaviorFactory soundBehaviorFactory) {
        this.flyBehaviorFactory = flyBehaviorFactory;
        this.quackBehaviorFactory = soundBehaviorFactory;
    }

    public Duck createMallard() {
        return new MallardDuck(flyBehaviorFactory.createFlyWithWingsBehavior(), quackBehaviorFactory.getQuackBehavior());
    }

    public Duck createRedhead() {
        return new RedheadDuck(flyBehaviorFactory.createFlyWithWingsBehavior(), quackBehaviorFactory.getQuackBehavior());
    }

    public Duck createFlightless() {
        return new FlightlessRealDuck(flyBehaviorFactory.createWalkBehavior(), quackBehaviorFactory.getQuackBehavior());
    }

    public Duck createRubber() {
        return new RubberDuck(flyBehaviorFactory.createNoFlyBehavior(), quackBehaviorFactory.getSqueakBehavior());
    }

    public Duck createDecoy() {
        return new DecoyDuck(flyBehaviorFactory.createNoFlyBehavior(), quackBehaviorFactory.getSilentBehavior());
    }
}
