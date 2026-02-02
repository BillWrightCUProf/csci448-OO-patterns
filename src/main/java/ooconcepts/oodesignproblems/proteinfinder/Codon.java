package ooconcepts.oodesignproblems.proteinfinder;

import java.util.Arrays;
import java.util.List;

public class Codon {
    private static Codon START_CODON = new Codon(new Base[]{Base.Adenine, Base.Urasil, Base.Guanine});
    private static List<Codon> STOP_CODONS = List.of(new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Adenine}),
            new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Guanine}),
            new Codon(new Base[]{Base.Urasil, Base.Guanine, Base.Adenine}));

    private Base[] bases;

    public Codon(Base[] bases) {
        if (bases.length != 3) throw new IllegalArgumentException("Codons must consist of 3 bases");
        this.bases = bases;
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
}
