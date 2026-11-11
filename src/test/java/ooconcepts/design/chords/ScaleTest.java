package ooconcepts.design.chords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaleTest {

    @Test
    void iterateThroughScale() {
        Scale cMajorScale = Scale.major(Note.C);
        System.out.print("C Major Scale: ");
        for (Note note : cMajorScale) {
            System.out.print(note + " ");
        }
        System.out.println();

        Scale gMajorScale = Scale.major(Note.G);
        System.out.print("G Major Scale: ");
        for (Note note : gMajorScale) {
            System.out.print(note + " ");
        }
        System.out.println();

        Scale eMajorScale = Scale.major(Note.E);
        System.out.print("E Major Scale: ");
        for (Note note : eMajorScale) {
            System.out.print(note + " ");
        }
        System.out.println();
    }
}