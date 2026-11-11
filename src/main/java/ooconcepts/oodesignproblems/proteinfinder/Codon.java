package ooconcepts.oodesignproblems.proteinfinder;

import java.util.Arrays;
import java.util.List;

public class Codon {
    private final static Codon START_CODON = new Codon(Base.Adenine, Base.Urasil, Base.Guanine);
    private final static List<Codon> STOP_CODONS = List.of(new Codon(Base.Urasil, Base.Adenine, Base.Adenine),
            new Codon(Base.Urasil, Base.Adenine, Base.Guanine),
            new Codon(Base.Urasil, Base.Guanine, Base.Adenine));

    private Base[] bases;

    public Codon(Base[] bases) {
        if (bases.length != 3) throw new IllegalArgumentException("Codons must consist of 3 bases");
        this.bases = bases;
    }

    public Codon(Base base1, Base base2, Base base3) {
        this.bases = new Base[]{base1, base2, base3};
    }

    public Codon(String baseInitials) {
        if (baseInitials.length() != 3) throw new IllegalArgumentException("Codons must consist of 3 bases");
        bases = new Base[]{Base.fromInitial(baseInitials.substring(0, 1)), Base.fromInitial(baseInitials.substring(1, 2)), Base.fromInitial(baseInitials.substring(2))};
    }

    public boolean isStart() {
        return this.equals(START_CODON);
    }

    public boolean isStop() {
        return STOP_CODONS.contains(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Codon && Arrays.equals(bases, ((Codon) obj).bases);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bases);
    }

    @Override
    public String toString() {
        return Arrays.stream(bases).map(Base::code).reduce("", (a, b) -> a + b);
    }
}
