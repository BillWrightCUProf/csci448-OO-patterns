package cpluspluscomparison;

public interface Crawls {
    default void move() {
        System.out.println("Crawling");
    }
}
