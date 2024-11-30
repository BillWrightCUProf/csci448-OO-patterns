package examples.state.gumballV2;

public class WinnerState extends SoldState {

    public WinnerState(StateGumballMachine gumballMachine) {
        super(gumballMachine);
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setSoldOutState();
        } else {
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
            super.dispense();
        }
    }
}
