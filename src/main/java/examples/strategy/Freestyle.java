package examples.strategy;

public class Freestyle implements SwimmingStrategy {
    @Override
    public void swim() {
        System.out.println("Swim by alternating arms");
    }
}
