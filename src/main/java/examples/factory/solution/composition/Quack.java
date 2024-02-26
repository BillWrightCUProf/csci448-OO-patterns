package examples.factory.solution.composition;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quacking");
    }
}
