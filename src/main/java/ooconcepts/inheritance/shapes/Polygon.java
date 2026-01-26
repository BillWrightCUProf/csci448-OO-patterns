package ooconcepts.inheritance.shapes;

abstract public class Polygon {
    int width;
    int height;
    int sides;

    Polygon() {
    }

    Polygon(int width, int height, int sides) {
        this.width = width;
        this.height = height;
        this.sides = sides;
    }

    abstract int area();

    void printSides() {
        System.out.println("I have " + this.sides + " sides.");
    }
}

