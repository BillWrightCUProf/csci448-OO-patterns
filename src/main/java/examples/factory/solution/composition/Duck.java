package examples.factory.solution.composition;

public abstract class Duck {
    private static int instanceCount = 0;

    private final String name;
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this("Duck " + instanceCount++, flyBehavior, quackBehavior);
    }

    Duck(String name, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();

    public void performQuack() {
        this.quackBehavior.quack();
    }
    public void performFly() {
        this.flyBehavior.fly();
    }

    public void swim() {
        System.out.println("Swimming");
    }

    @Override
    public String toString() { return name; }
}
