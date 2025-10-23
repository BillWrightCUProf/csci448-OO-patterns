package examples.singleton;

public class EventBusLazyInstantiation {
    private static EventBusLazyInstantiation INSTANCE;
    private EventBusLazyInstantiation() {
    }

    public static EventBusLazyInstantiation getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventBusLazyInstantiation();
        };
        return INSTANCE;
    }

    public void doSomethingUseful() {
        // Do something useful
    }
}
