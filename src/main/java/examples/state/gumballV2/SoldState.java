package examples.state.gumballV2;

public class SoldState extends State {

    public SoldState(StateGumballMachine gumballMachine) {
        super(gumballMachine);
    }

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setNoQuarterState();
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setSoldOutState();
        }
    }

    public void refill() { }

    public String toString() {
        return "dispensing a gumball";
    }
}
