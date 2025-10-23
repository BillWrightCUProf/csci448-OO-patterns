package ooconcepts.animals;

import ooconcepts.BedWarmer;
import ooconcepts.Pet;

public class Dog extends Canine implements Pet, BedWarmer {
    public Dog() {
        super("Dog", "meat", "home");
    }

    public Dog(String name) {
        super(name, "meat", "home");
    }

    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }

    @Override
    public boolean inside() {
        return true;
    }

    @Override
    public int temperatureInCelsius() {
        return 39;
    }

    @Override
    public int capacityInMinutes() {
        return 500; // all night long
    }

    @Override
    boolean isADog() {
        return true;
    }
}
