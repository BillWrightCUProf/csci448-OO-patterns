package examples.state.gumballV2;

public class SoldOutState extends State {

    public SoldOutState(StateGumballMachine gumballMachine) {
        super(gumballMachine);
    }

    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public void refill() { gumballMachine.setNoQuarterState(); }

    public String toString() {
        return "sold out";
    }
}
