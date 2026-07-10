package cpluspluscomparison;

public interface Flies {
    default void move() {
        System.out.println("Flying");
    }
}
