package examples.factory.solution.inheritance;

import java.util.List;

public class DuckMain {

    List<Duck> ducks = List.of(
            new MallardDuck(),
            new RedheadDuck(),
            new FlightlessRealDuck(),
            new RubberDuck(),
            new DecoyDuck()
    );

    public void handleDucks() {
        for (Duck duck : ducks) {
            duck.display();
            duck.swim();
//            duck.fly();
//            duck.quack();
        }
    }

}
