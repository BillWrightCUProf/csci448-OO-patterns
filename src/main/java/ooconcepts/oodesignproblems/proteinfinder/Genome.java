package ooconcepts.oodesignproblems.proteinfinder;

import java.util.ArrayList;
import java.util.List;

public class Genome {
    List<Base> bases;

    public Genome(String sequence) {
        bases = sequence.chars()
                .mapToObj(c -> Base.fromInitial((char) c))
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

    public boolean hasStartCodon() {
        for (int i = 0; i < bases.size() - 2; i++) {
            Codon possibleCodon = new Codon(new Base[]{
                    bases.get(i), bases.get(i + 1), bases.get(i + 2)});
            if (possibleCodon.isStart()) return true;
        }
        return false;
    }

    public boolean hasStopCodon() {
        for (int i = 0; i < bases.size() - 2; i++) {
            Codon possibleCodon = new Codon(new Base[]{
                    bases.get(i), bases.get(i + 1), bases.get(i + 2)});
            if (possibleCodon.isStop()) return true;
        }
        return false;
    }

    public List<Protein> getAllProteins() {
        int startPosition = 0;
        List<Protein> proteins = new java.util.ArrayList<>();
        while (startPosition < bases.size()) {
            startPosition = findStartCodonStartingFrom(startPosition);
            if (startPosition == -1) {
                return proteins;
            }
            int stopPosition = findStopCodonStartingFrom(startPosition + 3);    // skipping start codon
            if (stopPosition == -1) {
                return proteins;
            }
            proteins.add(createProtein(startPosition, stopPosition));
            startPosition = stopPosition + 3;
        }
        return proteins;
    }

    private Protein createProtein(int startPosition, int stopPosition) {
        List<AminoAcid> aminoAcids = new ArrayList<>();
        for (int i = startPosition; i < stopPosition; i += 3) {
            Codon codon = new Codon(new Base[]{bases.get(i), bases.get(i + 1), bases.get(i + 2)});
            aminoAcids.add(AminoAcid.fromCodon(codon));
        }
        return new Protein(aminoAcids);
    }

    private int findStopCodonStartingFrom(int startPosition) {
        for (int i = startPosition + 3; i < bases.size() - 2; i++) {
            Codon possibleCodon = new Codon(new Base[]{
                    bases.get(i), bases.get(i + 1), bases.get(i + 2)});
            if (possibleCodon.isStop()) {
                return i;
            }
        }
        return -1;
    }

    private int findStartCodonStartingFrom(int startPosition) {
        for (int i = startPosition; i < bases.size() - 2; i++) {
            Codon possibleCodon = new Codon(new Base[]{
                    bases.get(i), bases.get(i + 1), bases.get(i + 2)});
            if (possibleCodon.isStart()) {
                return i;
            }
        }
        return -1;
    }
}

