package iclickerquestions;

abstract public class Creature {
    private static String name;
    private static Double health;
    private static int radioActiveLevel;

    Creature(String name, Double health, int radioActiveLevel) {
        this.name = name;
        this.health = health;
        this.radioActiveLevel = radioActiveLevel;
    }

    public String getName() {
        return name;
    }
}