package examples.factory.solution.composition;

public class Walk implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm walking, since I can't fly");
    }
}
