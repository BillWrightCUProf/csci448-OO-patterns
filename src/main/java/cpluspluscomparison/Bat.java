package cpluspluscomparison;

public class Bat extends Mammal implements Flies, Crawls {
    public Bat(String name) {
        super(name, false);
    }

    @Override
    public void move() {
        System.out.println("Bat is flying");
    }
}
