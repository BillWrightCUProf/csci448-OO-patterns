package ooconcepts;

import java.util.List;

public abstract class Animal {
    String name;
    String foodType;
    String location;

    public Animal(String name, String foodType, String location) {
        this.name = name;
        this.foodType = foodType;
        this.location = location;
    }

    public String toString() {
        return getClass().getName() + "[" + String.join(", ", List.of(name, foodType, location)) + "]";
    }

    public void makeNoise() {
        System.out.println("Animal making noise");
    }

    public void eat() {
        System.out.println("Animal eating");
    }

    public void roam() {
        System.out.println("Animal roaming");
    }

    public void doAllThree() {
        eat();
        makeNoise();
        roam();
    }
}
