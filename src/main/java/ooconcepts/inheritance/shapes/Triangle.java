package ooconcepts.inheritance.shapes;

public class Triangle extends Polygon {
    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.sides = 3;
    }

    @Override
    int area() {
        return (width * height) / 2;
    }
}
