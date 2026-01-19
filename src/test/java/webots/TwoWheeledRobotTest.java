package webots;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoWheeledRobotTest {

    private static final int WIDTH = 500;
    private static final int LENGTH = 500;
    private static final int NUMBER_OF_TIME_STEPS = 100;

    @Test
    void twoWheeledRobotTest() {
        World world = new World(WIDTH, LENGTH);
        Position initialPosition = world.getRandomPosition();
        int initialHeadingInDegrees = world.getRandomHeading();

        TwoWheeledRobot robot = new TwoWheeledRobot();
        world.addAgent(robot, initialPosition);
        world.simulate(NUMBER_OF_TIME_STEPS);
    }
}
