package ooconcepts.design.chords;

import java.util.List;

public class Scale {
    String name;
    Note tonic;
    List<Interval> intervals;

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
