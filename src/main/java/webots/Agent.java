package webots;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Agent {
    int width =20;
    int length = 20;
    Position position;
    private int heading;    // out of 360 degrees

    public abstract Vector getVelocity();

    public Shape getShape(Position position) {
        // Represent robot as a circle
        int radius = width / 2;
        return new Ellipse2D.Double(position.x - radius, position.y - radius, radius * 2, radius * 2);
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void run() {

    }
}
