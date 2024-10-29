package examples.strategy;

public class Butterfly implements SwimmingStrategy{
    @Override
    public void swim() {
        System.out.println("Swim with both arms at once");
    }
}
