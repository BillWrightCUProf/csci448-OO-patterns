package webots;

import org.junit.jupiter.api.Test;

class RobotBuilderTest {

    @Test
    void testBuilding() {
        RobotBuilder builder = new RobotBuilder();
        int backWheelDiameterInInches = 2;
        int frontWheelDiameterInInches = 1;

        builder.addWheel(new Wheel(backWheelDiameterInInches), Location.BACK_LEFT);
        builder.addWheel(new Wheel(backWheelDiameterInInches), Location.BACK_RIGHT);
        builder.addMotor(new StepperMotor(), Location.BACK_LEFT);
        builder.addMotor(new StepperMotor(), Location.BACK_RIGHT);
        builder.addWheel(new Wheel(frontWheelDiameterInInches), Location.FRONT_CENTER);

        int orientationInDegrees = 0;
        builder.addSensor(new BumperSensor(orientationInDegrees), Location.FRONT_CENTER);
        builder.addSensor(new BumperSensor(orientationInDegrees), Location.BACK_CENTER);
        builder.addSensor(new UltraSoundSensor(), Location.FRONT_CENTER);

        Robot robot = builder.build();
        robot.run();
    }

    @Test
    void testBuildingFluentInterface() {
        int backWheelDiameterInInches = 2;
        int frontWheelDiameterInInches = 1;
        int orientationInDegrees = 0;

        Robot robot = new RobotBuilderFluent()
                .addWheel(new Wheel(backWheelDiameterInInches), Location.BACK_LEFT)
                .addWheel(new Wheel(backWheelDiameterInInches), Location.BACK_RIGHT)
                .addMotor(new StepperMotor(), Location.BACK_LEFT)
                .addMotor(new StepperMotor(), Location.BACK_RIGHT)
                .addWheel(new Wheel(frontWheelDiameterInInches), Location.FRONT_CENTER)
                .addSensor(new BumperSensor(orientationInDegrees), Location.FRONT_CENTER)
                .addSensor(new BumperSensor(orientationInDegrees), Location.BACK_CENTER)
                .addSensor(new UltraSoundSensor(), Location.FRONT_CENTER)
                .build();

        robot.run();
    }
}