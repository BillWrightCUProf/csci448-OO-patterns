package ooconcepts.trucks;

public class Toyota extends Truck {
    private Engine engine;

    public Toyota() {
        super();
        engine = new Engine();
        super.engine = new TurboEngine();
        modelName = "Tacoma";
        super.modelName = "Tacoma";
    }

    public String toString() {
        return "Toyota " + modelName + " with " + getEngine();
    }
}
