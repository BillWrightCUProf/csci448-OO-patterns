package examples.state;

import java.util.HashMap;
import java.util.Map;

public class TableDrivenStateMachine {

    Map<TrafficSignalState, Map<Event, Action>> stateMachine = new HashMap<>();

//    TableDrivenStateMachine() {
//        Map<Event, Action> greenLightActions = new HashMap<>();
//        greenLightActions.put(Event.GREEN_LIGHT_TIMEOUT, new WalkButtonPushedAction());
//        greenLightActions.put(Event.GREEN_LIGHT_TIMEOUT, new GreenLightTimeoutAction());
//        stateMachine.put(State.GREEN_LIGHT, greenLightActions);
//
//        Map<Event, Action> redLightActions = new HashMap<>();
//        redLightActions.put(Event.RED_LIGHT_TIMEOUT, new RedLightTimeoutAction());
//        stateMachine.put(State.RED_LIGHT, redLightActions);
//    }
}
