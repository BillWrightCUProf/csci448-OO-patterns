package ooconcepts.inheritance.shapes;

public class Rectangle extends Polygon {
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.sides = 4;
    }

    @Override
    int area() {
        return width * height;
    }
}
