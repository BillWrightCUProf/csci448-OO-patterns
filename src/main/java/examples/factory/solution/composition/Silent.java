package examples.factory.solution.composition;

public class Silent implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I can't make any sounds");
    }
}
