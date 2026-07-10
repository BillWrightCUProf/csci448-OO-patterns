package cpluspluscomparison;

public class Bat extends Mammal implements Flies, Crawls {
    public Bat(String name) {
        super(name, false);
    }

    @Override
    public void move() {
        Flies.super.move();
        Crawls.super.move();
        System.out.println("Bat is flying or crawling");
    }

    @Override
    public String getName() {
        return "Bat: " + super.getName();
    }
}
