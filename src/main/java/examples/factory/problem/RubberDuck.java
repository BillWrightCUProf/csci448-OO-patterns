package examples.factory.problem;

public class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("Rubber");
    }

    @Override
    public void fly() {
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
