package ooconcepts.design.chords;

import java.util.List;

public class Chord {
    String name;
    Scale derivedFromScale;
    List<Integer> notes;

    public static Chord majorTriad(Note root) {
        Scale majorScale = Scale.major(root);
        String chordName = root.getName() + " Major Triad";
        List<Integer> scaleNotes = List.of(1, 3, 5);
        return new Chord(chordName, majorScale, scaleNotes);
    }

    public Chord(String name, Scale derivedFromScale, List<Integer> scaleNotes) {
        this.name = name;
        this.derivedFromScale = derivedFromScale;
        this.notes = scaleNotes;
    }

    public static Chord major7th(Note root) {
        return null;
    }
}
