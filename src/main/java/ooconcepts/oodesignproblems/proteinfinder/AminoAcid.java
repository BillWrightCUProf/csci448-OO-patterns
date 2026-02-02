package ooconcepts.oodesignproblems.proteinfinder;

import java.util.HashMap;
import java.util.Map;

public enum AminoAcid {
    Alanine("Ala"), Arginine("Arg"), Asparagine("Asn"), Aspartate("Asp"), Cysteine("Cys"), Glutamine("Gln"),
    Glutamate("Glu"), Glycine("Gly"), Histidine("His"), Isoleucine("Ile"), Leucine("Leu"), Lysine("Lys"),
    Methionine("Met"), Phenylalanine("Phe"), Proline("Pro"), Serine("Ser"), Threonine("Thr"), Tryptophan("Trp"),
    Tyrosine("Tyr"), Valine("Val");

    public static final Map<Codon, AminoAcid> codonToAminoAcidMap = new HashMap<>();

    static {
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Adenine, Base.Adenine}), Lysine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Adenine, Base.Cytosine}), Asparagine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Adenine, Base.Guanine}), Lysine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Adenine, Base.Urasil}), Asparagine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Cytosine, Base.Adenine}), Threonine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Cytosine, Base.Cytosine}), Threonine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Cytosine, Base.Guanine}), Threonine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Cytosine, Base.Urasil}), Threonine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Guanine, Base.Adenine}), Arginine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Guanine, Base.Cytosine}), Serine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Guanine, Base.Guanine}), Arginine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Guanine, Base.Urasil}), Serine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Urasil, Base.Adenine}), Isoleucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Urasil, Base.Cytosine}), Isoleucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Urasil, Base.Guanine}), Methionine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Adenine, Base.Urasil, Base.Urasil}), Isoleucine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Adenine, Base.Adenine}), Glutamine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Adenine, Base.Cytosine}), Histidine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Adenine, Base.Guanine}), Glutamine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Adenine, Base.Urasil}), Histidine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Cytosine, Base.Adenine}), Proline);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Cytosine, Base.Cytosine}), Proline);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Cytosine, Base.Guanine}), Proline);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Cytosine, Base.Urasil}), Proline);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Guanine, Base.Adenine}), Arginine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Guanine, Base.Cytosine}), Arginine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Guanine, Base.Guanine}), Arginine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Guanine, Base.Urasil}), Arginine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Urasil, Base.Adenine}), Leucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Urasil, Base.Cytosine}), Leucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Urasil, Base.Guanine}), Leucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Cytosine, Base.Urasil, Base.Urasil}), Leucine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Adenine, Base.Adenine}), Glutamate);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Adenine, Base.Cytosine}), Aspartate);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Adenine, Base.Guanine}), Glutamate);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Adenine, Base.Urasil}), Aspartate);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Cytosine, Base.Adenine}), Alanine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Cytosine, Base.Cytosine}), Alanine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Cytosine, Base.Guanine}), Alanine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Cytosine, Base.Urasil}), Alanine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Guanine, Base.Adenine}), Glycine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Guanine, Base.Cytosine}), Glycine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Guanine, Base.Guanine}), Glycine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Guanine, Base.Urasil}), Glycine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Urasil, Base.Adenine}), Valine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Urasil, Base.Cytosine}), Valine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Urasil, Base.Guanine}), Valine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Guanine, Base.Urasil, Base.Urasil}), Valine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Adenine}), null);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Cytosine}), Tyrosine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Guanine}), null);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Adenine, Base.Urasil}), Tyrosine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Cytosine, Base.Adenine}), Serine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Cytosine, Base.Cytosine}), Serine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Cytosine, Base.Guanine}), Serine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Cytosine, Base.Urasil}), Serine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Guanine, Base.Adenine}), null);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Guanine, Base.Cytosine}), Cysteine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Guanine, Base.Guanine}), Tryptophan);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Guanine, Base.Urasil}), Cysteine);

        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Urasil, Base.Adenine}), Leucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Urasil, Base.Cytosine}), Phenylalanine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Urasil, Base.Guanine}), Leucine);
        codonToAminoAcidMap.put(new Codon(new Base[]{Base.Urasil, Base.Urasil, Base.Urasil}), Phenylalanine);
    }

    private final String displayName;

    AminoAcid(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static AminoAcid fromCodon(Codon codon) {
        return codonToAminoAcidMap.get(codon);
    }
}
