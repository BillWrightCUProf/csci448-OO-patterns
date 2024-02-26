package examples.factory.solution.composition;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Mallard");
    }

}
