package ooconcepts.equals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House {
    List<Pet> pets;

    public House(List<Pet> pets) {
        this.pets = pets;
    }

    public void play() {
        if (petsInSameRoom()) {
            System.out.println("The pets are playing together");
        }
    }

    private boolean petsInSameRoom() {
        return pets.getFirst().getLocation().equals(pets.getLast().getLocation());
    }
}
