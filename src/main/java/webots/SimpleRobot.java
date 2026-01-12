package webots;

import webots.observer.Observable;
import webots.observer.Positionable;
import webots.observer.RobotObserver;

import java.util.ArrayList;
import java.util.List;

public class SimpleRobot implements Positionable, Observable {
    private Position position;
    List<RobotObserver> observers = new ArrayList<>();

    public void move() {
        // some moving code here
        if (isStuck()) {
            notifyObservers();
        }
    }

    private boolean isStuck() {
        return false;
    }

    @Override
    public void registerObserver(RobotObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (RobotObserver observer : observers) {
            observer.imStuck();
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
