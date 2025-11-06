package webots;

public abstract class Agent {
    int width = 5;
    int length = 5;
    int heading = 0;

    public Agent(int heading) {
        this.heading = heading;
    }
}
