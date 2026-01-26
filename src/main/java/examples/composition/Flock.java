package examples.composition;

import examples.observer.QuackObserver;
import examples.observer.Quackable;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    List<Quackable> quackables = new ArrayList<>();

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        for (Quackable quackable : quackables) {
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void quack() {

    }
}
