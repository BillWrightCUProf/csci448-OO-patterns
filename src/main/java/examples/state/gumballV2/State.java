package examples.state.gumballV2;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class State {
    static public AtomicInteger constructorCallingCount = new AtomicInteger(0);

    StateGumballMachine gumballMachine;

    public State(StateGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        constructorCallingCount.incrementAndGet();
    }

    public abstract void insertQuarter();
    public abstract void ejectQuarter();
    public abstract void turnCrank();
    public abstract void dispense();
    public abstract void refill();
}
