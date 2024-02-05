package ooconcepts;

public abstract class Truck {
    Engine engine;

    public Truck() {
        this.engine = new Engine();
    }

    Truck(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
