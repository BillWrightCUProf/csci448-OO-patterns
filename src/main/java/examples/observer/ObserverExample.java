package examples.observer;

import java.util.Observable;
import java.util.Observer;

// java.util.Observable has been deprecated Since Java 9.0
// Look at java.util.concurrent.Flow for a possible multi-threaded replacement
// TODO: Add this to Observer lecture
public class ObserverExample extends Observable {

    public static void main(String[] args) {
        ObserverExample observerExample = new ObserverExample();
        observerExample.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("ObserverExample update: " + arg);
            }
        });
        observerExample.setChanged();
    }
}
