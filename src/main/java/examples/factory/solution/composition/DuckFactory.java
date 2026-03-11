package examples.factory.solution.composition;

public class DuckFactory {
    enum DuckType {
        MALLARD, REDHEAD, FLIGHTLESS, RUBBER, DECOY
    }

    public Duck create(DuckType type) {
        return switch (type) {
            case MALLARD -> createMallard();
            case REDHEAD -> createRedhead();
            case FLIGHTLESS -> createFlightless();
            case RUBBER -> createRubber();
            case DECOY -> createDecoy();
        };
    }

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

    public Duck createRandomDuck() {
        return switch ((int) (Math.random() * 5)) {
            case 1 -> createRedhead();
            case 2 -> createFlightless();
            case 3 -> createRubber();
            case 4 -> createDecoy();
            default -> createMallard();
        };
    }

    public Duck create(String string) {
        return switch (string) {
            case "redhead" -> createRedhead();
            case "flightless" -> createFlightless();
            case "rubber" -> createRubber();
            case "decoy" -> createDecoy();
            default -> createMallard();
        };
    }
}

