package webots;

public class TwoWheeledRobot extends Agent {
    static final int SPEED = 4;
    static final int TIME_STEP = 64;

    RobotMotor leftWheelMotor;
    RobotMotor rightWheelMotor;
    Sensor bumperSensor;

    public TwoWheeledRobot() {
        leftWheelMotor = new RobotMotor();
        rightWheelMotor = new RobotMotor();
        int orientationInDegrees = 0;   // pointing straight ahead
        bumperSensor = new BumperSensor(orientationInDegrees);
    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    public void move(int numberOfTimeIntervals) {
        while (numberOfTimeIntervals > 0) {
            if (bumperSensor.collisionDetected()) {
                backUp(7);
                turnLeft(6);
            }
            goForward();
            numberOfTimeIntervals--;
        }
    }

    private void goForward() {
    }

    private void backUp(int timeSlices) {
    }

    private void turnLeft(int timeSlices) {
    }

    public static void functionalDecompositionMain(String[] args) {
//        int main() {
//            WbDeviceTag bumper;
//            WbDeviceTag left_motor, right_motor;
//            int movement_counter = 0;
//            int left_speed, right_speed;
//
//            wb_robot_init();
//
//            /* get a handle to the bumper and activate it. */
//            bumper = wb_robot_get_device("bumper");
//            wb_touch_sensor_enable(bumper, TIME_STEP);
//
//            /* get a handler to the motors and set target position to infinity (speed control) */
//            left_motor = wb_robot_get_device("left wheel motor");
//            right_motor = wb_robot_get_device("right wheel motor");
//            wb_motor_set_position(left_motor, INFINITY);
//            wb_motor_set_position(right_motor, INFINITY);
//            wb_motor_set_velocity(left_motor, 0.0);
//            wb_motor_set_velocity(right_motor, 0.0);
//
//            /* control loop */
//            while (wb_robot_step(TIME_STEP) != -1) {
//                /*
//                 * When the touch sensor has detected something we begin the avoidance
//                 * movement.
//                 */
//                if (wb_touch_sensor_get_value(bumper) > 0)
//                    movement_counter = NUMBER_OF_TIME_SLICES_NEEDED_TO_BACKUP_AND_TURN;
//
//                /*
//                 * We use the movement_counter to manage the movements of the robot. When the value
//                 * is 0 we move straight, then when there is another value this means that
//                 * we are avoiding an obstacle. For avoiding we first move backward for
//                 * some cycles and then we turn on ourself.
//                 */
//                if (movement_counter == 0) {
//                    left_speed = SPEED;
//                    right_speed = SPEED;
//
//                } else if (movement_counter >= NUMBER_OF_TIME_SLICES_NEEDED_TO_BACKUP_AND_TURN - NUMBER_OF_TIME_SLICES_NEEDED_TO_BACKUP) {
//                    left_speed = -SPEED;
//                    right_speed = -SPEED;
//                    movement_counter--;
//                } else {
//                    left_speed = -SPEED / 2;
//                    right_speed = SPEED;
//                    movement_counter--;
//                }
//
//                /* Set the motor speeds. */
//                wb_motor_set_velocity(left_motor, left_speed);
//                wb_motor_set_velocity(right_motor, right_speed);
//            }
//
//            wb_robot_cleanup();
//
//            return 0;
//        }
    }

    /*
     * Description:  An example of use of a bumper touch sensor device.
     */

//        #include <webots/motor.h>
//        #include <webots/robot.h>
//        #include <webots/touch_sensor.h>
//
//        #define SPEED 4
//        #define TIME_STEP 64
//
//        int main() {
//            WbDeviceTag bumper;
//            WbDeviceTag left_motor, right_motor;
//            int movement_counter = 0;
//            int left_speed, right_speed;
//
//            wb_robot_init();
//
//            /* get a handle to the bumper and activate it. */
//            bumper = wb_robot_get_device("bumper");
//            wb_touch_sensor_enable(bumper, TIME_STEP);
//
//            /* get a handler to the motors and set target position to infinity (speed control) */
//            left_motor = wb_robot_get_device("left wheel motor");
//            right_motor = wb_robot_get_device("right wheel motor");
//            wb_motor_set_position(left_motor, INFINITY);
//            wb_motor_set_position(right_motor, INFINITY);
//            wb_motor_set_velocity(left_motor, 0.0);
//            wb_motor_set_velocity(right_motor, 0.0);
//
//            /* control loop */
//            while (wb_robot_step(TIME_STEP) != -1) {
//                /*
//                 * When the touch sensor has detected something we begin the avoidance
//                 * movement.
//                 */
//                if (wb_touch_sensor_get_value(bumper) > 0)
//                    movement_counter = 15;
//
//                /*
//                 * We use the movement_counter to manage the movements of the robot. When the value
//                 * is 0 we move straight, then when there is another value this means that
//                 * we are avoiding an obstacle. For avoiding we first move backward for
//                 * some cycles and then we turn on ourself.
//                 */
//                if (movement_counter == 0) {
//                    left_speed = SPEED;
//                    right_speed = SPEED;
//
//                } else if (movement_counter >= 7) {
//                    left_speed = -SPEED;
//                    right_speed = -SPEED;
//                    movement_counter--;
//                } else {
//                    left_speed = -SPEED / 2;
//                    right_speed = SPEED;
//                    movement_counter--;
//                }
//
//                /* Set the motor speeds. */
//                wb_motor_set_velocity(left_motor, left_speed);
//                wb_motor_set_velocity(right_motor, right_speed);
//            }
//
//            wb_robot_cleanup();
//
//            return 0;
//        }
}
