package ooconcepts.oodesignproblems.proteinfinder;

public enum Base {
    Adenine("A"), Cytosine("C"), Guanine("G"), Thymine("T"), Urasil("U");

    private final String displayName;

    Base(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Base fromInitial(String initial) {
        for (Base s : values()) {
            if (s.displayName.equalsIgnoreCase(initial)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown base: " + initial);    }

    public static Base fromInitial(char name) {
        for (Base s : values()) {
            if (s.displayName.equalsIgnoreCase(name + "")) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown base: " + name);
    }

    public String code() {
        return name().charAt(0) + "";
    }

}
