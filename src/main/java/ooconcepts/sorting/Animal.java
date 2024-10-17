package ooconcepts.sorting;

import java.util.List;

public class Animal implements Comparable<Animal> {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }
}
