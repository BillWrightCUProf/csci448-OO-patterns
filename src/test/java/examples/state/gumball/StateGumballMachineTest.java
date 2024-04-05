package examples.state.gumball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}