package examples.factory.solution.composition;

public class DuckFactory {
    public Duck createMallard() {
        return new MallardDuck(new FlyWithWings(), new Quack());
    }

    public Duck createRedhead() {
        return new RedheadDuck(new FlyWithWings(), new Quack());
    }

    public Duck createFlightless() {
        return new FlightlessRealDuck(new Walk(), new Quack());
    }

    public Duck createRubber() {
        return new RubberDuck(new CannotFly(), new Squeak());
    }

    public Duck createDecoy() {
        return new DecoyDuck(new CannotFly(), new Silent());
    }
}
