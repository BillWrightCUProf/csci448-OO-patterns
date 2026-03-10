package ooconcepts.wrongvariabletype;

abstract public class Creature {
    private static Double health;
    private static int radioActiveLevel;
    private static String name;

    Creature(String newName, Double newHealth, int newRadioActiveLevel) {
        this.name = newName;
        this.health = newHealth;
        this.radioActiveLevel = newRadioActiveLevel;
    }

    public String getName() {
        return name;
    }
}