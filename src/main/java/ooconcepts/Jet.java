package ooconcepts;

public class Jet extends Airplane {
    private static final int MULTIPLIER = 2;

    //@Override
    public static void myStaticMethod() {
        System.out.println("Static method on jet");
    }

    public Jet() {
        super();
    }

    public Jet(int speed) {
        super(speed);
    }

    public void setSpeed(int speed) {
        super.setSpeed(speed * MULTIPLIER);
    }

    public void accelerate() {
        super.setSpeed(getSpeed() * MULTIPLIER);
    }
}
