package ooconcepts.design.chords;

import java.util.List;

public class Chord implements INote {
    String name;
    Scale derivedFromScale;
    List<Note> notes;

    public static Chord majorTriad(Note root) {
        Scale majorScale = Scale.major(root);
        String chordName = root.getName() + "-Major-Triad";
        List<Note> scaleNotes = List.of(
                majorScale.getNote(1),
                majorScale.getNote(3),
                majorScale.getNote(5)
        );
        return new Chord(chordName, majorScale, scaleNotes);
    }

    public Chord(String name, Scale derivedFromScale, List<Note> scaleNotes) {
        this.name = name;
        this.derivedFromScale = derivedFromScale;
        this.notes = scaleNotes;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Chord major7th(Note root) {
        return null;
    }
}
