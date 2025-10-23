package examples.template;

public class Adventurer {
    public void adventure() {
        explore();
        fight();
        findTreasure();
        runAway();
    }

    public void explore() { System.out.println("Exploring the for treasure..."); }
    public void fight() { System.out.println("Fighting the creature..."); }
    public void findTreasure() { System.out.println("Collecting the treasure..."); }
    public void runAway() { System.out.println("Escaping to another room..."); }
}
