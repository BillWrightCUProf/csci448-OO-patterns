package examples.template;

public class Adventurer {
    public void explore() { System.out.println("Exploring the dungeon..."); }
    public void fight() { System.out.println("Fighting the dragon..."); }
    public void loot() { System.out.println("Looting the treasure..."); }
    public void escape() { System.out.println("Escaping the dungeon..."); }

    public final void adventure() {
        explore();
        fight();
        loot();
        escape();
    }
}
