package ooconcepts.design.chords;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChordTest {

    @Test
    void recognizeCMajorChord() {
        List<Note> unknownChordNotes = List.of(
                Note.C,
                Note.E,
                Note.G
        );

        ChordIdentifier identifier = new ChordIdentifier();
        Chord identifiedChord = identifier.identify(unknownChordNotes);

        assertEquals(identifiedChord, Chord.majorTriad(Note.C), "The identified chord should be C Major");
    }

    @Test
    void recognizeDMajor7Chord() {
        List<Note> unknownChordNotes = List.of(
                Note.D,
                Note.A,
                Note.CSharp,
                Note.FSharp
        );

        ChordIdentifier identifier = new ChordIdentifier();
        Chord identifiedChord = identifier.identify(unknownChordNotes);

        assertEquals(identifiedChord, Chord.major7th(Note.D), "The identified chord should be D Major 7");
    }

}