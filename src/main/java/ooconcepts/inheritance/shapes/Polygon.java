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

    static Polygon newShape(int width, int height, int sides) {
        switch (sides) {
            case 3:
                return new Triangle(width, height);
            case 4:
                return new Rectangle(width, height);
            default:
                throw new IllegalArgumentException("Unsupported number of sides: " + sides);
        }
    }

    abstract int area();

    void printSides() {
        System.out.println("I have " + this.sides + " sides.");
    }
}

