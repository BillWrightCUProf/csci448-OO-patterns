package ooconcepts.polymorphism;

public class PolyRectangle implements Shape {
    int width;
    int length;

    public PolyRectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }
}
