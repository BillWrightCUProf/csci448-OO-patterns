package ooconcepts.design.chords;

public enum Note implements INote {
    A(0, "A"),
    ASharp(1, "A#"),
    B(2, "B"),
    C(3, "C"),
    CSharp(4, "C#"),
    D(5, "D"),
    DSharp(6, "D#"),
    E(7, "E"),
    F(8, "F"),
    FSharp(9, "F#"),
    G(10, "G"),
    GSharp(11, "G#");

    private final int semitoneValue;
    private final String name;

    Note(int semitoneValue, String name) {
        this.semitoneValue = semitoneValue;
        this.name = name;
    }

    public int getSemitoneValue() {
        return semitoneValue;
    }

    public Note getNextNote(Interval interval) {
        int nextSemitoneValue = (this.semitoneValue + interval.getSemitoneCount()) % 12;
        return Note.values()[nextSemitoneValue];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
