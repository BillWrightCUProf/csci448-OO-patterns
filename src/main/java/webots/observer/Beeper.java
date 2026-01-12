package webots.observer;

public class Beeper implements RobotObserver {

    @Override
    public void imStuck() {
        System.out.println("Beep, beep, beep!");
    }
}
