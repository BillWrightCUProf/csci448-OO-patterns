package examples.factory.solution.composition;

public class FlyBehaviorFactory {
    public FlyBehavior createFlyWithWingsBehavior() {
        return new FlyWithWings();
    }

    public FlyBehavior createNoFlyBehavior() {
        return new CannotFly();
    }

    public FlyBehavior createWalkBehavior() {
        return new Walk();
    }
}
