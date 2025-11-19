package webots.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

public class WorldWithRobot extends JPanel implements KeyListener {

    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    static class Obstacle {
        double x, y;
        List<Point> vertices;

        Obstacle(double x, double y, List<Point> vertices) {
            this.x = x;
            this.y = y;
            this.vertices = vertices;
        }

        Shape toShape() {
            Path2D path = new Path2D.Double();
            if (!vertices.isEmpty()) {
                Point first = vertices.get(0);
                path.moveTo(x + first.x, y + first.y);
                for (int i = 1; i < vertices.size(); i++) {
                    Point p = vertices.get(i);
                    path.lineTo(x + p.x, y + p.y);
                }
                path.closePath();
            }
            return path;
        }
    }

    static class World {
        int width, height;
        List<Obstacle> obstacles = new ArrayList<>();

        World(int width, int height) {
            this.width = width;
            this.height = height;
        }

        void addObstacle(Obstacle o) { obstacles.add(o); }
    }

    static class Robot {
        double x, y, angle;
        double radius = 20;

        Shape toShape() {
            // Represent robot as a circle
            return new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
        }
    }

    private final World world;
    private final Robot robot;

    public WorldWithRobot(World world, Robot robot) {
        this.world = world;
        this.robot = robot;
        setPreferredSize(new Dimension(world.width, world.height));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw world boundary
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawRect(0, 0, world.width - 1, world.height - 1);

        // Draw obstacles
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(80, 100, 200, 180));
        for (Obstacle o : world.obstacles) {
            Shape s = o.toShape();
            g2.fill(s);
            g2.setColor(Color.BLACK);
            g2.draw(s);
            g2.setColor(new Color(80, 100, 200, 180));
        }

        // Draw robot
        g2.setColor(Color.RED);
        g2.fill(robot.toShape());
        g2.setColor(Color.BLACK);
        g2.draw(robot.toShape());
    }

    // --- Collision Detection ---
    private boolean collides(Shape robotShape) {
        Area robotArea = new Area(robotShape);
        for (Obstacle o : world.obstacles) {
            Area obs = new Area(o.toShape());
            Area test = new Area(robotArea);
            test.intersect(obs);
            if (!test.isEmpty()) return true;
        }
        return false;
    }

    // --- Movement logic ---
    private void tryMove(double dx, double dy) {
        double newX = robot.x + dx;
        double newY = robot.y + dy;

        Shape newShape = new Ellipse2D.Double(newX - robot.radius, newY - robot.radius,
                robot.radius * 2, robot.radius * 2);
        if (!collides(newShape)
                && newX - robot.radius > 0
                && newY - robot.radius > 0
                && newX + robot.radius < world.width
                && newY + robot.radius < world.height) {
            robot.x = newX;
            robot.y = newY;
        }
        repaint();
    }

    // --- Key controls ---
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> tryMove(0, -5);
            case KeyEvent.VK_DOWN -> tryMove(0, 5);
            case KeyEvent.VK_LEFT -> tryMove(-5, 0);
            case KeyEvent.VK_RIGHT -> tryMove(5, 0);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    // --- Entry point ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            World world = new World(800, 600);

            List<Point> tri = List.of(new Point(0, 0), new Point(100, 0), new Point(50, 80));
            List<Point> square = List.of(new Point(0, 0), new Point(80, 0), new Point(80, 80), new Point(0, 80));
            List<Point> pent = List.of(new Point(30, 0), new Point(80, 30), new Point(65, 80), new Point(-5, 80), new Point(-20, 30));

            world.addObstacle(new Obstacle(150, 150, tri));
            world.addObstacle(new Obstacle(400, 250, square));
            world.addObstacle(new Obstacle(600, 400, pent));

            Robot robot = new Robot();
            robot.x = 100;
            robot.y = 100;

            JFrame frame = new JFrame("World with Robot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new WorldWithRobot(world, robot));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}