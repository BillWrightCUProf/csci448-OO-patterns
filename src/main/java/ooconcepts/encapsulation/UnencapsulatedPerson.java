package ooconcepts.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class UnencapsulatedPerson {
    public String name;
    public List<UnencapsulatedPerson> friends = new ArrayList<>();

    public UnencapsulatedPerson() {
    }

    public void addFriend(UnencapsulatedPerson aFriend) {
        this.friends.add(aFriend);
    }
}
