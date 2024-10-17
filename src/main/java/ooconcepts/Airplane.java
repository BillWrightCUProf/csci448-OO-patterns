package ooconcepts;

public class Airplane {
    public static void myStaticMethod() {
        System.out.println("Static method on airplane");
    }

    private int speed;

    public Airplane() {
        this.speed = 0;
    }

    public Airplane(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
