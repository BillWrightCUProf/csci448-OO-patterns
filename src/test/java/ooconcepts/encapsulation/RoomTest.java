package ooconcepts.encapsulation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testNotEncapsulated() {
        NotEncapsulatedRoom room = new NotEncapsulatedRoom(List.of(new Adventurer(), new Adventurer()));
        assertEquals(2, room.getAdventurerCount());

        room.getAdventurers().add(new Adventurer()); // Directly modifying the list
        assertEquals(3, room.getAdventurerCount()); // Count should remain unchanged

        room.getAdventurers().clear(); // Clearing the list
        assertEquals(0, room.getAdventurerCount()); // Count should still remain unchanged
    }

    @Test
    void testEncapsulated() {
        EncapsulatedRoom room = new EncapsulatedRoom(List.of(new Adventurer(), new Adventurer()));
        assertEquals(2, room.getAdventurerCount());

        room.getAdventurers().add(new Adventurer()); // Directly modifying the list
        assertEquals(2, room.getAdventurerCount()); // Count should remain unchanged

        room.getAdventurers().clear(); // Clearing the list
        assertEquals(2, room.getAdventurerCount()); // Count should still remain unchanged
    }

    @Test
    void testEncapsulated2() {
        EncapsulatedRoom room = new EncapsulatedRoom(List.of(new Adventurer(), new Adventurer()));
        assertEquals(2, room.getAdventurerCount());

//        room.getAdventurers2().add(new Adventurer()); // Directly modifying the list
//        assertEquals(2, room.getAdventurerCount()); // Count should remain unchanged
//
//        room.getAdventurers2().clear(); // Clearing the list
//        assertEquals(2, room.getAdventurerCount()); // Count should still remain unchanged
    }
}