package webots;

import java.util.*;

public class World {
    static final Random random = new Random();
    private final int width;
    private final int height;
    Map<Agent, Position> agents = new HashMap<>();

    public World(int width, int length) {
        this.width = width;
        this.height = length;
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
        agents.put(agent, initialPosition);
    }

    public void simulate(int numberOfTimeSteps) {

    }
}
