package examples.singleton;

import org.junit.jupiter.api.Test;

class EagerSingletonTest {

    @Test
    void eagerSingletonTest() {
        EagerSingleton singleton = EagerSingleton.getInstance();
        singleton.addObserver("Alice");
        singleton.addObserver("Bob");

        singleton.postMessage("the party is starting!");
    }

}