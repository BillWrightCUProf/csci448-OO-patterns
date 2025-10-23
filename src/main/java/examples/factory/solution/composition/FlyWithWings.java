package examples.factory.solution.composition;

public class FlyWithWings implements FlyBehavior {
    static int NUM_OF_FLAPS_BETWEEN_GLIDES = 5;
    private int flapCount = 0;

    @Override
    public void fly() {
        flapCount = (flapCount + 1) % NUM_OF_FLAPS_BETWEEN_GLIDES;
        if (flapCount == 0) {
            System.out.println("I'm GLIDING!");
        } else {
            System.out.println("I'm flapping");
        }
    }
}
