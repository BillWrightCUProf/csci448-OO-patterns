package webots;

import webots.viewer.WorldWithRobot;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;

public class Obstacle {
    Position position;
    int orientation;
    List<Position> vertices;

    Obstacle(Position position, int orientation, List<Position> vertices) {
        this.position = position;
        this.orientation = orientation;
        assert vertices != null && vertices.size() > 2;
        this.vertices = vertices;
    }

    Shape toShape() {
        Path2D path = new Path2D.Double();
        Position currentPosition = vertices.getFirst().translate(position);
        for (int i = 1; i < vertices.size(); i++) {
            Position nextPosition = vertices.get(i).translate(position);
            path.lineTo(currentPosition.x + nextPosition.x, currentPosition.y + nextPosition.y);
            currentPosition = nextPosition;
        }
        path.closePath();
        return path;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
