package examples.factory.solution.composition;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flapping");
    }
}
