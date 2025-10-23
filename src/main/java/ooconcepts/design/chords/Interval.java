package ooconcepts.design.chords;

public class Interval {
    String name;
    int distanceInSemitones;

    public Interval(String name, int distanceInSemitones) {
        this.name = name;
        this.distanceInSemitones = distanceInSemitones;
    }

    public static Interval halfStep() { return new Interval("Half Step", 1); };
    public static Interval wholeStep() { return new Interval("Whole Step", 2); };
    public static Interval minorThird() { return new Interval("Minor Third", 3); };
    public static Interval majorThird() { return new Interval("Major Third", 4); };
}
