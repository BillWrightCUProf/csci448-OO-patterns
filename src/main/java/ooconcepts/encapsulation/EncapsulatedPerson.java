package ooconcepts.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class EncapsulatedPerson {
    private final String name;
    private List<EncapsulatedPerson> friends = new ArrayList<>();

    public EncapsulatedPerson(String name) {
        this.name = name;
    }

    public void addFriend(EncapsulatedPerson aFriend) {
        this.friends.add(aFriend);
    }

    public List<EncapsulatedPerson> getFriends() {
        return new ArrayList<>(friends);
    }

    public String getName() {
        return this.name;
    }
}
