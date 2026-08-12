package webots.viewer;

import webots.Agent;
import webots.IObservableWorld;
import webots.SimpleRobot;

import javax.swing.*;
import java.awt.*;

public class WorldViewer extends JPanel {
    private IObservableWorld world;

    public WorldViewer(IObservableWorld world) {
        this.world = world;
        setPreferredSize(world.getDimensions());
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw boundary
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawRect(0, 0, world.getDimensions().width - 1, world.getDimensions().height - 1);

        // Draw obstacles
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(80, 100, 200, 180));
        for (Shape shape : world.getShapes()) {
            g2.fill(shape);
            g2.setColor(Color.BLACK);
            g2.draw(shape);
            g2.setColor(new Color(80, 100, 200, 180));
        }

        // Draw agents
        g2.setColor(Color.RED);
        for (Shape agentShape : world.getAgents()) {
            g2.fill(agentShape);
            g2.setColor(Color.BLACK);
            g2.draw(agentShape);
            g2.setColor(Color.RED);
        }
    }

    public static void display(IObservableWorld world) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("World Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new WorldViewer(world));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        webots.World world = new webots.World(800, 600);
        webots.ObstacleFactory factory = new webots.ObstacleFactory();
        world.addObstacle(factory.createSquare(100));
        world.addObstacle(factory.createPentagon(100));
        world.addObstacle(factory.createEquilateralTriangle(100));

        Agent robot = new SimpleRobot();
        world.addAgent(robot);

        display(world);
    }
}