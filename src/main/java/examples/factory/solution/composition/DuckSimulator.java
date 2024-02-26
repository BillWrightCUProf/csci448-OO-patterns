package examples.factory.solution.composition;

import java.util.List;

public class DuckSimulator {


    public static void handleDucks(List<Duck> ducks) {
        for (Duck duck : ducks) {
            duck.display();
            duck.swim();
            duck.performFly();
            duck.performQuack();
            System.out.println("--------------------");
        }
    }

    public static void simulate() {
        DuckFactory duckFactory = new DuckFactory();

        List<Duck> ducks = List.of(
                duckFactory.createMallard(),
                duckFactory.createRedhead(),
                duckFactory.createFlightless(),
                duckFactory.createRubber(),
                duckFactory.createDecoy()
        );

//        List<Duck> ducks = List.of(
//                new MallardDuck(new FlyWithWings(), new Quack()),
//                new RedheadDuck(new FlyWithWings(), new Quack()),
//                new FlightlessRealDuck(new Walk(), new Quack()),
//                new RubberDuck(new CannotFly(), new Squeak()),
//                new DecoyDuck(new CannotFly(), new Silent())
//        );

        handleDucks(ducks);
    }

}
