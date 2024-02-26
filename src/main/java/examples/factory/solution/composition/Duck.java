package examples.factory.solution.composition;

public abstract class Duck {
    private final FlyBehavior flyBehavior;
    private final QuackBehavior quackBehavior;
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    public abstract void display();

    public void swim() {
        System.out.println("Swimming");
    }
    public void performQuack() {
        this.quackBehavior.quack();
    }

    public void performFly() {
        this.flyBehavior.fly();
    }
}
