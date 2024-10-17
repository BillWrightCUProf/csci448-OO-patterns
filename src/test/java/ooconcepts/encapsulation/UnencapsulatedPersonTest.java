package ooconcepts.encapsulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnencapsulatedPersonTest {

    @Test
    void testUsage() {
        UnencapsulatedPerson joe = new UnencapsulatedPerson();
        joe.name = "Joe";
        UnencapsulatedPerson sally = new UnencapsulatedPerson();
        sally.name = "Sally";
        sally.addFriend(joe);
        System.out.println(sally.name + " has these friends: ");
        for (UnencapsulatedPerson friend : sally.friends) {
            System.out.println(friend.name);
        }
    }
}