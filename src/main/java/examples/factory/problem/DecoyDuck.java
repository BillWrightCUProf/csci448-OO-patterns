package examples.factory.problem;

public class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("Decoy");
    }

    @Override
    public void fly() {
    }

    @Override
    public void quack() {
    }
}
