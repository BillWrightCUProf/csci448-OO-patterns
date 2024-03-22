package ooconcepts.animals;

import java.util.List;

public class Zoo {

    List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void makeAllNoises() {
        for (Animal animal : animals) {
            animal.makeNoise();
        }
    }
}
