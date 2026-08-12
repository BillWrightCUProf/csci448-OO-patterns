package webots;

public class RobotBuilder {
    Agent robot;

    RobotBuilder() {
        robot = new SimpleRobot();
    }

    void addMotor(Motor motor, Location location) {

    }

    public void addWheel(Wheel wheel, Location location) {
    }

    public void addSensor(Sensor bumperSensor, Location location) {
    }

    public Agent build() {
        return robot;
    }
}
