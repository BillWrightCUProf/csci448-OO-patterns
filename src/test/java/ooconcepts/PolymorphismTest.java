package ooconcepts;

import ooconcepts.animals.Animal;
import ooconcepts.animals.Hippo;
import ooconcepts.animals.Ibis;


import org.junit.jupiter.api.Test;

import java.util.List;

public class PolymorphismTest {

    @Test
    void testPolyMorphism() {
        Hippo hippo = new Hippo("hippo", "grass", "river");
        Ibis ibis = new Ibis("ibis", "insects", "back of hippo");

        List<Animal> animals = List.of(hippo, ibis);
        for (Animal animal : animals) {
            System.out.println(animal);

            animal.eat();
            animal.makeNoise();
            animal.roam();

            animal.doAllThree();
            System.out.println("-------------------");
        }

        ibis.fly();
        hippo.submerge();

    }
}
