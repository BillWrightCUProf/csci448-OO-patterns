package webots.factory;

import webots.Agent;
import webots.TwoWheeledRobot;
import webots.FourWheeledRobot;
import webots.WalkingRobot;
import webots.QuadCopterRobot;

public class RobotFactory {
    public Agent createTwoWheeledRobot() {
        return new TwoWheeledRobot();
    }
    public Agent createFourWheeledRobot() {
        return new FourWheeledRobot();
    }
    public Agent createWalkingRobot() {
        return new WalkingRobot();
    }
    public Agent createQuadCopterRobot() {
        return new QuadCopterRobot();
    }
}
