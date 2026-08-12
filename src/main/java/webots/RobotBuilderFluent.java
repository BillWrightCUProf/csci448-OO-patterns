package webots;

public class RobotBuilderFluent {
    Agent robot;

    RobotBuilderFluent() {
        robot = new SimpleRobot();
    }

    RobotBuilderFluent addMotor(Motor motor, Location location) {
        return this;
    }

    RobotBuilderFluent addWheel(Wheel wheel, Location location) {
        return this;
    }

    RobotBuilderFluent addSensor(Sensor bumperSensor, Location location) {
        return this;
    }

    Agent build() {
        return robot;
    }
}
