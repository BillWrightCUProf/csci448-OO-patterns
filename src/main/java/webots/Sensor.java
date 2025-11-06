package webots;

public class Sensor extends Device {
    int value = 0;

    public boolean collisionDetected() {
        return value > 0;
    }

    public void hit() {
        value = 10;
    }
}
