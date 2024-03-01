package ooconcepts.collections;

import ooconcepts.animals.Animal;
import ooconcepts.animals.Hippo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionComparisonTest {

    @Test
    void testCollections() {
        List<Hippo> hippos = new ArrayList<>();
        hippos.add(new Hippo("Harry", "grass", "river"));

        // This is okay, as it creates a new list of animals from the list of hippos
//        List<Animal> animals = new ArrayList<>(hippos);

        // This is not okay, as it tries to assign a list of hippos to a list of animals
//         List<Animal> animals = hippos;
    }

}
