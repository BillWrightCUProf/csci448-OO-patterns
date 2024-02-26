package examples.factory.solution.inheritance;


public class RubberDuck extends QuackingDuck {

    @Override
    public void display() {
        System.out.println("Rubber");
    }


    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
