package webots;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Robot implements Drawable {
    Position position;
    int length;

    public Robot(Position position, int length) {
        this.position = position;
        this.length = length;
    }

    public void run() {

    }

    public Shape toShape(Position position) {
        return new Ellipse2D.Double(position.x - length/2.0, position.y - length/2.0, length,  length);
    }

    @Override
    public Shape toShape() {
        return new Ellipse2D.Double(position.x - length/2.0, position.y - length/2.0, length,  length);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
