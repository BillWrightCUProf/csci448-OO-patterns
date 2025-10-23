package ooconcepts.animals;


public class Canine extends Animal {
    public Canine(String name, String foodType, String location) {
        super(name,foodType, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof!");
    }
}
