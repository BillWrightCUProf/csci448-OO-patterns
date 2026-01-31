package webots;

public class RobotBuilder {
    Robot robot;

    RobotBuilder() {
        robot = new Robot();
    }

    void addMotor(Motor motor, Location location) {

    }

    public void addWheel(Wheel wheel, Location location) {
    }

    public void addSensor(Sensor bumperSensor, Location location) {
    }

    public Robot build() {
        return robot;
    }
}
