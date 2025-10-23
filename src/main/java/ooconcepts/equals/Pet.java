package ooconcepts.equals;

public class Pet {
    private String name;
    private Room location;

    public Pet(String name, Room location) {
        this.name = name;
        this.location = location;
    }

    public Room getLocation() {
        return location;
    }
}
