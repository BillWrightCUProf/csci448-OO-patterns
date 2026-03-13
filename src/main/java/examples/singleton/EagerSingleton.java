package examples.singleton;

import java.util.ArrayList;
import java.util.List;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private final List<String> observers = new ArrayList<>();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public void addObserver(String observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (String observer : observers) {
            System.out.println(observer + ", something just happened: " + message);
        }
    }

    public void postMessage(String message) {
        notifyObservers(message);
    }
}
