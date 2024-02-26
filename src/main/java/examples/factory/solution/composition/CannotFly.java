package examples.factory.solution.composition;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't move. I only float");
    }
}
