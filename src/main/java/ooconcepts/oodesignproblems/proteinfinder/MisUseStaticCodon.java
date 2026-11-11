package ooconcepts.oodesignproblems.proteinfinder;

import java.util.List;

// For an iClicker question: "What is the problem with this class?" The answer is that it misuses static methods and variables.
public class MisUseStaticCodon {
    // This should be a static variable, but it is not. This causes an infinite loop when the constructor is called.
    //  private MisUseStaticCodon START_CODON = new MisUseStaticCodon(Base.Adenine, Base.Urasil, Base.Guanine);
    private static MisUseStaticCodon START_CODON = new MisUseStaticCodon(Base.Adenine, Base.Urasil, Base.Guanine);

    private final Base[] bases;

    public MisUseStaticCodon getStartCodon() {
        return START_CODON;
    }

    public MisUseStaticCodon(Base base1, Base base2, Base base3) {
        this.bases = new Base[]{base1, base2, base3};
    }
}
