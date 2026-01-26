package ooconcepts.oodesignproblems.proteinfinder;

import java.util.Arrays;
import java.util.List;

public class Genome {
    List<Base> bases;

    public Genome(String sequence) {
        bases = sequence.chars()
                .mapToObj(c -> Base.fromDNAChar((char) c))
                .toList();
    }

    @Override
    public String toString() {
        return bases.stream()
                .map(Base::code)
                .reduce("", (a, b) -> a + b);
    }

    public Genome convertToRNA() {
        return new Genome(this.toString().replace("T", "U"));
    }

//    public List<Protein> getAllProteins() {
//
//    }

    // Possibly handy methods
    // createCodonAtPosition(int position)
    // findStartingCodon
    // convertToCodonsFromPosition(int position)
}
