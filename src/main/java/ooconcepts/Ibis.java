package ooconcepts;

public class Ibis extends Animal {

    String featherColor = "white";

    public Ibis(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    public void makeNoise() {
        System.out.println("Tweet");
    }

    public void fly() {
        System.out.println("I'm flying!");
    }
}
