package webots;

import webots.factory.RobotFactory;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class World implements IObservableWorld {
    static final Random random = new Random();
    public final int width;
    public final int height;
    Map<Agent, Position> agentPositions = new HashMap<>();
    public List<Obstacle> obstacles = new ArrayList<>();

    public World(int width, int length) {
        this.width = width;
        this.height = length;

        agentPositions.put(new TwoWheeledRobot(), getRandomPosition());
        agentPositions.put(new FourWheeledRobot(), getRandomPosition());
        agentPositions.put(new WalkingRobot(), getRandomPosition());
        agentPositions.put(new QuadCopterRobot(), getRandomPosition());
    }

    public World(int width, int length, RobotFactory robotFactory) {
        this.width = width;
        this.height = length;

        agentPositions.put(robotFactory.createTwoWheeledRobot(), getRandomPosition());
        agentPositions.put(robotFactory.createFourWheeledRobot(), getRandomPosition());
        agentPositions.put(robotFactory.createWalkingRobot(), getRandomPosition());
        agentPositions.put(robotFactory.createQuadCopterRobot(), getRandomPosition());
    }

    @Override
    public Dimension getDimensions() {
        return new Dimension(width, height);
    }

    @Override
    public List<Shape> getShapes() {
        return obstacles.stream().map(Obstacle::toShape).toList();
    }

    public Position getRandomPosition() {
        int randomX = random.nextInt(width);
        int randomY = random.nextInt(height);
        return new Position(randomX, randomY);
    }

    public int getRandomHeading() {
        // In degrees
        return random.nextInt(360);
    }

    public void addAgent(Agent agent, Position initialPosition) {
        agentPositions.put(agent, initialPosition);
        agent.setHeading(getRandomHeading());
    }

    public void simulate(int numberOfTimeSteps) {
        for  (int i = 0; i < numberOfTimeSteps; i++) {
            for (Agent agent: agentPositions.keySet()) {
                Vector velocity = agent.getVelocity();
//                Position nextDesiredPosition = agentPositions.get(agent).translate(velocity);
//                if (!agentAgainstObstacle(agent, nextDesiredPosition)) {
//                    agentPositions.put(agent, nextDesiredPosition);
//                    broadcastChange();
//                }
            }
        }
    }

    private void broadcastChange() {
    }

    public boolean agentAgainstObstacle(Agent agent) {
        // --- Collision Detection ---
        Area robotArea = getCurrentAgentArea(agent);
        for (Obstacle obstacle : obstacles) {
            Area obs = new Area(obstacle.toShape());
            Area test = new Area(robotArea);
            test.intersect(obs);
            if (!test.isEmpty()) return true;
        }
        return false;
    }

    private Area getCurrentAgentArea(Agent agent) {
        Position position = agentPositions.get(agent);
        Shape shape = new Ellipse2D.Double(position.x - agent.length/2.0, position.y - agent.length/2.0, agent.length,  agent.length);
        return new Area(shape);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
        obstacle.setPosition(getRandomPosition());
    }
}
