package examples.factory.solution.composition;

public class DuckFactory {
    //                new MallardDuck(new FlyWithWings(), new Quack()),
//                new RedheadDuck(new FlyWithWings(), new Quack()),
//                new FlightlessRealDuck(new Walk(), new Quack()),
//                new RubberDuck(new CannotFly(), new Squeak()),
//                new DecoyDuck(new CannotFly(), new Silent())
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
