package ooconcepts.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class EncapsulatedRoom {
    private List<Adventurer> adventurers = new ArrayList<>();

    public EncapsulatedRoom(List<Adventurer> adventurers) {
        for (Adventurer adventurer : adventurers) {
            this.adventurers.add(adventurer);
        }
    }

    public List<Adventurer> getAdventurers() {
        List<Adventurer> copiedList = new ArrayList<>();
        copiedList.addAll(adventurers);
        return copiedList;
    }

    public List<Adventurer> getAdventurers2() {
        return adventurers.stream().toList();
    }

    public int getAdventurerCount() {
        return adventurers.size();
    }
}
