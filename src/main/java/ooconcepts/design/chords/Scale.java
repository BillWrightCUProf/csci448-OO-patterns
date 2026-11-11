package ooconcepts.design.chords;

import java.util.Iterator;
import java.util.List;

public class Scale implements Iterable<Note> {
    String name;
    Note tonic;
    List<Interval> intervals;

    @Override
    public Iterator<Note> iterator() {
        return new NoteIterator();
    }

    public Note getNote(int scaleDegree) {
        Note noteToReturn = tonic;
        for (int i = 0; i < scaleDegree - 1; i++) {
            Interval interval = intervals.get(i);
            noteToReturn = noteToReturn.getNextNote(interval);
        }
        return noteToReturn;
    }

    private class NoteIterator implements java.util.Iterator<Note> {
        private int currentIndex = 1;

        @Override
        public boolean hasNext() {
            return currentIndex <= intervals.size();
        }

        @Override
        public Note next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Note noteToReturn = getNote(currentIndex);
            currentIndex++;
            return noteToReturn;
        }
    }

    // OR using another ivar:
//     private class NoteIterator implements java.util.Iterator<Note> {
//        private int currentIndex = 0;
//        private Note currentNote = tonic;
//
//        @Override
//        public boolean hasNext() {
//            return currentIndex < intervals.size();
//        }
//
//        @Override
//        public Note next() {
//            if (!hasNext()) {
//                throw new java.util.NoSuchElementException();
//            }
//            Note noteToReturn = currentNote;
//            currentNote = currentNote.getNextNote(intervals.get(currentIndex));
//            currentIndex++;
//            return noteToReturn;
//        }
//    }

    public static Scale major(Note tonic) {
        String name = tonic.getName() + " Major";
        List<Interval> intervals = List.of(
                Interval.wholeStep(),
                Interval.wholeStep(),
                Interval.halfStep(),
                Interval.wholeStep(),
                Interval.wholeStep(),
                Interval.wholeStep(),
                Interval.halfStep()
        );
        return new Scale(name, tonic, intervals);
    }

    public Scale(String name, Note tonic, List<Interval> intervals) {
        this.name = name;
        this.tonic = tonic;
        this.intervals = intervals;
    }
}
