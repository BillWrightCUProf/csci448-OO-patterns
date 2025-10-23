package ooconcepts.animals;

import ooconcepts.BedWarmer;
import ooconcepts.HotWaterBottle;
import ooconcepts.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void makeNoise() {
        Canine dog = new Dog();
        assertTrue(dog instanceof Dog);
        assertTrue(dog instanceof Canine);
        assertTrue(dog instanceof Animal);
        assertTrue(dog instanceof Pet);
        assertTrue(dog instanceof BedWarmer);

        Animal animal = new Dog();
        Canine canine = new Dog();

        Animal hippo = new Hippo();
        assertFalse(hippo.isADog());
        assertTrue(animal.isADog());

        HotWaterBottle hotWaterBottle = new HotWaterBottle(120, 100);
        assertTrue(hotWaterBottle instanceof HotWaterBottle);
        assertTrue(hotWaterBottle instanceof BedWarmer);
    }

}