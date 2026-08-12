package webots;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstacleTest {

    @Test
    public void testContainsSquare() {
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle square = factory.createSquare(100);
        
        // Default position is (0,0)
        assertTrue(square.contains(new Position(50, 50)), "Point (50, 50) should be inside 100x100 square at (0,0)");
        assertFalse(square.contains(new Position(150, 50)), "Point (150, 50) should be outside 100x100 square at (0,0)");
        assertFalse(square.contains(new Position(-10, 50)), "Point (-10, 50) should be outside 100x100 square at (0,0)");
    }

    @Test
    public void testContainsWithOffset() {
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle square = factory.createSquare(100);
        square.setPosition(new Position(100, 100));
        
        // Square is now from (100,100) to (200,200)
        assertTrue(square.contains(new Position(150, 150)), "Point (150, 150) should be inside 100x100 square at (100,100)");
        assertFalse(square.contains(new Position(50, 50)), "Point (50, 50) should be outside 100x100 square at (100,100)");
    }

    @Test
    public void testContainsEquilateralTriangle() {
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle triangle = factory.createEquilateralTriangle(100);
        
        // A point near the center of a triangle with vertices (0,0), (100,0), (50, ~86)
        assertTrue(triangle.contains(new Position(50, 40)), "Point (50, 40) should be inside 100-side equilateral triangle");
        
        // A point that should be outside
        assertFalse(triangle.contains(new Position(50, 100)), "Point (50, 100) should be outside 100-side equilateral triangle (height is ~86)");
    }
}
