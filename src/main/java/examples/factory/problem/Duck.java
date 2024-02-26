package examples.factory.problem;

public abstract class Duck {

    public abstract void display();
    public void swim() {
        System.out.println("Swimming");
    }
    public void quack() {
        System.out.println("Quack, Quack");
    }
    public void fly() {
        System.out.println("I'm flying!");
    }

}
