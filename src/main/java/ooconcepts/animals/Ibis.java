package ooconcepts.animals;

public class Ibis extends Animal {

    String featherColor = "white";

    public Ibis() {
        super("Ibis", "insects", "swamp");
    }

    public Ibis(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    public void makeNoise() {
        System.out.println("Tweet");
    }

    public void fly() {
        System.out.println("I'm flapping my " + featherColor + " feathers!");
    }
}
