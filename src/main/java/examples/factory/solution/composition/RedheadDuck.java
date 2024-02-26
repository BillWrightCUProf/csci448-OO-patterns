package examples.factory.solution.composition;


public class RedheadDuck extends Duck {

    public RedheadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Redhead");
    }
}
