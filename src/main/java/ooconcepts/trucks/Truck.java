package ooconcepts.trucks;

public abstract class Truck {
    Engine engine;
    String modelName;

    public Truck() {
        this.modelName = "F150";
        this.engine = new Engine();
    }

    Truck(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String toString() {
        return modelName + " with " + engine;
    }
}
