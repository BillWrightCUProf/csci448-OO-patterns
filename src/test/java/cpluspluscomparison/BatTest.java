package cpluspluscomparison;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BatTest {
    @Test
    void testBat() {
        Bat bat = new Bat("Bruce");
        assertNotNull(bat);
        bat.move();
    }

    @Test
    void testFlyingAndCrawling() {
        Bat bat = new Bat("Bruce");
        bat.move();

        Flies bat2 = new Bat("Bruce");
        bat2.move();

        Crawls bat3 = new Bat("Bruce");
        bat3.move();
    }

    @Test
    void testPolymorphism() {
        Animal bat = new Bat("Vampire");
        Animal mammal = new Mammal("Canine", true);
        Animal animal = new Animal("Insect");

        List<Animal> animals = List.of(bat, mammal, animal);
        for (Animal a : animals) {
            System.out.println(a.getName());
        }
    }

}