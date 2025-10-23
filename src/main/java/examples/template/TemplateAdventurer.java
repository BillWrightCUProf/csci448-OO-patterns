package examples.template;

public class TemplateAdventurer extends MazeDweller {
    @Override
    void collectItems() { System.out.println("Collecting the treasure..."); }
    public void move() { System.out.println("Escaping to another room..."); }
}
