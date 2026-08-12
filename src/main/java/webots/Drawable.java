package webots;

import java.awt.*;

public interface Drawable {
    Shape toShape();
    void setPosition(Position position);
}
