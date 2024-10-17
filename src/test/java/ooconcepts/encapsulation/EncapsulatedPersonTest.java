package ooconcepts.encapsulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncapsulatedPersonTest {

    @Test
    void testUsage() {
        EncapsulatedPerson joe = new EncapsulatedPerson("Joe");
        EncapsulatedPerson sally = new EncapsulatedPerson("Sally");
        sally.addFriend(joe);
        System.out.println(sally.getName() + " has these friends: ");
        for (EncapsulatedPerson friend : sally.getFriends()) {
            System.out.println(friend);
        }
    }
}