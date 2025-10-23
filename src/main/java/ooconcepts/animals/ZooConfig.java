package ooconcepts.animals;

import java.util.List;

public class ZooConfig {

    public Zoo zoo() {
        return new Zoo(
                List.of(
                        new Hippo("Fatty", "Grass", "River"),
                        new Ibis(),
                        new Wolf()
                )
        );
    }
}
