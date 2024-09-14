package ooconcepts.polymorphism;

public class PolyCircle implements Shape {

    int radius;

    public PolyCircle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
