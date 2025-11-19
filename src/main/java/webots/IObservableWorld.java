package webots;

import java.util.List;
import java.awt.*;

public interface IObservableWorld {
    Dimension getDimensions();
    List<Shape> getShapes();
}
