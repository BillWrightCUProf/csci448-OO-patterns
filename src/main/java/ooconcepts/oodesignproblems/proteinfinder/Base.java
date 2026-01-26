package ooconcepts.oodesignproblems.proteinfinder;

public enum Base {
    Adenine, Cytosine, Guanine, Thymine, Urasil;

    static Base fromDNAChar(char c) {
        return switch (c) {
            case 'A' -> Base.Adenine;
            case 'C' -> Base.Cytosine;
            case 'G' -> Base.Guanine;
            case 'T' -> Base.Thymine;
            case 'U' -> Base.Urasil;
            default -> throw new IllegalArgumentException("Invalid base for DNA: " + c);
        };
    }

    public String code() {
        return name().charAt(0) + "";
    }

}
