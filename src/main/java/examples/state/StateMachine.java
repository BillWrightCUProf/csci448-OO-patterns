package examples.state;

import java.util.List;

public class StateMachine {
    static List<String> events = List.of("continue", "stop");
    private int index = 0;
    private State state;

    public StateMachine() {
        this.state = State.STATE1;
    }

    public void run() {
        while (true) {
            // look for event
            String event = getNextEvent();
            switch (state) {
                // one case for each unique state
                case STATE1:
                    System.out.println("Handling event in state 1");
                    // if event valid for this state
                    // handle event, prepare for new state, set new state
                    // should consider error cases
                    state = State.STATE2;
                    break;
                case STATE2:
                    System.out.println("Handling event in state 2");
                    state = State.STATE3;
                    break;
                case STATE3:
                    System.out.println("Handling event in state 3");
                    return; // end of state machine
                default: // unhandled state
                    // handle error
                    System.out.println("Error: unhandled state");
            }
        }
    }

    void runWithHiddenTransition() {
        while (true) {
            String event = getNextEvent();
            switch (state) {
                // one case for each unique state
                case STATE1:
                    System.out.println("Handling event in state 1");
                    // if event valid for this state
                    // handle event, prepare for new state, set new state
                    // should consider error cases
                    nextState(event);
                    break;
                case STATE2:
                    System.out.println("Handling event in state 2");
                    nextState(event);
                    break;
                case STATE3:
                    System.out.println("Handling event in state 3");
                    return; // end of state machine
                default: // unhandled state
                    // handle error
                    System.out.println("Error: unhandled state");
            }
        }
    }

    void nextState(String event) {
        // look for event
        switch (state) {
            // one case for each unique state
            case STATE1:
                System.out.println("Transitioning from state 1 to state 2");
                state = State.STATE2;
                break;
            case STATE2:
                if (event.equals("continue")) {
                    System.out.println("Transitioning from state 2 to state 1");
                    state = State.STATE1;
                } else {
                    System.out.println("Transitioning from state 2 to state 3");
                    state = State.STATE3;
                }
                break;
            case STATE3:
                System.out.println("Handling event in state 3");
                break;
            default: // unhandled state
                // handle error
                System.out.println("Error: unhandled state");
        }
    }

    private String getNextEvent() {
        return events.get(index++ % events.size());
    }
}
