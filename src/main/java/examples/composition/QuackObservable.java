package examples.composition;

public interface QuackObservable {
    void registerObserver(QuackObserver observer);
    void notifyObservers();
}
