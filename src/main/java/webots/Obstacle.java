package webots;

import webots.viewer.WorldWithRobot;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;

public class Obstacle implements Drawable {
    Position position;
    int orientation;
    List<Position> vertices;

    public Obstacle(Position position, int orientation, List<Position> vertices) {
        this.position = position;
        this.orientation = orientation;
        assert vertices != null && vertices.size() > 2;
        this.vertices = vertices;
    }

    public Shape toShape() {
        Path2D path = new Path2D.Double();
        if (vertices.isEmpty()) return path;

        Position first = vertices.getFirst().translate(position);
        path.moveTo(first.x, first.y);
        for (Position next : vertices.subList(1, vertices.size())) {
            Position nextTranslated = next.translate(position);
            path.lineTo(nextTranslated.x, nextTranslated.y);
        }
        path.closePath();
        return path;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean contains(Position position) {
        return toShape().contains(position.x, position.y);
    }
}
