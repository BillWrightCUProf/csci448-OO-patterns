package examples.state;

import org.junit.jupiter.api.Test;

class StateMachineTest {

    @Test
    void testStateMachine() {
        StateMachine stateMachine = new StateMachine();
        stateMachine.run();
    }

    @Test
    void testStateMachineWithHiddenTransition() {
        StateMachine stateMachine = new StateMachine();
        stateMachine.runWithHiddenTransition();
    }

}