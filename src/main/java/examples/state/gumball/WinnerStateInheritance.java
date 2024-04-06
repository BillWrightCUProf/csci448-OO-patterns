package examples.state.gumball;

public class WinnerStateInheritance extends SoldState {

    public WinnerStateInheritance(StateGumballMachine gumballMachine) {
        super(gumballMachine);
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");

            // This code is identical to the SoldState class, so we could use the Template pattern to avoid code duplication
//            gumballMachine.releaseBall();
//            if (gumballMachine.getCount() > 0) {
//                gumballMachine.setState(gumballMachine.getNoQuarterState());
//            } else {
//                System.out.println("Oops, out of gumballs!");
//                gumballMachine.setState(gumballMachine.getSoldOutState());
//            }
            super.dispense();
        }
    }
}
