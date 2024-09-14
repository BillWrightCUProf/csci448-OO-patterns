package ooconcepts.polymorphism;

import org.junit.jupiter.api.Test;

import java.util.List;

class CircleTest {

    @Test
    void testNoPolymorphism() {
        Rectangle rectangle = new Rectangle(3, 4);
        Circle circle = new Circle(5);
        System.out.println("The rectangle has an area of " + rectangle.width * rectangle.length);
        System.out.println("The circle has an area of " + Math.PI * circle.radius * circle.radius);
    }

    @Test
    void testPolymorphism() {
        List<Shape> shapes = List.of(new PolyRectangle(3, 4), new PolyCircle(5));
        for (Shape shape : shapes) {
            System.out.println("Shape " + shape + " has an area of " + shape.getArea());
        }
    }

}