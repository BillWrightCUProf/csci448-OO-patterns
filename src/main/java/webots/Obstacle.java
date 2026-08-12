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
        if (vertices.isEmpty()) return path;

        Position first = vertices.getFirst().translate(position);
        path.moveTo(first.x, first.y);
        for (int i = 1; i < vertices.size(); i++) {
            Position next = vertices.get(i).translate(position);
            path.lineTo(next.x, next.y);
        }
        path.closePath();
        return path;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
