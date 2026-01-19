package webots;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    ObstacleFactory obstacleFactory = new ObstacleFactory();

    @Test
    void createSimpleWorldWithNoObstacles() {
        World world = new World(800, 800);
        Agent robot = new TwoWheeledRobot();
        world.addAgent(robot, world.getRandomPosition());

        int numberOfTimeTicks = 100;
        world.simulate(numberOfTimeTicks);

        assertTrue(world.agentAgainstObstacle(robot));
    }

    @Test
    void createSimpleWorldWithObstacles() {
        World world = new World(800, 600);
        world.addObstacle(obstacleFactory.createSquare(100));
        world.addObstacle(obstacleFactory.createPentagon(100));
        world.addObstacle(obstacleFactory.createEquilateralTriangle(100));
        Agent robot = new TwoWheeledRobot();
        world.addAgent(robot, world.getRandomPosition());
    }
}