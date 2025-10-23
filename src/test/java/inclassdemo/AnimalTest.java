package inclassdemo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testAnimalSorting() {
        List<Animal> animals = new ArrayList<>(Arrays.asList(
                new Hippo("henry", "grass", "rivers"),
                new Ibis("birdy", "fish", "lakes")
        ));

        System.out.println(animals);

        Collections.sort(animals);

        animals.sort(Comparator.comparing(Animal::getName));
        System.out.println(animals);
    }

}