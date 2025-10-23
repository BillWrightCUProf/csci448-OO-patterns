package ooconcepts.sorting;

import org.junit.jupiter.api.Test;

import java.util.*;


class AnimalTest {

    @Test
    void testAnimalSorting() {
        List<Animal> animals = new ArrayList<>(Arrays.asList(
                new Animal("Lion"),
                new Animal("Elephant"),
                new Animal("Penguin")
        ));

        System.out.println(animals);

        Collections.sort(animals);

        animals.sort(Comparator.comparing(Animal::getName));
        System.out.println(animals);
    }

}