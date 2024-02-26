package examples.factory.solution.inheritance;

public abstract class FlyingDuck extends Duck {
    public void fly() {
        System.out.println("I'm flying!");
    }
    public void quack() {
        System.out.println("Quack, Quack");
    }
}
