package bdd;

public class Body {
    String name;
    int mass;
    Position position;
    Position velocity;

    public Body(String name, int mass) {
        this.mass = mass;
        this.name = name;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
