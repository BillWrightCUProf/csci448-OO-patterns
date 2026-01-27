package ooconcepts.wrongvariablescope;

abstract public class Creature {
    private static Double staticHealth;
    private static String staticName;
    public static int numberOfInstancesCreated = 0;

    double health;
    String name;

    Creature(String newName, double newHealth) {
        Creature.numberOfInstancesCreated++;
        this.name = newName;
        this.health = newHealth;
    }

    public String getName() {
        return name;
    }
}