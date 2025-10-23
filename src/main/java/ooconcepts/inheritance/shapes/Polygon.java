package ooconcepts.inheritance.shapes;

abstract public class Polygon {
    public static int DEFAULT_HEIGHT = 10;
    int width;
    int height;
    int sides;

    abstract int area();

    void printSides() {
        System.out.println("I have " + this.sides + " sides.");
    }

    static void printDefaultHeight() {
        System.out.println("My default height is " + DEFAULT_HEIGHT);
    }
}

