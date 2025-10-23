package examples.factory.solution.composition;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IncorrectDuckFactoryTest {

    IncorrectDuckFactory incorrectDuckFactory = new IncorrectDuckFactory(
            new FlyWithWings(), new Walk(), new CannotFly(), new Quack(), new Squeak(), new Silent());

    @Test
    void testCreatingADuck() {
        Duck duck = incorrectDuckFactory.createMallard();
        for (int i = 0; i< 12; i++) {
            System.out.print(duck + ": ");
            duck.performFly();
        }
    }

    @Test
    void testCreatingDucks() {
        IncorrectDuckFactory incorrectDuckFactory = new IncorrectDuckFactory(
                new FlyWithWings(), new Walk(), new CannotFly(), new Quack(), new Squeak(), new Silent());

        List<Duck> ducks = List.of(incorrectDuckFactory.createMallard(), incorrectDuckFactory.createMallard());
        for (int i = 0; i< 12; i++) {
            for (Duck duck : ducks) {
                System.out.print(duck + ": ");
                duck.performFly();
            }
        }
    }
}