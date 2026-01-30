package ooconcepts.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class NotEncapsulatedRoom {
    private List<Adventurer> adventurers = new ArrayList<>();

    public NotEncapsulatedRoom(List<Adventurer> adventurers) {
        for (Adventurer adventurer : adventurers) {
            this.adventurers.add(adventurer);
        }
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public int getAdventurerCount() {
        return adventurers.size();
    }
}
