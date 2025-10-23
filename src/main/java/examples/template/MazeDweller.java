package examples.template;

abstract public class MazeDweller {
    public final void doYourThing() {
        explore();
        engageFoe();
        collectItems();
        move();
    }

    private final void explore() {
        System.out.println("Looking around the cave...");
    }

    private final void engageFoe() {
        System.out.println("Fight the foe...");
    }

    abstract void collectItems();
    abstract void move();
}
