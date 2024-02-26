package examples.factory.solution.composition;

public class DecoyDuck extends Duck {


    public DecoyDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Decoy");
    }

}
