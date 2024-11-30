package examples.state.gumballV2;

public class StateGumballMachine {
    State currentState;
    int count = 0;

    public StateGumballMachine(int numberGumballs) {
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            currentState = new NoQuarterState(this);
        } else {
            currentState = new SoldOutState(this);
        }
    }

    // Events
    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    public void setSoldOutState() {
        currentState = new SoldOutState(this);
    }

    public void setNoQuarterState() {
        currentState = new NoQuarterState(this);
    }

    public void setHasQuarterState() {
        currentState = new HasQuarterState(this);
    }

    public void setSoldState() {
        currentState = new SoldState(this);
    }

    public void setWinnerState() {
        currentState = new WinnerState(this);
    }

    public boolean notSoldOut() {
        return count > 0;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        currentState.refill();
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + currentState + "\n");
        return result.toString();
    }

}
