package ooconcepts.oodesignproblems.proteinfinder;

public class Codon {
    private Base[] bases;

    public Codon(Base[] bases) {
        if (bases.length != 3) throw new IllegalArgumentException("Codons must consist of 3 bases");
        this.bases = bases;
    }

    // isStart()
    // isStop()
    // getAminoAcid() -- big switch statement?
}
