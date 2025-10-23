package examples.factory.solution.composition;

public class IncorrectDuckFactory {
    private final FlyBehavior flyWithWings;
    private final FlyBehavior walk;
    private final FlyBehavior cannotFly;
    private final QuackBehavior quack;
    private final QuackBehavior squeak;
    private final QuackBehavior silent;

    public IncorrectDuckFactory(FlyWithWings flyWithWings, Walk walk, CannotFly cannotFly, Quack quack, Squeak squeak, Silent silent) {
        this.flyWithWings = flyWithWings;
        this.walk = walk;
        this.cannotFly = cannotFly;
        this.quack = quack;
        this.squeak = squeak;
        this.silent = silent;
    }

    public Duck createMallard() {
        return new MallardDuck(flyWithWings, quack);
    }

    public Duck createRedhead() {
        return new RedheadDuck(flyWithWings, quack);
    }

    public Duck createFlightless() {
        return new FlightlessRealDuck(walk, quack);
    }

    public Duck createRubber() {
        return new RubberDuck(cannotFly, squeak);
    }

    public Duck createDecoy() {
        return new DecoyDuck(cannotFly, silent);
    }
}