package ooconcepts.oodesignproblems.proteinfinder;

import java.util.HashMap;
import java.util.List;

public class Protein {

    private List<AminoAcid> aminoAcids;

    public Protein(List<AminoAcid> aminoAcids) {
        this.aminoAcids = aminoAcids;
    }

    @Override
    public String toString() {
        return aminoAcids.toString();
    }
}
