package webots;

public class RobotBuilderFluent {
    Robot robot;

    RobotBuilderFluent() {
        robot = new Robot();
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

    Robot build() {
        return robot;
    }
}
