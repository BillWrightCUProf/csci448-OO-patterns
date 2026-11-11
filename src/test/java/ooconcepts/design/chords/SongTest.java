package ooconcepts.design.chords;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void playHappyBirthday() {
        List<INote> notes = List.of(
                Note.C, Note.C, Note.D, Note.C, Note.F, Note.E,
//                Note.C, Note.C, Note.D, Note.C, Note.G, Note.F,
//                Note.C, Note.C, Note.C, Note.A, Note.F, Note.E, Note.D,
                Note.ASharp, Note.ASharp, Note.A, Note.F, Note.G, Note.F
        );
        Song happyBirthday = new Song("Happy Birthday", notes);
        happyBirthday.play();
    }

    @Test
    void playSongWithChords() {
        List<INote> notes = List.of(
                Note.C, Note.E, Note.G,
                Chord.majorTriad(Note.C),
                Note.D, Note.FSharp, Note.A,
                Chord.majorTriad(Note.D)
        );
        Song songWithChords = new Song("Song with Chords", notes);
        songWithChords.play();
    }
}