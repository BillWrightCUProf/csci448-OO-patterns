package webots;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Agent {
    int width = 5;
    int length = 5;
    Position position;
    private int heading;    // out of 360 degrees

    public abstract Vector getVelocity();

    public Shape getShape() {
        // Represent robot as a circle
        int radius = width / 2;
        return new Ellipse2D.Double(position.x - radius, position.y - radius, radius * 2, radius * 2);
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

}
