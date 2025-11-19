package webots.viewer;

import org.junit.jupiter.api.Test;
import webots.ObstacleFactory;
import webots.World;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class WorldViewerTest {
    ObstacleFactory obstacleFactory = new ObstacleFactory();

    @Test
    void displayWorld() {
        World world = new World(800, 600);
        world.addObstacle(obstacleFactory.createSquare(100));
        world.addObstacle(obstacleFactory.createPentagon(100));
        world.addObstacle(obstacleFactory.createEquilateralTriangle(100));

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("World Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new WorldViewer(world));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}