package webots;

import org.junit.jupiter.api.Test;
import webots.observer.Beeper;
import webots.observer.TextMessageReceiver;

class SimpleRobotTest {

    @Test
    void testSimpleRobotGettingStuck() {
        SimpleRobot robot = new SimpleRobot();
        Beeper beeper = new Beeper();
        robot.registerObserver( beeper);
        TextMessageReceiver textMessageReceiver = new TextMessageReceiver(robot);
        robot.registerObserver(textMessageReceiver);
        robot.move();
    }

}