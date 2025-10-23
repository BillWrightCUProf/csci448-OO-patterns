package examples.factory.solution.composition;

public class QuackBehaviorFactory {

    public QuackBehavior getQuackBehavior() {
        return new Quack();
    }

    public QuackBehavior getSqueakBehavior() {
        return new Squeak();
    }

    public QuackBehavior getSilentBehavior() {
        return new Silent();
    }
}
