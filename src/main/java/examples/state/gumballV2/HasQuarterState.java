package examples.state.gumballV2;

import java.util.Random;

public class HasQuarterState extends State {
    Random randomWinner = new Random(System.currentTimeMillis());


    public HasQuarterState(StateGumballMachine gumballMachine) {
        super(gumballMachine);
    }

    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setNoQuarterState();
    }

    public void turnCrank() {
        System.out.println("You turned...");
        if ((randomWinner.nextInt(10) == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setWinnerState();
        } else {
            gumballMachine.setSoldState();
        }
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public void refill() { }

    public String toString() {
        return "waiting for turn of crank";
    }
}
