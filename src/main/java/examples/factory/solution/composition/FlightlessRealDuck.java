package examples.factory.solution.composition;


public class FlightlessRealDuck extends Duck {

    public FlightlessRealDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Flightless");
    }

}
