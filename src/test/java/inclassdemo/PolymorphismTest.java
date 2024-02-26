package inclassdemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PolymorphismTest {

    @Test
    void testPolyMorphism() {
        Hippo hippo = new Hippo("hippo", "grass", "river");
        Ibis ibis = new Ibis("ibis", "insects", "back of hippo");

//        List<Animal> animals = List.of(hippo, ibis);
        List<Animal> animals = Arrays.asList(hippo, ibis);
        Collections.sort(animals);
        for (Animal animal : animals) {
            System.out.println(animal);

            animal.eat();
            animal.makeNoise();
            animal.roam();

            animal.doAllThree();
            System.out.println("-------------------");
        }

//        ibis.fly();
        hippo.submerge();

    }

    @Test
    void testMutability() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> immutable = List.copyOf(numbers);
        // Stop in debugger and check the class types of each object
    }

}
