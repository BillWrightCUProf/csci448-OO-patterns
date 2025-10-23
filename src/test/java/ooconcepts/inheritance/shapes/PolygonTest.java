package ooconcepts.inheritance.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void area() {
        Rectangle rectangle = new Rectangle(10, 20);

        assertTrue(rectangle instanceof Rectangle);
        assertTrue(rectangle instanceof Polygon);

        Triangle triangle = new Triangle(10, 20);
        assertEquals(200, rectangle.area());
        assertEquals(100, triangle.area());
    }

}