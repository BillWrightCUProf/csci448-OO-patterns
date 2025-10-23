package ooconcepts.equals;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void equalsTest() {
        Room livingRoom = new Room("livingRoom");
        Room bathroom = new Room("bathroom");

        Pet fido = new Pet("fido", livingRoom);
        Pet fluffy = new Pet("fluffy", bathroom);

        assertFalse(Objects.equals(fido.getLocation(), fluffy.getLocation()));
        assertFalse(fido.getLocation() == fluffy.getLocation());

        Pet garfield = new Pet("garfield", livingRoom);
        assertTrue(garfield.getLocation() == garfield.getLocation());
    }

}