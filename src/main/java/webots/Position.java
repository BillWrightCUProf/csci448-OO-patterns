package webots;

public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position translate(Position origin) {
        return new Position(this.x + origin.x,  this.y + origin.y);
    }
}
