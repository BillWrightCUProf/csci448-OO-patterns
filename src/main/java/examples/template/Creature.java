package examples.template;

public class Creature {
    public void seekAndDestroy() {
        searchForPrey();
        attackPrey();
        steal();
        move();
    }

    public void searchForPrey() { System.out.println("Searching the cave..."); }
    public void attackPrey() { System.out.println("Fighting the prey..."); }
    public void steal() { System.out.println("Take things from dwellings..."); }
    public void move() { System.out.println("Move to different room..."); }
}
