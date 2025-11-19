package webots;

import java.util.List;

public class ObstacleFactory {

    private Obstacle createNew(List<Position> vertices) {
        return new Obstacle(new Position(0, 0), 0, vertices);
    }

    public Obstacle createEquilateralTriangle(int sideLength) {
        List<Position> vertices = List.of(
                new Position(0, 0),
                new Position(sideLength, 0),
                new Position(sideLength / 2, (int) (sideLength * Math.cos(60)))
        );
        return createNew(vertices);
    }

    public Obstacle createPentagon(int sideLength) {
        List<Position> vertices = List.of(
                new Position(30, 0), new Position(80, 30), new Position(65, 80),
                new Position(-5, 80), new Position(-20, 30)
        );
        return createNew(vertices);
    }

    // Example obstacles

    public Obstacle createSquare(int length) {
        return createRectangle(length, length);
    }

    public Obstacle createRectangle(int width, int height) {
        List<Position> vertices = List.of(
                new Position(0, 0),
                new Position(width, 0),
                new Position(width, height),
                new Position(0, height)
        );
        return createNew(vertices);
    }
}
