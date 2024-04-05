package examples.state;

public interface Action {
    State execute(State currentState, Event event);
}
