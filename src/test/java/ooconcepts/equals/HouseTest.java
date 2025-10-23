package ooconcepts.equals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void equalsTest() {
        Room livingRoom = new Room("livingRoom");
        Room bathroom = new Room("bathroom");

        Pet fido = new Pet("fido", livingRoom);
        Pet fluffy = new Pet("fluffy", bathroom);

        House house = new House(List.of(fido, fluffy));

        house.play();
    }
}