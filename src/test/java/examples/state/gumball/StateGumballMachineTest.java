package examples.state.gumball;

import examples.state.gumballV2.State;
import org.junit.jupiter.api.Test;

class StateGumballMachineTest {

    @Test
    void testGumBallMachine() {
        System.out.println("***** Testing GumBallMachine that uses switch statements *****");
        GumballMachine gumballMachine = new GumballMachine(2);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.refill(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }

    @Test
    void testStateGumBallMachine() {
        System.out.println("***** Testing GumBallMachine that uses State Pattern *****");
        StateGumballMachine gumballMachine = new StateGumballMachine(3);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.refill(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }

    @Test
    void testOriginalGumballMachine() {
        int numberOfGumballs = 15;
        System.out.println("***** Testing GumBallMachine that uses State Pattern *****");
        StateGumballMachine gumballMachine = new StateGumballMachine(numberOfGumballs);
        System.out.println(gumballMachine);

        while (gumballMachine.notSoldOut()) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
    }

    @Test
    void testNoInitialStateCreationGumballMachine() {
        int numberOfGumballs = 15;
        System.out.println("***** Testing GumBallMachine that uses State Pattern *****");
        examples.state.gumballV2.StateGumballMachine gumballMachine = new examples.state.gumballV2.StateGumballMachine(numberOfGumballs);
        System.out.println(gumballMachine);

        while (gumballMachine.notSoldOut()) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }

        System.out.println("Called the State constructor method: " + State.constructorCallingCount + " times");
    }
}