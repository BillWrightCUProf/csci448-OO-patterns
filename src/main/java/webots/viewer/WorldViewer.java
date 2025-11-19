package webots.viewer;

import webots.IObservableWorld;

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
}