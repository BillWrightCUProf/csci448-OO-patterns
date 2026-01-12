package webots.observer;

import webots.Position;

public class TextMessageReceiver implements RobotObserver {
    Positionable subject;

    public TextMessageReceiver(Positionable subject) {
        this.subject = subject;
    }

    @Override
    public void imStuck() {
        Position getPosition = subject.getPosition();
        System.out.println("I'm stuck at " + getPosition);
    }
}
