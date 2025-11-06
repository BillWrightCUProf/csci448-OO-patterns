package webots;

public abstract class Agent {
    int width = 5;
    int length = 5;

    World world;

    public Agent(World world) {
        this.world = world;
    }
}
