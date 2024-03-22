package ooconcepts.animals;

public class Wolf extends Animal {

    public Wolf() {
        super("Wolf", "meat", "forest");
    }

    public Wolf(String name) {
        super(name, "meat", "forest");
    }

    @Override
    public void makeNoise() {
        System.out.println("Howl");
    }
}
